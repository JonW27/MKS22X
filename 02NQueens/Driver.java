public class Driver{
    public static void main(String[] args){
        QueenBoard a = new QueenBoard(10);
        /*a.solve();
        System.out.println(a);*/
        a.countSolutions();
        System.out.println("num solutions: "+a.getSolutionCount());
    }
}