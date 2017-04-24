import java.util.NoSuchElementException;
public class MyDeque{
  private String[] deckMePlz;
  private int front;
  private int back;
  public MyDeque(){
    deckMePlz = new String[5];
    front = 1; // for now
    back = 2; // for now
  }
  private void resize(){
    String[] temp = new String[deckMePlz.length*2];
    for(int i = front; i< front+deckMePlz.length; i++){
      if(i == 0){
        temp[i] = deckMePlz[i];
      }
      else{
          temp[i] = deckMePlz[i%deckMePlz.length];
      }
    }
    deckMePlz = temp;
    // front and back indices are the same so no problemo
  }
  public void addFirst(String in){
    isNull(in);
    if(checkFirst() == back){
      resize();
      checkFirst();
    }
    deckMePlz[checkFirst()] = in;
    front = checkFirst();
  }

  private int checkFirst(){
    int attempt = front - 1;
    if(attempt < 0){
      attempt = deckMePlz.length - 1;
    }
    return attempt;
  }

  public void addLast(String in){
    isNull(in);
    if(checkLast() == front){
      resize();
      checkLast();
    }

    deckMePlz[checkLast()] = in;
    back = checkLast();
  }

  private int checkLast(){
    int attempt = back + 1;
    if(attempt == deckMePlz.length){
      attempt = 0;
    }
    return attempt;
  }

  public void removeFirst(){
    isEmpty();
    deckMePlz[front] = null;
    System.out.println(front);
    front++;
    if(front == deckMePlz.length){
      front = 0;
    }
  }

  public void removeLast(){
    isEmpty();
    deckMePlz[back] = null;
    //System.out.println(back);
    back--;
    if(back < 0){
      back = deckMePlz.length - 1;
    }
  }

  public String getFirst(){
    isEmpty();
    return deckMePlz[front];
  }

  public String getLast(){
    isEmpty();
    return deckMePlz[back];
  }

  private void isNull(String in){
    if(in == null){
      throw new NullPointerException();
    }
  }

  private void isEmpty(){
    if(deckMePlz[front] == null && deckMePlz[back] == null){
      throw new NoSuchElementException();
    }
  }

}
