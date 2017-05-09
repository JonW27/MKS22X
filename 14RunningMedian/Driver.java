import java.util.Arrays;
public class Driver{
    public static void main(String[] args){
        RunningMedian a = new RunningMedian();
        a.add(11);
        a.add(5);
        a.add(12);
        a.add(-3);
        a.add(5);
        a.add(0);
        /*a.add(0);
        a.add(6);
        a.add(6);
        a.add(2);
        a.add(4);*/
        int[] lol = {11, 5, 12, -3, 5, 0, 0, 6, 6, 2, 4};
        Arrays.sort(lol);
        System.out.println(Arrays.toString(lol));
        /*a.add(11);
        a.add(11);
        a.add(11);
        a.add(11);
        a.add(11);
        a.add(11);
        a.add(11);
        a.add(11);
        a.add(11);*/
        System.out.println(a.getMedian()+"");
    }
}