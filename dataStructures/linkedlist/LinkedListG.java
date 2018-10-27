package dataStructures.linkedlist;

public class LinkedListG {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void addLast(int data) {
		// when list is empty
		if (this.size == 0) {
			this.handleAddWhenSize0(data);
			return;
		}

		// create
		Node node = new Node();

		// set properties
		node.data = data;
		node.next = null;

		// attach
		tail.next = node;

		// summary update
		tail = node;
		this.size++;
	}

	private void handleAddWhenSize0(int data) {
		Node node = new Node();

		node.data = data;
		node.next = null;

		this.head = this.tail = node;
		this.size++;
	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " -->> ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void addFirst(int data) {
		if (this.size == 0) {
			this.handleAddWhenSize0(data);
			return;
		}

		// create
		Node node = new Node();

		// set properties
		node.data = data;
		node.next = this.head;

		// attach

		// summary update
		this.head = node;
		this.size++;
	}

	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Size is empty");
		}
		return head.data;
	}

	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Size is empty");
		}
		return tail.data;
	}

	public int getAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("Size is empty");
		} else if (idx < 0 || idx >= this.size) {
			throw new Exception("Index out of Bound");
		}

		Node node = head;
		for (int i = 0; i < idx; i++) {
			node = node.next;
		}
		return node.data;
	}

	private Node getNode(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("Size is empty");
		} else if (idx < 0 || idx >= this.size) {
			throw new Exception("Index out of Bound");
		}

		Node node = head;
		for (int i = 0; i < idx; i++) {
			node = node.next;
		}
		return node;
	}

	public void addAt(int data, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("Index out of Bound");
		} else if (idx == 0) {
			addFirst(data);
		} else if (idx == this.size) {
			addLast(data);
		} else {

			Node nodeBefore = this.getNode(idx - 1);
			Node nodeafter = nodeBefore.next;

			Node node = new Node();
			node.data = data;

			nodeBefore.next = node;
			node.next = nodeafter;
		}
	}
}
