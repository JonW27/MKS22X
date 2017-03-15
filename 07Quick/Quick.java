import java.util.Random;
public class Quick{
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
    public static int quickselect(int[] data, int k){
	return helper(data, k, 0, data.length-1);
   }
   private static int helper(int[] data, int k, int start, int end){
	int partition = partition(data, start, end);
	if(partition == k){
		return data[k];
	}
	return partition < k ? helper(data, k, start, k) : helper(data, k, k, end);
  }
}
