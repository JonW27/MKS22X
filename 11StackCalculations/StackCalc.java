import java.util.Stack;
import java.lang.Double;
public class StackCalc{
    public static double eval(String in){
        String[] words = in.split(" ");
        Stack queue = new Stack();
        for(int i = 0; i < words.length; i++){
            if(isOp(words[i])){
                Double first = (Double) queue.pop();
                Double second = (Double) queue.pop();
                if(words[i].equals("*")){
                    queue.push((first * second));
                }
                else if(words[i].equals("/")){
                    queue.push((first / second));
                }
                else if(words[i].equals("+")){
                    queue.push((first + second));
                }
                else{
                    queue.push((first - second));
                }     
            }
            else{
                queue.push(Double.parseDouble(words[i]));
            }
        }
        return (double) queue.pop();
    }
    private static boolean isOp(String subset){
        if(subset.length() == 1){
            if(subset.equals("*") || subset.equals("/") || subset.equals("+") || subset.equals("-")){
                return true;
            }
        }
        return false;
    }
}