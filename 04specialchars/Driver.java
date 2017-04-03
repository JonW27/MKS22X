public class Driver{

    public static void main(String[]args){
        Maze f;
        f = new Maze("data3.dat");//true animates the maze.
        // test the case where its given bad data.

        f.setAnimate(false);
        /*f.printMaze();*/
        f.solve();
        //f.printMaze();
        //System.out.println(f);
    }
}
