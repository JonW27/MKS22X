import java.util.ArrayList;
import java.util.NoSuchElementException;
public class MyHeap{
    private int size;
    private int constant;
    private ArrayList<Integer> heap;
    MyHeap(){
        heap = new ArrayList<Integer>();
        constant = 1;
    }
    MyHeap(boolean maxmin){
        heap = new ArrayList<Integer>();
        if(maxmin){
            constant = 1;
        }
        else{
            constant = -1;
        }
    }
    public void add(Integer s){
        heap.add(s);
        pushUp(heap.size()-1);
    }
    public int size(){
        return heap.size();
    }
    public Integer remove(){
        if(heap.size() < 0){
            throw new NoSuchElementException();
        }
        Integer temp = heap.get(0);
        heap.remove(0);
        return temp;
    }
    public Integer peek(){
	    return heap.get(0);
    }
    private void pushUp(int pos){
        if(constant == -1){
            while(pos >= 1 && heap.get(pos).compareTo(heap.get(pos/2)) < 0){
                swap(pos, pos/2);
                pos = pos / 2;
            }   
        }
        else{
            while(pos >= 1 && heap.get(pos).compareTo(heap.get(pos/2)) > 0){
                swap(pos, pos/2);
                pos = pos / 2;
            }
        }
    }    
    private void pushDown(int pos){
        if(constant == -1){
            while(pos*2 < heap.size()-1 && heap.get(pos).compareTo(heap.get(2*pos)) < 0){
                swap(pos, pos*2);
                pos = pos*2;
            }
        }
        else{
            while(pos*2 < heap.size()-1 && heap.get(pos).compareTo(heap.get(2*pos)) > 0){
                swap(pos, pos*2);
                pos = pos*2;
            }
        }
    }
    private void swap(int pos1, int pos2){
        Integer temp = heap.get(pos1);
        heap.set(pos1, heap.get(pos2));
        heap.set(pos2, temp);
    }
    public String toString(){
        String result = "[";
        for(int i = 0; i < heap.size(); i++){
            if(heap.get(i) == null){
                result += " null ";
            }
            else{
                result += " " + heap.get(i) + " ";
            }
        }
        return result + "]";
    }
}
