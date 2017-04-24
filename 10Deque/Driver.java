public class Driver{
  public static void main(String[] args){
    MyDeque a = new MyDeque();
    a.addFirst("hello");
    a.addLast("bob");
    a.addLast("dumbo");
    //a.removeLast();
    //a.removeFirst();
    a.addLast("life goes on");
    a.addFirst("bob");
    a.removeLast();
    a.addFirst("lo");
    a.addFirst("lol");
    a.addFirst("quagmire");
    a.addFirst("quicksand");
    a.addFirst("aardvark");
    a.addLast("kek");
    a.removeFirst();
    System.out.println(a.getFirst());
    System.out.println(a.getLast());
  }
}
