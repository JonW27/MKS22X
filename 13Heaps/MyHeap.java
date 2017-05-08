import java.util.ArrayList;
import java.util.NoSuchElementException;
public class MyHeap{
    private int size;
    private int constant;
    private ArrayList<String> heap;
    MyHeap(){
        heap = new ArrayList<String>();
        constant = 1;
    }
    MyHeap(boolean maxmin){
        heap = new ArrayList<String>();
        if(maxmin){
            constant = 1;
        }
        else{
            constant = -1;
        }
    }
    public void add(String s){
        heap.add(s);
        pushUp(heap.size()-1);
    }
    public String remove(){
        if(heap.size() < 0){
            throw new NoSuchElementException();
        }
        String temp = heap.get(0);
        heap.remove(0);
        pushDown(0);
        return temp;
    }
    public String peek(){
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
        int segundo;
        if(pos == 0){
          segundo = 1;
        }
        else{
          segundo = pos * 2;
        }
        if(constant == -1){
            while(segundo < heap.size()-1 && heap.get(pos).compareTo(heap.get(segundo)) < 0){
                swap(pos, segundo);
                pos = segundo;
            }
        }
        else{
            while(segundo < heap.size()-1 && heap.get(pos).compareTo(heap.get(segundo)) > 0){
                swap(pos, segundo);
                pos = segundo;
            }
        }
    }
    private void swap(int pos1, int pos2){
        String temp = heap.get(pos1);
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
