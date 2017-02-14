public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	    board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public void solve(){
        cleanBoard();
        solveH(0, 0, false);
    }

    private boolean solveH(int col, int row, boolean failed){
        System.out.println("The 6:7 Status: "+board[6][7]);
        if(failed){
            System.out.println("a failure happened" + col + " " + (row - 1));
            removeLaser(col, row-1);
            board[col][row-1] = 0;
        }
        else if(col == board.length){
            return true;
        }
        else if(row == board.length - 1 && board[col][row] == 0){
            System.out.println(col +" "+ row + " has been selected for a queen");
            board[col][row] = -1;
            createLaser(col, row);
            return solveH(col+1, 0, false) || false;
        }
        else if(board[col][row] == 0){
            System.out.println(col +" "+ row + " has been selected for a queen");
            board[col][row] = -1;
            createLaser(col, row);
            return solveH(col+1, 0, false) || solveH(col, row+1, true);    
        }
        if(row == board.length - 1){
            System.out.println("A failure (EOL) happened "+col+" "+row);
            board[col][row] = 0;
            removeLaser(col, row-1);
            return false;
        }
        System.out.print(col + " "+ row + " was passed on, ");
        return solveH(col, row+1, false);
    }
    private void createLaser(int col, int row){
        for(int i = col+1; i < board.length; i++){
            System.out.print(i+" "+row+" is temp. unavailable "+board[i][row]+"; ");
            board[i][row] += 1;  
        }
        for(int i = col+1, j = row+1; i < board.length && j < board.length; i++, j++){
            board[i][j] += 1;
            System.out.print(i+" "+j+" is temp. unavailable "+board[i][j]+"; ");
        }
        for(int i = col+1, j = row-1; i < board.length && j >= 0; i++, j--){
            board[i][j] += 1;
            System.out.print(i+" "+j+" is temp. unavailable "+board[i][j]+"; ");
        }
    }
    private void removeLaser(int col, int row){
        for(int i = col+1; i < board.length; i++){
            board[i][row] = validate(board[i][row]);  
        }
        for(int i = col+1, j = row; i < board.length && j < board.length; i++, j++){
            board[i][j] = validate(board[i][row]);
            System.out.print(i+" "+j+" is now available:"+board[i][j]+"; ");
            if(i == 6 && j == 7){
                System.out.println("called 2");
            }
        }
        for(int i = col+1, j = row; i < board.length && j >= 0; i++, j--){
            if(i == 6 && j == 7){
                System.out.println("called 3");
                System.out.println(validate(3));
                System.out.println(board[i][j]);
                System.out.println(validate(board[i][j]));
            }
            board[i][j] = validate(board[i][j]);
            System.out.print(i+" "+j+" is now available:"+board[i][j]+"; ");
        }
    }
    private int validate(int val){
        return val == 0 ? 0 : val - 1;
    }

    private void cleanBoard(){
        for(int i = 0; i < board.length; i++){
            for(int k = 0; k < board.length; k++){
                board[i][k] = 0;
            }
        }       
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	return -1;
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
        String ret = "";
        for(int i = 0; i < board.length; i++){
            for(int k = 0; k < board.length; k++){
                if(board[k][i] >= 0){ // need to switch k and i so that it prints row first
                    ret+= "_";
                }
                else{
                    ret += "Q";
                }
            }
            ret += "\n";
        }
    	return ret;
    }
}