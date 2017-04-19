import java.util.*;
public class MyLinkedList implements Iterable<Integer>{
  LNode start, end;
  int size;

  public MyLinkedList(){
    size = 0;
    //start = new LNode();
    //end = start;
  }
  public boolean add(int value){
    LNode temp = new LNode(value);
    addAfter(getNthNode(size-1), temp);
    return true;
  }
  public int size(){
    return size;
  }
  public int get(int index){
    return getNthNode(index).value;
  }
  public int set(int index, int newValue){
    LNode current = getNthNode(index);
    int temp = current.value;
    current.value = newValue;
    return temp;
  }
  public int indexOf(int value){
    if(size == 0){
      return -1;
    }
    LNode current = start;
    for(int i = 0; i < size; i++){
      if(current.value == value){
        return i;
      }
      current = current.next;
    }
    return -1;
  }
  public void add(int index, int value){
    LNode current = getNthNode(index);
    LNode temp = new LNode(value);
    if(index == size){
      addAfter(getNthNode(size-1), temp);
      return;
    }
    if(index != 0){
      addAfter(getNthNode(index-1), temp);
      return;
    }
    else{
      start = temp;
      current.prev = temp;
      temp.next = current;
    }
    size++;
  }
  public int remove(int index){
    LNode current = getNthNode(index);
    if(index == 0){
      start = current.next;
    }
    else if(index == size - 1){
      end = current.prev;
    }
    else{
      current.prev.next = current.next;
      current.next.prev = current.prev;
    }
    size--;
    return current.value;
  }
  private LNode getNthNode(int n){
      if(n > size || n < 0 && size != 0){ // think this over
        throw new IndexOutOfBoundsException();
      }
      if(n <= size / 2){
	      // start from starting position
	      LNode current = start;
	      for(int i = 0; i < n; i++){
	        current = current.next;
	      }
	      return current;
      }
      else{
	      LNode current = end;
	      for(int i = 0; i < size - (n + 1); i++){
	        current = current.prev;
	      }
	      return current;
      }
  }
  private void addAfter(LNode location, LNode toBeAdded){
    if(size == 0){
      start = toBeAdded;
      end = toBeAdded;
    }
    else if(location == null){
      location.next.prev = toBeAdded;
      toBeAdded.next = location.next;
      start = toBeAdded;
    }
    else if(location.next == null){
      location.next = toBeAdded;
      toBeAdded.prev = location;
      end = toBeAdded;
    }
    else{
      location.next.prev = toBeAdded;
      toBeAdded.next = location.next;
      location.next = toBeAdded;
      toBeAdded.prev = location;
    }
    size++;
    //System.out.println(end.value);
  }

  private void remove(LNode target){
    target.prev.next = target.next;
    target.next = target.prev;
  }

  public String toString(){
    if(size == 0){ // need to do this due to the commas
      return "[]";
    }
    String result = "[";
    LNode current = start;
    for(int i = 0; i < size - 1; i++){
      result = result + current.value + ", ";
      current = current.next;
      System.out.println(current.value);
      /*if(i!=size-2){
        System.out.println(current.next);
      }*/
    }
    result = result + current.value+"]";
    return result;
  }

  /*public String debugToString(){
    if(size == 0){ // need to do this due to the commas
      return "[]";
    }
    String result = "[";
    LNode current = start;
    for(int i = 0; i < size - 1; i++){
      result = result + current.value + ", ";
      current = current.next;
    }
    result = result + current.value+"]";
    return result;
  }*/

  @Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			LNode element = start;
      @Override
			public Integer next() {
        if(!hasNext()){
          throw new NoSuchElementException();
        }
				int temp = element.value;
				element = element.next;
				return temp;
			}

			@Override
			public boolean hasNext() {
				return element != null;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

  private class LNode{
    int value;
    LNode next;
    LNode prev;
    public LNode(){

    }
    public LNode(int value){
      this.value = value;
      this.prev = null;
      this.next = null;
    }

  }
}
