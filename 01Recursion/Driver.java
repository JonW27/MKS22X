import static java.lang.System.out;
import java.lang.Math;
import java.util.Random;
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
        out.println(Recursion.sqrt(144));
        out.println(Recursion.sqrt(289));
        out.println(Recursion.sqrt(341));
        Random a = new Random();
        int truths = 0;
        int falses = 0;
        int times = 50;
        for (int i = 0; i<times; i++){
            double b = Math.abs(a.nextInt(10000000));
            double d = Math.round(Recursion.sqrt(b) * Recursion.sqrt(b));
            boolean c = b == d;
            out.println("Number: "+b+" Generated Result: "+Recursion.sqrt(b)+" Result: "+c);
            if(c){
                truths+=1;
            }
            else{
                falses+=1;
            }
        }
        System.out.println("Report:\nTrue "+truths+"\nFalse "+falses+"\nTotal "+times);
    }
}