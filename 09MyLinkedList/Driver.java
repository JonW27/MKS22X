public class Driver{
	public static void main(String[] args){
		MyLinkedList bob = new MyLinkedList();
		bob.add(8);
		System.out.println(bob.size());
		bob.add(7);
		bob.add(-2);
		bob.add(-11);
		bob.add(0);
		bob.add(-7);
		bob.add(985);
		bob.add(0);
		System.out.println(bob.get(0));
		//System.out.println(bob);
		bob.set(7, 5);
		//System.out.println(bob);
		bob.set(3, -34);
		bob.add(0,2);
		bob.add(2,4);
		//System.out.println(bob);
		bob.remove(0);
		bob.remove(3);
		bob.add(3, 7);
		System.out.println(bob);
		System.out.println(bob.indexOf(8));
	}
}
