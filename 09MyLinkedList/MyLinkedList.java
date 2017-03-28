import java.lang.Integer;
public class MyLinkedList{
    LNode start;
    int size;
    public MyLinkedList(){
	start = new LNode(null);
	size = 0;
    }
    public boolean add(int value){
	LNode current = start;
	return true;
    }
    public String toString(){
	return "for now...";
    }
    public class LNode{
	int value;
	LNode next;
	public LNode(Integer value){
	    this.value = value;
	    this.next = null;
	}
	    
    }
}
