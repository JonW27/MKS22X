public class Driver{

    public static void main(String[]args){
        Maze f;
        f = new Maze("data1.dat");//true animates the maze.
        // test the case where its given bad data.
        
        f.setAnimate(true);
        /*f.printMaze();*/
        f.solve();

        System.out.println(f);
    }
}