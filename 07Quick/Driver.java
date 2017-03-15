public class Driver{
    public static void main(String[] args){
        int[] data = {12, 11, 5, 0, -1, 6};
	System.out.println(Quick.partition(data, 1, 4));
        System.out.println(Quick.quickselect(data, 3));
    }
}
