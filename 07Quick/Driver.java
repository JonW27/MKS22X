import java.util.Arrays;
import java.lang.Integer;
import java.util.Random;
public class Driver{
    public static void main(String[] args){
    //int[] data = {7, 32, 5, 5, 5, 4, 1, 2, 2, 2, 2, 6, 11, 11, 11, 11, 13, 8, -2, -9};
	int times = Integer.parseInt(args[0]);
    int quicksort = Integer.parseInt(args[1]);
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
        int xSmallestElement = rand.nextInt(length);
        try{
            long startTime = System.nanoTime();
            if(sorted[xSmallestElement] == Quick.quickselect(data, xSmallestElement)){
                //System.out.println("pass");
                pass++;
            }
            else{
                fail++;
            }
            long estimatedTime = (System.nanoTime() - startTime) / 1000000000;
            System.out.println("QUICKSELECT time:"+ estimatedTime+ "s for length "+data.length);
        }catch(Exception e){
            System.out.println("an error was thrown for quickselect");
            fail++;
        }
        try{
            long startTime = System.nanoTime();
            Quick.quicksort(data);
            if(Arrays.equals(sorted, data)){
                pass++;
            }
            long estimatedTime = (System.nanoTime() - startTime) / 1000000000;
            System.out.println("QUICKSORT time: "+ estimatedTime+ "s for length "+data.length);
        }catch(Exception e){
            System.out.println("an error was thrown for quicksort");
            fail++;
        }
    }
    System.out.println("PASS: "+pass);
    System.out.println("FAIL: "+fail);
    //int[] data = {};
    //int[] data = {-21, 1};
    /*int[] samp = {3, 1, -21};*/
    /*System.out.println(Quick.part(samp, 0, samp.length-1));*/
    //int[] data= {1, 1, 1, 1, 1}; // not working for duplicates and negative numbers
    //int[] data = {2, 8, 1};
    //System.out.println(Quick.part(data, 0, 0, data.length-1));
    /*(try{
        System.out.println(Quick.quickselect(data, 0));
        Quick.quicksort(data);
        System.out.println(Arrays.toString(data));
    }catch(Exception f){
        f.printStackTrace();
    }*/
    }
}
