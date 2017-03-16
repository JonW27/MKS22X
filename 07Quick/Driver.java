public class Driver{
    public static void main(String[] args){
        int[] data = {8, 4, 3, 2, 0, 0, 1, 6, 6, 5, 5, 5, 5, 5};
	System.out.println(Quick.partition(data, 0, data.length-1));
        System.out.println(Quick.quickselect(data, 13));
    }
}
