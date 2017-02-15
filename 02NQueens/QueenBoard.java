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
	    if(board.length != 2 && board.length != 3){
            solveH(0);
        }    
    }
    // 1 - 1 = 0 also 1 / 1 = 1     2,1 4,3
    private boolean solveH(int col){ // when its late at night and your other very efficient solution is very buggy, you go with the fastest you can write
        if(col == board.length){
            return true;
        }
        for(int row = 0; row < board.length; row++){
            if(board[col][row] == 0){
                addQueen(row,col);
                if(solveH(col+1)){
                    return true;
                }
                //System.out.println("\n");
                //System.out.println("triggered"); // i really want breakpoints // it *&(*^*&((()))) works
                removeQueen(row,col);
            }
        }
        return false;
    }

    private void addQueen(int row, int col){
                board[col][row] = -1;
                for(int i = col+1; i < board.length; i++){
                    board[i][row] += 1;
                }
                for(int i = col+1, j = row+1; i < board.length && j < board.length; i++, j++){
                    board[i][j] += 1;
                    //System.out.println(i + ", " + j + " should be blocked from access.");
                }
                for(int i = col+1, j = row-1; i < board.length && j > 0; i++, j--){
                    board[i][j] += 1;
                }
    }
    
    private void removeQueen(int row, int col){
        board[col][row] = 0;
        for(int i = col+1; i < board.length; i++){
            board[i][row] -= 1;
        }
        for(int i = col+1, j = row+1; i < board.length && j < board.length; i++, j++){
            board[i][j] -= 1;
        }
        for(int i = col+1, j = row-1; i < board.length && j > 0; i++, j--){
            board[i][j] -= 1;
        }
    }

    public void countSolutions(){
        cleanBoard();
        minihelper(0);
    }
    private void minihelper(int col){
        if(col == board.length){
            solutionCount++;
            return;
        }
        for(int i = 0; i < board.length; i++){
            if(board[col][i] == 0){
                addQueen(i, col);
                minihelper(col+1);
                removeQueen(i,col);
            }
        }    
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */

    public int getSolutionCount(){
        if(board.length < 0){
            return -1;
        }
    	else if(board.length == 2 || board[0].length == 3){
            return 0;
        }
        return solutionCount;
    }

    private void cleanBoard(){
        for(int i = 0; i < board.length; i++){
            for(int k = 0; k < board.length; k++){
                board[i][k] = 0;
            }
        }       
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
        Boolean DEBUG = false;
        String ret = "";
        for(int i = 0; i < board.length; i++){
            for(int k = 0; k < board.length; k++){
                if(DEBUG){
                    if(board[k][i] == 0){ // need to switch k and i so that it prints row first
                        ret += "0";
                    }
                    else if(board[k][i] >= 1){
                        ret += "1";
                    }
                    else{
                        ret += "Q";
                    }
                }
                else{
                    if(board[k][i] >= 0){ // need to switch k and i so that it prints row first
                        ret+= "_";
                    }
                    else{
                        ret += "Q";
                    }
                }
            }
            ret += "\n";
        }
    	return ret;
    }
}