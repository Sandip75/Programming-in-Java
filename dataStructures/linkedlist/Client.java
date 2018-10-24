package dataStructures.linkedlist;

public class Client {

	public static void main(String[] args) throws Exception {

		LinkedListG ll = new LinkedListG();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);
		ll.display();
		
		ll.addFirst(5);
		ll.display();
		
		System.out.println(ll.getFirst());
		System.out.println(ll.getLast());
		
		
	}

}
