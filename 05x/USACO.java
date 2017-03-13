import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
public class USACO{
    public static int bronze(String filename){
        File infile = new File(filename);
        Scanner inf;
        try{
            inf = new Scanner(infile);
        }
        catch(FileNotFoundException e){
            System.out.println("Your file does not appear to exist or is too corrupt to parse");
            return -1;
        }
        int[] settings = new int[4];
        settings[0] = inf.nextInt(); // row init
        settings[1] = inf.nextInt(); // col init
        settings[2] = inf.nextInt(); // elevation
        settings[3] = inf.nextInt(); // number of instruction sets
        int[][] env = new int[settings[0]][settings[1]];
        // board init
        for(int i = 0; i < settings[0]; i++){
            for(int k = 0; k < settings[1]; k++){
                env[i][k] = inf.nextInt();
            }
        }
        // instruction sets
        int[][] instruction_sets = new int[settings[3]][3];
        for(int i = 0; i < settings[3]; i++){
            for(int k = 0; k < 3; k++){
                instruction_sets[i][k] = inf.nextInt();
            }
        }
        ////////////////////////////////////////////////////
        for(int i = 0; i < instruction_sets.length; i++){
            // lets now actually do something with the instruction sets
            int[][] temp = new int[settings[0]][settings[1]];
            temp = stomp(instruction_sets[i][0], instruction_sets[i][1], instruction_sets[i][2], env);
            env = temp.clone();
        }
        int aggregated_depth = 0;
        for(int i = 0; i < settings[0]; i++){
            for(int k = 0; k < settings[1]; k++){
                if(settings[2] - env[i][k] > 0){
                    aggregated_depth += (settings[2] - env[i][k]);
                }
            }
        }
        return aggregated_depth * 72 * 72;
    }
    private static int[][] stomp(int startRow, int startCol, int decrement, int[][] board){
        int[] vals = new int[9];
        int counter = 0;
        for(int i = startRow-1; i < startRow + 2; i++){
            for(int k = startCol-1; k < startCol + 2; k++){
                vals[counter] = board[i][k];
                counter++;
            }
        }
        Arrays.sort(vals);
        int highest = vals[8];
        
        for(int i = startRow - 1; i < startRow + 2; i++){
            for(int k = startCol - 1; k < startCol + 2; k++){
                if(board[i][k] > highest - decrement){
                    board[i][k] = board[i][k] - (decrement - (highest - board[i][k]));
                }
            }
        }
        return board;
    }
    public static int silver(String filename){
        File infile = new File(filename);
        Scanner inf;
        try{
            inf = new Scanner(infile);
        }
        catch(FileNotFoundException e){
            System.out.println("Your file does not appear to exist or is too corrupt to parse");
            return -1;
        }
        int[] settings = new int[4];
        settings[0] = inf.nextInt(); // row init
        settings[1] = inf.nextInt(); // col init
        settings[2] = inf.nextInt(); // time (moves)
        char[][] env = new char[settings[0]][settings[1]];
        // board init
        for(int i = 0; i < settings[0]; i++){
            env[i] = inf.next().toCharArray();
            //System.out.println(env[i]);
        }
        // start and dest
        int[] start = new int[2];
        int[] dest = new int[2];
        start[0] = inf.nextInt();
        start[1] = inf.nextInt();
        dest[0] = inf.nextInt();
        dest[1] = inf.nextInt();
        int[][] representation = new int[settings[0]][settings[1]];
        for(int i = 0; i < settings[0]; i++){
            for(int k = 0; k < settings[1]; k++){
                if(env[i][k] == '*'){
                    representation[i][k] = -1;
                }
                else if(i == start[0]-1 && k == start[1]-1){
                    representation[i][k] = 1;
                }
                else{
                    representation[i][k] = 0;
                }
            }
        }
        ////////////////////////////////////////////////////
        return quickAndDirty(start, dest, representation, settings[2]);
        // so that it compiles
    }
    private static int quickAndDirty(int[] location, int[] destination, int[][] board, int moves){
        int[][] temp;
        for(int i = 0; i < moves; i++){
            temp = new int[board.length][board[0].length];
            for(int k = 0; k < board.length; k++){
                for(int l = 0; l < board[0].length; l++){
                    if(isValid(k,l,board)){
                        temp[k][l] = sumNeighbors(k,l, board);
                    }
                    if(board[k][l] == -1){
                        temp[k][l] = -1;
                    }
                   //debugPrint(temp);  
                }
            }
            board = temp.clone();
        }
        return board[destination[0]-1][destination[1]-1];
    }
    private static int sumNeighbors(int x, int y, int[][] board){
        int sum = 0;
        if(isValid(x + 1, y, board)){
            sum+= board[x+1][y];
        }
        if(isValid(x - 1, y, board)){
            sum+= board[x-1][y];
        }
        if(isValid(x, y + 1, board)){
            sum+= board[x][y+1];
        }
        if(isValid(x, y - 1, board)){
            sum+= board[x][y-1];
        }
        return sum;
    }
    private static boolean isValid(int x, int y, int[][] board){
        return !(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == -1);
    }
    private static void debugPrint(int[][] board){
        String result = "";
        for(int i = 0; i<board.length;i++){
            for(int k = 0; k<board[0].length;k++){
                result += board[i][k];
                result += " ";
            }
            result += "\n";
        }
        System.out.println(result);
    }

}