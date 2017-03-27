import java.util.Arrays;
public class Merge{
    public static void mergesort(int[] ary){
        if(ary.length <= 1){ // need to cover for empty array case too
            return;
        }
        else{
            int[] left = Arrays.copyOf(ary, ary.length / 2);
            int[] right = Arrays.copyOfRange(ary, ary.length / 2, ary.length);
            mergesort(left);
            mergesort(right);
            merge(left, right, ary);
        }
    }
    private static void merge(int[] a, int[] b , int[] dest){
        int length = b.length - a.length < 0 ? b.length: a.length;
        int count = 0;
        for(int i = 0; i < length; i++){
                for(int j = count; j <= length + 1; j++){
                    if(j >= b.length || a[i] <= b[j]){
                        dest[i+j] = a[i];
                        break;
                    }
                    else{
                        dest[i+j] = b[j];
                        count++;
                    }
                }
        }
        for(int i = length+count, co = 0; i < dest.length; i++, co++){
            dest[i] = b[co+count];
        }
    }
}