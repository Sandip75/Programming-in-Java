package dataStructures.linkedlist;

public class LinkedListH {
	private class Node {
		int data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public void addLast(int data) {
		Node node = new Node();
		node.data = data;
		if (this.size == 0) {
			this.head = this.tail = node;
			this.size++;
		} else {
			tail.next = node;
			tail = node;
			this.size++;
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + "  ");
		}
		System.out.println("<<<------->>>");
	}

	public void addFirst(int data) {
		if (this.size() == 0) {
			addLast(data);
			return;
		}
		Node node = new Node();
		node.data = data;
		node.next = head;
		head = node;
		this.size++;
	}

	public int getFirst() {
		if (this.size() == 0) {
			System.out.println("No Data");
			return -1;
		}
		return head.data;
	}

	public int getLast() {
		if (this.size() == 0) {
			System.out.println("No Data");
			return -1;
		}
		return tail.data;
	}

	public int getAt(int idx) {
		if (idx < 0) {
			return -1;
		} else if (idx >= this.size) {
			return -1;
		}
		Node temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	public int removeFirst() {
		if (this.size == 0) {
			return -1;
		} else if (this.size() == 1) {
			Node node = head;
			head = tail = null;
			return node.data;
		}
		int tempdata = head.data;
		Node temp = head;
		head = temp.next;
		temp.next = null;
		this.size--;
		return tempdata;
	}

	public int removeLast() {
		if (this.size == 0) {
			return -1;
		} else if (this.size() == 1) {
			Node node = head;
			head = tail = null;
			this.size--;
			return node.data;
		}
		int tempdata = tail.data;
		Node temp = head;
		for (int i = 0; i < (this.size() - 2); i++) {
			temp = temp.next;
		}
		tail = temp;
		temp.next = null;
		this.size--;
		return tempdata;
	}

	public void addAt(int idx, int data) {
		if (idx < 0 || idx > this.size()) {
			return;
		}
		if (idx == 0) {
			addFirst(data);
			return;
		}
		if (idx == this.size()) {
			addLast(data);
			return;
		}

		Node n = new Node();
		n.data = data;
		Node m1 = getNode(idx - 1);
		Node p1 = m1.next;

		m1.next = n;
		n.next = p1;
		this.size++;
	}

	public int removeAt(int idx) {
		if (idx < 0 || idx >= this.size()) {
			return -1;
		} else if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size() - 1) {
			return removeLast();
		}
		Node m1 = getNode(idx - 1);
		Node n = m1.next;
		Node p1 = n.next;

		m1.next = p1;
		this.size--;
		return n.data;
	}

