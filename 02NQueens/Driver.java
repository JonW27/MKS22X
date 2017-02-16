public class Driver{
    public static void main(String[] args){
        QueenBoard a = new QueenBoard(4);
        QueenBoard b = new QueenBoard(5);
        QueenBoard c = new QueenBoard(6);
        QueenBoard d = new QueenBoard(7);
        QueenBoard e = new QueenBoard(8);
        QueenBoard f = new QueenBoard(9);
        QueenBoard g = new QueenBoard(10);

        a.solve();
        System.out.println(a);
        /*a.countSolutions();
        System.out.println("num solutions: "+a.getSolutionCount());
        b.countSolutions();
        System.out.println("num solutions: "+b.getSolutionCount());
        c.countSolutions();
        System.out.println("num solutions: "+c.getSolutionCount());
        d.countSolutions();
        System.out.println("num solutions: "+d.getSolutionCount());
        e.countSolutions();
        System.out.println("num solutions: "+e.getSolutionCount());
        f.countSolutions();
        System.out.println("num solutions: "+f.getSolutionCount());
        g.countSolutions();
        System.out.println("num solutions: "+g.getSolutionCount());*/
    }
}