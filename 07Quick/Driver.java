public class Driver{
    public static void main(String[] args){
    //int[] data = {7, 32, 5, 5, 5, 4, 1, 2, 2, 2, 2, 6, 11, 11, 11, 11, 13, 8, -2, -9};
	int[] data = {5, 1, 6, 12, 243, 3, 34, 3243, -21};
    //int[] data = {-21, 1};
    /*int[] samp = {3, 1, -21};*/
    /*System.out.println(Quick.part(samp, 0, samp.length-1));*/
    //int[] data= {1, 1, 1, 1, 1}; // not working for duplicates and negative numbers
    //int[] data = {2, 8, 1};
    System.out.println(Quick.part(data, 0, 0, data.length-1));
    System.out.println("\n");
    try{
        System.out.println(Quick.quickselect(data, 0));
    }catch(Throwable f){
        System.out.println(f.toString());
    }
    }
}
