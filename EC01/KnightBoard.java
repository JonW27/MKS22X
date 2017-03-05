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
    public void solveFast(){
        solveHFast(0,0,1);
    }
    private boolean solveH(int row, int col, int level){
        if(level > board.length * board.length){
            return true;
        }
        if(col >= board.length || col < 0 || row >= board.length || row < 0){
            return false;
        }
        if(board[col][row] == 0){
            board[col][row] = level;
            if(solveH(row+2, col+1, level+1) || solveH(row+1, col+2, level+1) || solveH(row-2, col-1, level+1) || 
            solveH(row-1, col+2, level+1) || solveH(row-1, col-2, level+1) || solveH(row+2, col-1, level+1) || 
            solveH(row-2, col+1, level+1) || solveH(row+1, col-2, level+1)){
                return true;
            }
            board[col][row] = 0;
        }
        return false;
    }
    private boolean solveHFast(int row, int col, int level){
        if(level > board.length * board.length){
            return true;
        }
        else if(col >= board.length || col < 0 || row >= board.length || row < 0){
            return false;
        }
        else if(board[col][row] == 0){
            board[col][row] = level;
            // we want the one with the least amount of possible squares.
            int[] loc1 = {row+2, col+1, level+1};
            int[] loc2 = {row+1, col+2, level+1};
            int[] loc3 = {row-2, col-1, level+1};
            int[] loc4 = {row-1, col+2, level+1};
            int[] loc5 = {row-1, col-2, level+1};
            int[] loc6 = {row+2, col-1, level+1};
            int[] loc7 = {row-2, col+1, level+1};
            int[] loc8 = {row+1, col-2, level+1};
            int[][] locations = {loc1, loc2, loc3, loc4, loc5, loc6, loc7, loc8};
            int[] selector = gatherer(locations);
            if(solveH(selector[0], selector[1], selector[2])){
                return true;
            }
            board[col][row] = 0;
        }
        return false;
    }
    private int[] gatherer(int[][] locations){
        int prevCount = 100;
        int[] least = locations[0];
        for(int i = 0; i < locations.length; i++){
            int count = 0;
            int[] loc1 = {locations[i][0]+2, locations[i][1]+1};
            int[] loc2 = {locations[i][0]+1, locations[i][1]+2};
            int[] loc3 = {locations[i][0]-2, locations[i][1]-1};
            int[] loc4 = {locations[i][0]-1, locations[i][1]+2};
            int[] loc5 = {locations[i][0]-1, locations[i][1]-2};
            int[] loc6 = {locations[i][0]+2, locations[i][1]-1};
            int[] loc7 = {locations[i][0]-2, locations[i][1]+1};
            int[] loc8 = {locations[i][0]+1, locations[i][1]-2};
            int[][] dests = {loc1, loc2, loc3, loc4, loc5, loc6, loc7, loc8};
            for(int j = 0; j < locations.length; j++){
                if(canMove(dests[j])){
                    count++;
                }
            }
            if(count > 0 && count < prevCount){
                least = locations[i];
                prevCount = count;
            }     
        }
        return least;
    }
    private boolean canMove(int[] location){
        return location[0] < board.length && location[0] >= 0 && location[1] < board.length && location[1] >= 0 && board[location[0]][location[1]] == 0;
    }
    public String toString(){
        String ret = "";
        for(int i = 0; i < board.length; i++){
            for(int k = 0; k < board.length; k++){
                ret=ret + board[k][i] + " ";
            }
            ret+="\n";
        }
        return ret;
    }
}