package dataStructures.binaryTree;

import java.util.LinkedList;

public class Client {

	public static void main(String[] args) {
		int[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };
		BinaryTree bt = new BinaryTree(arr);
		// bt.display();
		// System.out.println(bt.Size());
		// System.out.println(bt.height());
		// System.out.println(bt.max());
		// System.out.println(bt.find(87));
		// bt.removeLeaf();
		// bt.display();
		int[] arr1 = { 50, 25, 12, 10, -1, 20, -1, -1, -1, 75, 62, 60, -1, -1, 87, -1, -1, -1 };
		BinaryTree bt1 = new BinaryTree(arr1);
		// bt1.SingleChild();
		// bt.rootToNodePathWithTarget(150, 250);
		// bt.NodetoKth(25, 2);

		int[] arr2 = { 0, 11, 21, 31, 41, -1, 42, -1, -1, 32, 43, 51, 61, -1, -1, 52, 62, -1, 63, 71, -1, 72, -1, -1,
				-1, -1, 44, 53, 64, -1, 65, -1, -1, 54, -1, -1, -1, -1, 22, 33, 45, -1, 46, -1, -1, 34, 47, -1, 48, -1,
				-1, -1, -1, 12, 23, -1, 24, -1, -1, -1 };
		// BinaryTree bt2 = new BinaryTree(arr2);
		// bt2.NodetoKth(43, 3);

		int[] pre = { 50, 25, 12, 37, 75, 62, 87 };
		int[] in = { 12, 25, 37, 50, 62, 75, 87 };
		int[] post = { 12, 37, 25, 62, 87, 75, 50 };
		// BinaryTree bt3 = new BinaryTree(pre, in);
		// bt3.display();
		BinaryTree bt4 = new BinaryTree(post, in);
		// bt4.display();

		// Q-->>>Binary Number
		// printBinary(15);

		// Q-->> Itertive
		// bt4.preoi();
		// bt4.inoi();
		// bt4.postoi();

		int[] arr5 = { 50, 25, 12, -1, 37, 30, -1, 46, 45, -1, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };
		BinaryTree bt5 = new BinaryTree(arr5);
		System.out.println(bt5.baleneceHeight());
		System.out.println(bt5.baleneceHeightON());
	}

	public static void printBinary(int n) {

		LinkedList<Pair> queue = new LinkedList<>();
		queue.addLast(new Pair(1, "1"));

		while (queue.size() > 0) {
			Pair rm = queue.removeFirst();
			System.out.println(rm.data + " == " + rm.bin);

			Pair left = new Pair(2 * rm.data, rm.bin + "0");
			Pair right = new Pair(2 * rm.data + 1, rm.bin + "1");

			if (left.data <= n) {
				queue.addLast(left);
			}
			if (right.data <= n) {
				queue.addLast(right);
			}
		}
	}

	private static class Pair {
		int data;
		String bin;

		public Pair(int data, String bin) {
			this.data = data;
			this.bin = bin;
		}
	}
}
