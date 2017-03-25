import java.util.Random;
import java.util.Arrays;
public class Quick{
    static Random rand = new Random();

    private static void swap(int[] data, int first, int second){
        int temp = data[first];
        data[first] = data[second];
        data[second] = temp;
    }

    // modified to include dutch partitioning part
    public static int part(int[] data, int start, int end){
        int pivot = rand.nextInt(end-start) + start + 1; // this 1 literally took most of my time debugging
        int v = data[pivot];
        int i = start;
        int lt = start;
        int gt = end;
        swap(data, pivot, start);
        while(i < gt){
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
        return (lt + gt) / 2; // don't need modulo since java int division be like this

    }

    // modified for quickselect
    public static int[] qpart(int[] data, int start, int end){
        int pivot = rand.nextInt(end-start) + start + 1; // this 1 literally took most of my time debugging
        int v = data[pivot];
        int i = start;
        int lt = start;
        int gt = end;
        swap(data, pivot, start);
        while(i < gt){
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
        int[] jello = {i, lt, gt};
        return jello; // don't need modulo since java int division be like this

    }


    public static int quickselect(int[] data, int k){
	return helper(data, k, 0, data.length-1);
   }
   private static int helper(int[] data, int k, int start, int end){
	int[] partition = qpart(data, start, end);
	if(k >= partition[1] && k <= partition[2]){
		return data[k];
	}
    //System.out.println(Arrays.toString(data));
	return (partition[0] < k) ? helper(data, k, k, end) : helper(data, k, start, k);
  }
}
