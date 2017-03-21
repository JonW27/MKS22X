public class Driver{
    public static void main(String[] args){
        int[] data = {1, 1, 1, 1, 1, 1, 1, 1, 1};
	    System.out.println(Quick.partition(data, 0, data.length-1));
        //System.out.println(Quick.quickselect(data, 3));
    }
}
