package dataStructures.binaryTree;

import java.util.*;

public class BinaryTree {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	Node root;
	int size;

	public BinaryTree(int[] arr) {
		Stack<Node> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				stack.pop();
			} else {
				Node node = new Node();
				node.data = arr[i];
				this.size++;

				if (stack.size() == 0) {
					root = node;
				} else if (stack.peek().left == null) {
					stack.peek().left = node;
				} else {
					stack.peek().right = node;
				}
				stack.push(node);
			}
		}
	}

	public void display() {

		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		str += node.left != null ? (node.left.data + " ") : (". ");
		str += node.data + " ";
		str += node.right != null ? (node.right.data + " ") : (" .");

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int Size() {
		return Size(root);
	}

	private int Size(Node node) {
		if (node == null) {
			return 0;
		}
		int ans = Size(node.left) + Size(node.right);
		return ans + 1;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return 0;
		}
		int hl = height(node.left);
		int hr = height(node.right);
		int ans = Math.max(hl, hr) + 1;
		return ans;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int ml = max(node.left);
		int mr = max(node.right);
		int ans = Math.max(node.data, Math.max(ml, mr));
		return ans;

	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		// if (data == node.data) {
		// return true;
		// }
		//
		// boolean fl = find(node.left, data);
		// if (fl == true) {
		// return true;
		// }
		//
		// boolean fr = find(node.right, data);
		// if (fr == true) {
		// return true;
		// }
		//
		// return false;

		boolean found = false;
		found = found || data == node.data;
		found = found || find(node.left, data);
		found = found || find(node.right, data);
		return found;
	}

	public void removeLeaf() {
		// removeLeaf(root, root.left);
		// removeLeaf(root, root.right);
		removeLeaf(null, root);
	}

	private void removeLeaf(Node parent, Node child) {

		if (child == null) {
			return;
		}

		if (child.left == null && child.right == null) {
			if (parent.left != null && parent.left == child) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}

		removeLeaf(child, child.left);
		removeLeaf(child, child.right);

	}

	public void SingleChild() {
		SingleChild(root);
	}

	private void SingleChild(Node node) {
		if (node == null) {
			return;
		}
		if (node.left != null && node.right == null) {
			System.out.println(node.left.data);
		}

		if (node.left == null && node.right != null) {
			System.out.println(node.right.data);
		}

		SingleChild(node.left);
		SingleChild(node.right);

	}

	public void rootToNodePathWithTarget(int low, int high) {
		rootToNodePathWithTarget(root, 0, "", low, high);
	}

	private void rootToNodePathWithTarget(Node node, int sum, String psf, int low, int high) {
		if (node == null || (node.left == null && node.right == null)) {
			sum = sum + node.data;
			if (low < sum && sum < high) {
				System.out.println(psf + " " + node.data + "  ==== " + sum);
			}
			return;
		}
		rootToNodePathWithTarget(node.left, sum + node.data, psf + node.data + " -> ", low, high);
		rootToNodePathWithTarget(node.right, sum + node.data, psf + node.data + " -> ", low, high);
	}

	public void NodetoKth(int data, int k) {
		ArrayList<Node> temp = rootToNodePath(root, data);
		for (int i = 0; i < temp.size(); i++) {
			System.out.print(temp.get(i).data + " ");
		}
		System.out.println();

		kthDown(temp.get(0), k);
		int i = 1;
		k--;

		while (k > 0 && i < temp.size()) {

			if (temp.get(i).left == temp.get(i - 1)) {
				kthDown(temp.get(i).right, k - 1);
			}

			if (temp.get(i).right == temp.get(i - 1)) {
				kthDown(temp.get(i).left, k - 1);
			}

			k--;
			i++;
		}

		if (k == 0 && i < temp.size()) {
			System.out.println(temp.get(i).data);
		}

	}

	private ArrayList<Node> rootToNodePath(Node node, int data) {
		if (node == null) {
			ArrayList<Node> al = new ArrayList<>();
			return al;
		}
		if (node.data == data) {
			ArrayList<Node> al = new ArrayList<>();
			al.add(node);
			return al;
		}
		ArrayList<Node> alL = rootToNodePath(node.left, data);
		if (alL.size() > 0) {
			alL.add(node);
			return alL;
		}
		ArrayList<Node> alR = rootToNodePath(node.right, data);
		if (alR.size() > 0) {
			alR.add(node);
			return alR;
		}

		return new ArrayList<>();
	}

	private void kthDown(Node node, int k) {
		if (node == null) {
			return;
		}

		if (k == 0) {
			System.out.println(node.data);
			return;
		}

		kthDown(node.left, k - 1);
		kthDown(node.right, k - 1);
	}

	public void preO() {
		preO(root);
	}

	private void preO(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + "  ");
		preO(node.left);
		preO(node.right);
	}

	public void inO() {
		inO(root);
	}

	private void inO(Node node) {
		if (node == null) {
			return;
		}
		inO(node.left);
		System.out.print(node.data + "  ");
		inO(node.right);
	}

	public void postO() {
		postO(root);
	}

	private void postO(Node node) {
		if (node == null) {
			return;
		}
		postO(node.left);
		postO(node.right);
		System.out.print(node.data + "  ");
	}

	public BinaryTree(int[] pre, int[] in) {
		// root = Contruct(pre, 0, pre.length - 1, in, 0, in.length - 1);
		root = Contruct1(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node Contruct(int[] pre, int pl, int ph, int[] in, int il, int ih) {

		if (il > ih) {
			return null;
		}

		Node node = new Node();
		node.data = pre[pl];

		int idx = -1;
		for (int i = il; i <= ih; i++) {
			if (in[i] == node.data) {
				idx = i;
				break;
			}
		}
		int plh = idx - il;

		node.left = Contruct(pre, pl + 1, pl + plh, in, il, idx - 1);
		node.right = Contruct(pre, pl + plh + 1, ph, in, idx + 1, ih);
		return node;
	}

	private Node Contruct1(int[] post, int pl, int ph, int[] in, int il, int ih) {

		if (il > ih) {
			return null;
		}

		Node node = new Node();
		node.data = post[ph];

		int idx = -1;
		for (int i = il; i <= ih; i++) {
			if (in[i] == node.data) {
				idx = i;
				break;
			}
		}

		int ilh = idx - il;

		node.left = Contruct1(post, pl, pl + ilh - 1, in, il, idx - 1);
		node.right = Contruct1(post, pl + ilh, ph - 1, in, idx + 1, ih);

		return node;
	}

	private class Pair {
		Node node;
		int cs;

		public Pair(Node node, int cs) {
			this.node = node;
			this.cs = cs;
		}
	}

	public void preoi() {
		Stack<Pair> stack = new Stack<>();
		Pair rP = new Pair(root, 0);
		stack.push(rP);

		while (stack.size() > 0) {
			Pair top = stack.peek();

			// if (top.node == null) {
			// stack.pop();
			// continue;
			// }

			if (top.cs == 0) {
				System.out.print(top.node.data + " ");
			} else if (top.cs == 1) {
				if (top.node.left != null) {
					stack.push(new Pair(top.node.left, 0));
				}
			} else if (top.cs == 2) {
				if (top.node.right != null) {
					stack.push(new Pair(top.node.right, 0));
				}
			} else {
				stack.pop();
			}
			top.cs++;
		}
		System.out.println();
	}

	public void inoi() {
		Stack<Pair> stack = new Stack<>();
		Pair rP = new Pair(root, 0);
		stack.push(rP);

		while (stack.size() > 0) {
			Pair top = stack.peek();

			if (top.cs == 0) {
				if (top.node.left != null) {
					stack.push(new Pair(top.node.left, 0));
				}
			} else if (top.cs == 1) {
				System.out.print(top.node.data + " ");
			} else if (top.cs == 2) {
				if (top.node.right != null) {
					stack.push(new Pair(top.node.right, 0));
				}
			} else {
				stack.pop();
			}
			top.cs++;
		}
		System.out.println();
	}

	public void postoi() {
		Stack<Pair> stack = new Stack<>();
		Pair rP = new Pair(root, 0);
		stack.push(rP);

		while (stack.size() > 0) {
			Pair top = stack.peek();

			if (top.cs == 0) {
				if (top.node.left != null) {
					stack.push(new Pair(top.node.left, 0));
				}
			} else if (top.cs == 1) {
				if (top.node.right != null) {
					stack.push(new Pair(top.node.right, 0));
				}
			} else if (top.cs == 2) {
				System.out.print(top.node.data + " ");
			} else {
				stack.pop();
			}
			top.cs++;
		}
		System.out.println();
	}

	public boolean baleneceHeight() {
		return baleneceHeight(root);
	}

	private boolean baleneceHeight(Node node) {
		if (node == null) {
			return true;
		}
		boolean lans = baleneceHeight(node.left);
		if (lans == false) {
			return lans;
		}
		boolean rans = baleneceHeight(node.right);
		if (rans == false) {
			return rans;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		int diff = Math.abs(rh - lh);
		if (diff >= 2) {
			return false;
		} else {
			return true;
		}
	}

	private class BalPair {
		int height;
		boolean isBal;

		public BalPair(int height, boolean isBal) {
			this.height = height;
			this.isBal = isBal;
		}
	}

	public boolean baleneceHeightON() {
		return baleneceHeightON(root).isBal;
	}

	private BalPair baleneceHeightON(Node node) {
		if (node == null) {
			BalPair bs = new BalPair(0, true);
			return bs;
		}

		BalPair ls = baleneceHeightON(node.left);
		if (ls.isBal == false) {
			return ls;
		}

		BalPair rs = baleneceHeightON(node.right);
		if (rs.isBal == false) {
			return rs;
		}

		int diff = Math.abs(ls.height - rs.height);
		Boolean tempB = diff <= 1 ? true : false;
		int tempH = Math.max(ls.height, rs.height) + 1;
		BalPair bp = new BalPair(tempH, tempB);
		return bp;
	}

}
