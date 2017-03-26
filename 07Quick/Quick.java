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
        int pivot = rand.nextInt(end-start) + start + 1; // this 1 literally took most of my time debugging <- CHANGED
        int v = data[pivot];
        int i = start;
        int lt = start;
        int gt = end;
        //System.out.println(Arrays.toString(data));
        swap(data, pivot, start);
        while(i < gt + 1){
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
        if(k == 0 && lt == start+1){
            return (data[start+1] > data[start]) ? data[start] : data[start+1]; 
        }
        else if(k >= lt && k <= gt){ // this took the majority of the time, the && symbols
            return data[k];
        }
        return (k > lt) ? part(data, k, gt, end) : part(data, k, start, lt-1);

        /*int[] part = new int[end-start+1];
        System.arraycopy(data, 0, part, 0, end-start+1);
        System.out.println("\nSTART: "+start+"\n END: "+end);
        System.out.println("LOW BOUND: "+lt+"\n HIGH BOUND: "+gt);
        System.out.println("PIVOT VAL: "+v+"\n");
        System.out.println(Arrays.toString(part));
        System.out.println((lt + gt) / 2);
        return (lt + gt) / 2;*/ // don't need modulo since java int division be like this

    }


    public static int quickselect(int[] ary, int k){
        if(ary.length != 0){
            return part(ary, k, 0, ary.length-1);
        }
        return 0; // can't select a value from a null set
   }

    public static void helper(int[] data, int start, int end){
        if(start >= end){
            return; // base case
        }
        //System.out.println("END: "+end+"START: "+start+"DIFF: "+(end-start));
        int pivot = rand.nextInt(end-start) + start + 1; // this 1 literally took most of my time debugging <- CHANGED
        int v = data[pivot];
        int i = start;
        int lt = start;
        int gt = end;
        //System.out.println(Arrays.toString(data));
        swap(data, pivot, start);
        while(i < gt + 1){
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
        if(lt > 0){
            helper(data, start, lt - 1);
        }
        helper(data, gt, end);
    }

    public static void quicksort(int[] ary){
        if(ary.length != 0){
            helper(ary, 0, ary.length-1);
        }
        return; 
    }


}
