package dataStructures.genericTree;

import java.util.*;

public class GenericTreeH {

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public GenericTreeH(int[] arr) {
		Stack<Node> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				stack.pop();
			} else {
				Node node = new Node();
				this.size++;
				node.data = arr[i];
				if (stack.size() > 0) {
					stack.peek().children.add(node);
					stack.push(node);
				} else {
					root = node;
					stack.push(node);
				}
			}
		}
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		String s = node.data + "-->>";
		for (Node child : node.children) {
			s += child.data + "  ";
		}
		s += ".";
		System.out.println(s);
		for (Node child : node.children) {
			display(child);
		}
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		int t = 0;
		for (Node child : node.children) {
			t += size2(child);
		}
		return t + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int max = node.data;
		for (Node child : node.children) {
			int tmax = max(child);
			if (tmax > max) {
				max = tmax;
			}
		}
		return max;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int ans = 0;

		for (Node child : node.children) {
			int th = height(child);
			if (ans < th) {
				ans = th;
			}
		}
		return ans + 1;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}
		for (Node child : node.children) {
			boolean tans = find(child, data);
			if (tans == true) {
				return tans;
			}
		}
		return false;
	}

	public ArrayList<Integer> nodeToRootPath(int data) {
		return nodeToRootPath(root, data);
	}

	private ArrayList<Integer> nodeToRootPath(Node node, int data) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (data == node.data) {
			ans.add(node.data);
			return ans;
		}
		for (Node child : node.children) {
			ans = nodeToRootPath(child, data);
			if (ans.size() != 0) {
				ans.add(node.data);
				return ans;
			}
		}
		return ans;
	}

	public void removeAllLeaf() {
		removeAllLeaf(root);
	}

	private void removeAllLeaf(Node node) {

		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node data = node.children.get(i);

			if (data.children.size() == 0) {
				node.children.remove(i);
			} else {
				removeAllLeaf(data);
			}
		}
	}

	public void mirrorImage() {
		mirrorImage(root);
	}

	private void mirrorImage(Node node) {

		for (Node child : node.children) {
			mirrorImage(child);
		}

		int left = 0;
		int right = node.children.size() - 1;
		while (left < right) {

			Node leftN = node.children.get(left);
			Node rightN = node.children.get(right);

			node.children.set(left, rightN);
			node.children.set(right, leftN);

			left++;
			right--;
		}
	}

	public void Linearize() {
		linearize(root);
	}

	private void linearize(Node node) {

		for (Node child : node.children) {
			linearize(child);
		}

		for (int i = node.children.size() - 1; i > 0; i--) {
			Node g = node.children.get(i - 1);
			Node r = node.children.remove(i);
			Node tail = getTail(g);
			tail.children.add(r);
		}
	}

	private Node getTail(Node node) {
		Node tail = node;
		while (tail.children.size() != 0) {
			tail = tail.children.get(0);
		}
		return tail;
	}

	public void Linearize2() {
		linearize2(root);
	}

	private Node linearize2(Node node) {

		if (node.children.size() == 0) {
			return node;
		}

		Node tail = node.children.get(node.children.size() - 1);
		Node itail = linearize2(tail);

		while (node.children.size() > 1) {
			Node r = node.children.remove(node.children.size() - 1);
			Node g = node.children.get(node.children.size() - 1);
			Node stail = linearize2(g);
			stail.children.add(r);
		}
		return itail;
	}

	public static boolean areSimilarShaped(GenericTreeH gt1, GenericTreeH gt2) {
		return areSimilarShaped(gt1.root, gt2.root);
	}

	private static boolean areSimilarShaped(Node node1, Node node2) {
		if (node1.children.size() != node2.children.size()) {
			return false;
		}

		for (int i1 = 0, i2 = 0; i1 < node1.children.size() && i2 < node2.children.size(); i1++, i2++) {
			boolean ans = areSimilarShaped(node1.children.get(i1), node2.children.get(i2));
			if (ans == false) {
				return false;
			}
		}

		return true;
	}

	public static boolean areMirrorImage(GenericTreeH gt1, GenericTreeH gt2) {
		return areMirrorImage(gt1.root, gt2.root);
	}

	private static boolean areMirrorImage(Node node1, Node node2) {
		if (node1.children.size() != node2.children.size()) {
			return false;
		}

		for (int i1 = 0, i2 = node2.children.size() - 1; i1 < node1.children.size() && i2 >= 0; i1++, i2--) {
			boolean ans = areMirrorImage(node1.children.get(i1), node2.children.get(i2));
			if (ans == false) {
				return false;
			}
		}

		return true;
	}

	public boolean isSymmetric() {
		return GenericTreeH.isSymmetric(this, this);
	}

	public static boolean isSymmetric(GenericTreeH gt1, GenericTreeH gt2) {
		return GenericTreeH.isSymmetric(gt1.root, gt2.root);
	}

	private static boolean isSymmetric(Node node1, Node node2) {
		if (node1.children.size() != node2.children.size()) {
			return false;
		}
		int left = 0, right = node2.children.size() - 1;
		while (left < right) {
			boolean ans = isSymmetric(node1.children.get(left), node2.children.get(right));
			if (ans == false) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	private int msSize = 0;
	private int msMin = Integer.MAX_VALUE;
	private int msMax = Integer.MIN_VALUE;
	private int msHeight = 0;

	// Size , min , max , height
	public void multiSolver() {

		msSize = 0;
		msMin = Integer.MAX_VALUE;
		msMax = Integer.MIN_VALUE;
		msHeight = 0;

		multiSolver(root, 1);
		System.out.println(msSize);
		System.out.println(msMin);
		System.out.println(msMax);
		System.out.println(msHeight);
	}

	private void multiSolver(Node node, int depth) {
		msSize++;
		msMin = Math.min(msMin, node.data);
		msMax = Math.max(msMax, node.data);
		msHeight = Math.max(msHeight, depth);

		for (Node child : node.children) {
			multiSolver(child, depth + 1);
		}
	}

	private Integer msPred = null;
	private Integer msSucc = null;
	private Integer pre = null;
	private Integer cur = null;

	// pred , succ ,
	public void multiSolve2(int data) {
		msPred = null;
		msSucc = null;
		pre = null;
		cur = null;
		multiSolver2(root, data);
		System.out.println(msPred);
		System.out.println(msSucc);
	}

	private void multiSolver2(Node node, int data) {

		pre = cur;
		cur = node.data;

		if (cur == data) {
			msPred = pre;
		}
		if (pre != null && pre == data) {
			msSucc = cur;
		}

		for (Node child : node.children) {
			multiSolver2(child, data);
		}

	}

	private Integer msfloor = null;
	private Integer msceil = null;

	// ceil , floor
	public void multiSolve3(int data) {
		msfloor = null;
		msceil = null;
		multiSolver3(root, data);
		System.out.println(msfloor);
		System.out.println(msceil);
	}

	private void multiSolver3(Node node, int data) {

		if (node.data > data) {
			msceil = msceil == null ? node.data : Math.min(msceil, node.data);
		}

		if (node.data < data) {
			msfloor = msfloor == null ? node.data : Math.max(msfloor, node.data);
		}

		for (Node child : node.children) {
			multiSolver3(child, data);
		}

	}

	// pred , succ ,
	public void multiSolve4(int data) {
		msPred = null;
		msSucc = null;
		pre = null;
		cur = null;
		multiSolver4(root, data, 0);
		System.out.println(msPred);
		System.out.println(msSucc);
	}

	private void multiSolver4(Node node, int data, int flag) {
		for (Node child : node.children) {
			multiSolver4(child, data, flag);
		}
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);

		while (queue.size() > 0) {
			Node t = queue.removeFirst();
			System.out.print(t.data + "  ");
			for (Node child : t.children) {
				queue.addLast(child);
			}
		}
		System.out.println();
	}

	public void levelOrderLineWise() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);

		Node node = new Node();
		queue.addLast(node);

		while (queue.size() > 1) {
			Node t = queue.removeFirst();
			if (t.data == 0) {
				queue.addLast(t);
				System.out.println();
			} else {
				System.out.print(t.data + "  ");
				for (Node child : t.children) {
					queue.addLast(child);
				}
			}

		}
		System.out.println();

	}

	public void levelOrderLineWise2() {
		LinkedList<Node> CurQueue = new LinkedList<>();
		LinkedList<Node> PreQueue = new LinkedList<>();
		CurQueue.addLast(root);

		while (CurQueue.size() > 0) {
			Node t = CurQueue.removeFirst();

			System.out.print(t.data + "  ");
			for (Node child : t.children) {
				PreQueue.addLast(child);
			}

			if (CurQueue.size() == 0 && PreQueue.size() > 0) {
				CurQueue = PreQueue;
				PreQueue = new LinkedList<>();
				System.out.println();
			}
		}
		System.out.println();

	}

	public void levelOrderZigZag() {
		LinkedList<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		queue.addLast(root);

		boolean flag = true;

		while (queue.size() > 0) {
			Node t = queue.removeFirst();
			System.out.print(t.data + "  ");

			if (flag == true) {
				for (Node child : t.children) {
					stack.push(child);
				}

			} else {
				for (int i = t.children.size() - 1; i >= 0l; i--) {
					stack.push(t.children.get(i));
				}

			}

			if (queue.size() == 0 && stack.size() > 0) {
				while (stack.size() > 0) {
					queue.addLast(stack.pop());
				}
				System.out.println();
				flag = !flag;
			}
		}
	}

	public int diameter(Node node1, Node node2) {

	}
	
}