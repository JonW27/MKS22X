public class Recursion{
    public static String name(){
        return "10.Wong.Jonathan";
    }
    public static double sqrt(double n){
        if(n < 0){
            throw new IllegalArgumentException();
        }
        return n == 0 ? 0 : helper(n,1, -1);
    }
    private static double helper(double n, double guess, double former){
        return prox(n,guess) || guess == former ? guess : helper(n,((n/guess)+guess)/2, guess);
    }
    private static boolean prox(double n, double guess){
        double threshold = 0.0000000000000000000000000000000000000000000000001;
        double res = n / (guess * guess) - 1;
        return res >= 0 ? res < threshold : (-1 * res) < threshold;
    }
}