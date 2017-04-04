import java.util.*;
public class MyLinkedList{
  LNode start, end;
  int size;

  public MyLinkedList(){
    size = 0;
    //start = new LNode();
    //end = start;
  }
  public boolean add(int value){
    LNode temp = new LNode(value);
    if(size != 0){	
	end.next = temp;
    }
    temp.prev = end;
    end = temp;
    size++;
    return true;
  }
  public int size(){
    return size;
  }
  public int get(int index){
    if(index > size - 1 || index < 0){
      throw new IndexOutOfBoundsException();
    }
    LNode current = start;
    for(int i = 0; i < index; i++){
      current = current.next;
    }
    return current.value;
  }
  public int set(int index, int newValue){
    if(index > size -1 || index < 0){
      throw new IndexOutOfBoundsException();
    }
    LNode current = start;
    for(int i = 0; i < index+1; i++){
      current = current.next;
    }
    int temp = current.value;
    current.value = newValue;
    return temp;
  }
  public int indexOf(int value){
    if(size == 0){ // need to do this due to the creation of a LNode at the beginning for facilitated chaining
      return -1;
    }
    LNode current = start;
    current = current.next;
    for(int i = 0; i < size - 1; i++){
      if(current.value == value){
        return i;
      }
      current = current.next;
    }
    return -1;
  }
  public void add(int index, int value){
    if(index > size - 1 || index < 0){
      throw new IndexOutOfBoundsException();
    }
    LNode current = start;
    LNode temp = new LNode(value);
    for(int i = 0; i < size; i++){
      if(i == index){
        temp.prev = current;
      }
      if(i == index + 1){
        current.prev = temp;
        temp.next = current;
      }
      current = current.next;
    }
    temp.prev.next = temp;
    size++;
  }
  public int remove(int index){
    if(index > size -1 || index < 0){
      throw new IndexOutOfBoundsException();
    }
    LNode current = start;
    int val = -1;
    for(int i = 0; i < size; i++){
      if(i == index + 1){
        val = current.value;
      }
      if(i == index + 2){
        current.prev = current.prev.prev;
        current.prev.next = current;
      }
      current = current.next;
    }
    size--;
    return val;
  }
  private LNode getNthNode(int n){
      if(n <= size / 2){
	  // start from starting position
	  LNode current = start;
	  for(int i = 0; i < n + 1; i++){
	      current = current.next;
	  }
	  return current;
      }
      else{
	  LNode current = end;
	  for(int i = 0; i < n + 1; i++){
	      current = current.prev;
	  }
	  return current;
	  // start from ending position, yay!
      }
  }
  public String toString(){
    if(size == 0){ // need to do this due to the creation of a LNode at the beginning for facilitated chaining
      return "[]";
    }
    String result = "[";
    LNode current = start;
    current = current.next;
    for(int i = 0; i < size - 1; i++){
      result = result + current.value + ", ";
      current = current.next;
    }
    result = result + current.value+"]";
    return result;
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
