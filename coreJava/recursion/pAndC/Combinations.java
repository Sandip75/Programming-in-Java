package coreJava.recursion.pAndC;

public class Combinations {

	public static void main(String[] args) {
		boolean[] boxes = new boolean[4];
		combinations(boxes, 2, 0, -1, "");
	}

	public static void combinations(boolean[] boxes, int titem, int citem, int lastbox, String asf) {

		if (titem == citem) {
			System.out.println(asf);
			return;
		}
		for (int i = lastbox + 1; i < boxes.length; i++) {
			if (!boxes[i]) {
				boxes[i] = true;
				combinations(boxes, titem, citem + 1, i, asf + "B" + i + "I" + (citem + 1) + "  ");
				boxes[i] = false;
			}
		}
	}
}
