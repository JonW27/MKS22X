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
            temp = backtrackWrapper(instruction_sets[i][0], instruction_sets[i][1], instruction_sets[i][2], env);
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
        return aggregated_depth * 72 * 72; // temp
    }
    public static int silver(String filename){
        return -1;
        // so that it compiles
    }
    private static int[][] backtrackWrapper(int startRow, int startCol, int decrement, int[][] board){
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

}