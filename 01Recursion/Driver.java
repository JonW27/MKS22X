import static java.lang.System.out;
import java.lang.Math;
public class Driver{
    public static void main(String[] args){
        out.println(Recursion.name());
        out.println(Recursion.sqrt(100));
        out.println(Recursion.sqrt(37.5));
        out.println(Recursion.sqrt(3.4));
        out.println(Recursion.sqrt(0));
        out.println(Recursion.sqrt(12.26));
        out.println(Recursion.sqrt(Math.PI));
        //out.println(Recursion.sqrt(-5.4));
        out.println(Recursion.sqrt(1424546790));
    }
}