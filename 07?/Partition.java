import java.util.Random;
public class Partition{
    static Random rand = new Random();

    private static void swap(int[] data, int first, int second){
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

    public static int partition(int[] data, int start, int end){
        int pivot = rand.nextInt(end-start) + start;
        int i = start;
        swap(data, pivot, end);
        while(start < end){
            if(data[start] < data[end]){
                swap(data, i, start);
                i++;
            }
            start++;
        }
        swap(data, end, i);
        return i;

    }
}