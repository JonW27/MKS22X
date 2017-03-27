import java.util.Arrays;
import java.lang.Integer;
import java.util.Random;
public class Driver{
    public static void main(String[] args){
	int times = Integer.parseInt(args[0]);
    Random rand = new Random();
    int pass = 0;
    int fail = 0;
    for(int i = 0; i < times; i++){
        int length = rand.nextInt(1000000);
        Random rand1 = new Random();
        int[] data = new int[length];
        for(int j = 0; j < length; j++){
            if(rand1.nextInt(3) == 2){
                data[j] = rand1.nextInt(1000) * -1;    
            }
            else{
                data[j] = rand1.nextInt(1000);
            }
        }
        int[] sorted = Arrays.copyOf(data, data.length);
        Arrays.sort(sorted);
        try{
            long startTime = System.nanoTime();
            Merge.mergesort(data);
            if(Arrays.equals(sorted, data)){
                pass++;
            }
            long estimatedTime = (System.nanoTime() - startTime) / 1000000000;
            System.out.println("MERGESORT time: "+ estimatedTime+ "s for length "+data.length);
        }catch(Exception e){
            System.out.println("an error was thrown for quicksort");
            fail++;
        }
    }
    System.out.println("PASS: "+pass);
    System.out.println("FAIL: "+fail);
    }
}
