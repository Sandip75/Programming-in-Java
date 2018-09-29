package coreJava.recursion.pAndC;

public class Permutations {

	public static void main(String[] args) {
		boolean[] boxes = new boolean[4];
		permutations(boxes, 2, 0, "");
	}

	public static void permutations(boolean[] boxes, int titem, int citem, String asf) {

		if (citem == titem) {
			System.out.println(asf);
			return;
		}
		for (int i = 0; i < boxes.length; i++) {
			if (!boxes[i]) {
				boxes[i] = true;
				permutations(boxes, titem, citem + 1, asf + "B" + i + "I" + (citem + 1) + "  ");
				boxes[i] = false;
			}
		}
	}
}
