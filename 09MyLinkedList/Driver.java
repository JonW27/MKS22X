public class Driver{
	public static void main(String[] args){
		MyLinkedList bob = new MyLinkedList();
		bob.add(8);
		bob.add(7);
		bob.add(-2);
		bob.add(-11);
		bob.add(0);
		bob.add(-7);
		bob.add(985);
		bob.add(0);
		System.out.println(bob.get(2));
		System.out.println(bob);
		bob.set(0, 5);
		System.out.println(bob);
		bob.set(3, -34);
		bob.add(0,2); // index 0 gives problemos
		System.out.println(bob);
		bob.remove(0);
		bob.remove(3);
		System.out.println(bob);
	}
}
