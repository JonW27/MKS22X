import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;
    private int lineE, lineS;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename){
        lineS = 0;
        lineE = 0;
        try{
            readFile(filename);
        }
        catch(FileNotFoundException e){
            System.out.println("The file in question was not found or is corrupted.");
        }
        setAnimate(false);
        printMaze();
        //COMPLETE CONSTRUCTOR
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

    public void printMaze(){
        String result = "";
        for(int i = 0; i<maze.length; i++){
            for(int k = 0; k<maze[0].length; k++){
                result += maze[i][k];
            }
            result += "\n";
        }
        System.out.println(result);
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;
            startr = lineS;
            for(int i = 0; i<maze[0].length; i++){
                if(maze[lineS][i] == 'S'){
                    startc = i;
                }
            }
            
            //Initialize starting row and startint col with the location of the S. 
            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }

        //COMPLETE SOLVE
        return false; //so it compiles
    }

    private void wait(int millis){
        try{
            Thread.sleep(millis);
        } catch(InterruptedException e){
        }
    }

    private void readFile(String filename) throws FileNotFoundException{
        File infile = new File(filename);// can be a path"/full/path/to/file.txt" 
        Scanner inf = new Scanner(infile);
        Scanner inf2 = new Scanner(infile);
        int lineNumber = 1;
        int count = 0;
        boolean hasStartingPoint = false;
        boolean hasEndingPoint = false;
        int cols = 0;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
            cols = line.length();
            if(line.contains("S")){
                hasStartingPoint = true;
                lineS = count;
            } else if(line.contains("E")){
                hasEndingPoint = true;
                lineE = count;
            }
            count++;
        }
        System.out.println(count+", "+cols);
        maze = new char[count][cols];
        count = 0;
        while(inf2.hasNextLine()){
            String line = inf2.nextLine();
            for(int i = 0; i < line.length(); i++){
                maze[count][i] = line.charAt(i);
            }
            count++;
        }
        if(!hasStartingPoint || !hasEndingPoint){
            System.out.println("Maze requires a starting and an ending point.");
            return;
        }
    }

}