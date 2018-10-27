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
		System.out.println(ll.getAt(4));

		ll.addAt(35, 4);
		ll.display();

		System.out.println(ll.removeFirst());
		ll.display();
		System.out.println(ll.removeLast());
		ll.display();

	}

}
