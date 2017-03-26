import java.util.Random;
import java.util.Arrays;
public class Quick{
    static Random rand = new Random();

    private static void swap(int[] data, int first, int second){
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

    // modified to include dutch partitioning part (as a result it includes int k)
    public static int part(int[] data, int k, int start, int end){
        int pivot = rand.nextInt(end-start) + start + 1; // this 1 literally took most of my time debugging
        int v = data[pivot];
        int i = start;
        int lt = start;
        int gt = end;
        //System.out.println(Arrays.toString(data));
        swap(data, pivot, start);
        while(i < gt+1){
            //System.out.println(Arrays.toString(data));
            //System.out.println("LOW BOUND: "+lt+"\n HIGH BOUND: "+gt);
            if(data[i] == v){
                i++;
            }
            else if(data[i] < v){
                swap(data, i, lt);
                lt++;
                i++;
            }
            else{
                swap(data, i, gt);
                gt--;
            }   
        }
        // stuff to prevent throwing of stackoverflow errors
        if(k == 0 && lt == 1){
            return (data[start+1] > data[start]) ? data[start] : data[start+1]; 
        }
        int[] part = new int[end-start+1];
        System.arraycopy(data, 0, part, 0, end-start+1);
        System.out.println("START: "+start+"\n END: "+end);
        System.out.println("LOW BOUND: "+lt+"\n HIGH BOUND: "+gt);
        System.out.println("PIVOT VAL: "+v+"\n");
        System.out.println(Arrays.toString(part));
        System.out.println((lt + gt) / 2);
        return (lt + gt) / 2; // don't need modulo since java int division be like this

    }


    public static int quickselect(int[] data, int k){
	return helper(data, k, 0, data.length-1);
   }
   private static int helper(int[] data, int k, int start, int end){
	int partition = part(data, k, start, end);
	if(partition == k){
		return data[k];
	}
	return (partition < k) ? helper(data, k, partition+1, end) : helper(data, k, start, partition-1);
  }
}
