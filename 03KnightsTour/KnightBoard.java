public class KnightBoard{
    private int[][] board;
    public KnightBoard(int startingRows, int startingCols){
        board = new int[startingCols][startingRows];
        clear();
    }
    private void clear(){
        for(int i = 0; i < board.length; i++){
            for(int k = 0; k < board.length; k++){
                board[k][i] = 0;
            }
        }
    }
    public void solve(){
        solveH(0,0,1);
    }
    private boolean solveH(int row, int col, int level){
        if(level == board.length){
            return true;
        }
        if(board[col][row] == 0){
            board[col][row] = level;
            if(solveH(row+2, col+1, level+=1) || solveH(row+1, col+2, level+=1) || solveH(row-2, col-1, level+=1) || solveH(row-1, col+2, level+=1)){
                return true;
            }
            board[col][row] = 0;
        }
        return false;
    }
    public String toString(){
        String ret = "";
        for(int i = 0; i < board.length; i++){
            for(int k = 0; k < board.length; k++){
                ret+=board[k][i];
            }
            ret+="\n";
        }
    }
}