	private Node getNode(int idx) {
		Node temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	// Question

	public void reverseDataItertive() {
		Node l = head;
		Node r = tail;
		for (int i = 0; i < (this.size() / 2); i++) {
			int temp = r.data;
			r.data = l.data;
			l.data = temp;

			l = l.next;
			r = getNode(this.size() - i - 2);
		}
	}

	public void reversePointerItertive() {
		Node m1 = head;
		Node n = m1.next;
		Node p1 = n.next;

		for (int i = 0; i < this.size() - 1; i++) {
			n.next = m1;
			m1 = n;
			n = p1;
			if (p1 != null) {
				p1 = p1.next;
			}
		}
		// n.next = m1;
		// p1.next = n;
		Node temp = tail;
		tail = head;
		tail.next = null;
		head = temp;
	}

	public boolean IsPalindrome() {
		IsPalindromeLeft = head;
		return IsPalindrome(head);

	}

	private Node IsPalindromeLeft;

	private boolean IsPalindrome(Node right) {
		if (right == null) {
			return true;
		}
		boolean res = IsPalindrome(right.next);
		if (res == true) {
			if (IsPalindromeLeft.data == right.data) {
				IsPalindromeLeft = IsPalindromeLeft.next;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void fold() {
		foldleft = head;
		fold(head, 0);
	}

	private Node foldleft;

	private void fold(Node right, int s) {
		if (right == null) {
			return;
		}
		fold(right.next, s + 1);

		if (s > size / 2) {
			Node temp = foldleft.next;
			foldleft.next = right;
			right.next = temp;
			foldleft = temp;
		}
		if (s == size / 2) {
			tail = right;
			tail.next = null;
		}
	}

	public int mid() {
		Node slow = head;
		Node fast = head.next;

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast.next != null) {
				fast = fast.next;
			}
		}
		return slow.data;
	}

	private Node midNode() {
		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public int kthFromLast(int k) {
		Node slow = head;
		Node fast = head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.data;
	}

	public static LinkedListH mergeTwoSortedLists(LinkedListH l1, LinkedListH l2) {
		LinkedListH l3 = new LinkedListH();

		Node Fll = l1.head;
		Node Sll = l2.head;
		while (Fll != null && Sll != null) {
			if (Fll.data < Sll.data) {
				l3.addLast(Fll.data);
				Fll = Fll.next;
			} else {
				l3.addLast(Sll.data);
				Sll = Sll.next;
			}
		}
		while (Sll != null) {
			l3.addLast(Sll.data);
			Sll = Sll.next;
		}
		while (Fll != null) {
			l3.addLast(Fll.data);
			Fll = Fll.next;
		}
		return l3;
	}

	public static LinkedListH mergSort(LinkedListH list) {
		if (list.head == list.tail) {
			return list;
		}

		Node mid = list.midNode();
		Node midN = mid.next;

		LinkedListH list1 = new LinkedListH();
		list1.head = list.head;
		list1.tail = mid;

		LinkedListH list2 = new LinkedListH();
		list2.head = mid.next;
		list2.tail = list.tail;
		mid.next = null;

		list1 = mergSort(list1);
		list2 = mergSort(list2);
		LinkedListH ll = mergeTwoSortedLists(list1, list2);

		mid.next = midN;

		return ll;
	}

	public void addFirstNode(Node node) {
		if (this.size() == 0) {
			head = tail = node;
			size = 1;
			return;
		}
		node.next = head;
		head = node;
		this.size++;
	}

	public Node removeFirstNode() {
		if (this.size == 0) {
			return null;
		} else if (this.size() == 1) {
			Node node = head;
			head = tail = null;
			size--;
			return node;
		}

		Node temp = head;
		head = head.next;
		temp.next = null; // garbage will not clear
		this.size--;
		return temp;
	}

	public void kthReverse(int k) {

		LinkedListH p = new LinkedListH();
		LinkedListH c = null;

		while (this.size != 0) {

			for (int i = 0; i < k; i++) {
				p.addFirstNode(this.removeFirstNode());
			}

			if (c == null) {
				c = p;
			} else {
				c.tail.next = p.head;
				c.tail = p.tail;
				c.size = c.size + p.size;
			}

			p = new LinkedListH();
		}
		this.head = c.head;
		this.tail = c.tail;
		this.size = c.size;
	}

	public void KthReverse2() {

	}

	public void removeDuplicates() {
		Node nodeF = head;
		Node nodeS = head.next;

		while (nodeS.next != null) {
			if (nodeF.data == nodeS.data) {
				nodeS = nodeS.next;
			} else {
				nodeF.next = nodeS;

				nodeF = nodeS;
				nodeS = nodeF.next;
			}

			if (nodeS.next == null && nodeF.data == nodeS.data) {
				nodeF.next = null;
			}
		}
	}

	public void addLastNode(Node node) {

		if (this.size == 0) {
			this.head = this.tail = node;
			this.size++;
		} else {
			tail.next = node;
			tail = node;
			this.size++;
		}
	}

	public void oddEven() {

		LinkedListH odd = new LinkedListH();
		LinkedListH even = new LinkedListH();

		while (this.size != 0) {
			Node temp = this.removeFirstNode();

			if (temp.data % 2 == 0) {
				even.addLastNode(temp);
			} else {
				odd.addLastNode(temp);

			}

		}
		if (odd.size() > 0 && even.size() > 0) {
			odd.size = odd.size + even.size;
			odd.tail.next = even.head;
			odd.tail = even.tail;

			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size;
		} else if (odd.size() > 0) {
			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size;
		} else {
			this.head = even.head;
			this.tail = even.tail;
			this.size = even.size;

		}
	}

	public static Node commonPoint(LinkedListH l1, LinkedListH l2) {

		Node n1 = l1.head;
		Node n2 = l2.head;

		if (l1.size > l2.size) {
			int k = (l1.size - l2.size);
			while (k != 0) {
				n1 = n1.next;
				k--;
			}
		} else {
			int k = (l2.size - l1.size);
			while (k != 0) {
				n2 = n2.next;
				k--;
			}
		}

	}

	private Node left;

	public void reverseDataRecursive() {
		left = head;
		reverseDataRecursiveHelper(head, 0);
	}

	private void reverseDataRecursiveHelper(Node right, int i) {
		if (right == null) {
			return;
		}
		reverseDataRecursiveHelper(right.next , i + 1);
		if (i >= size / 2) {
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
		}
		left = left.next;

	}

}
