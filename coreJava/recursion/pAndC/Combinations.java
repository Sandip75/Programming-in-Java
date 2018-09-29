package coreJava.recursion.pAndC;

public class Combinations {

	public static void main(String[] args) {
		boolean[] boxes = new boolean[4];
		// combinations(boxes, 2, 0, -1, "");
		combinationsUsingRecursion(4, 0, 2, 0, "");
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

	public static void combinationsUsingRecursion(int totalBox, int currentBox, int totalItem, int currentItem,
			String asf) {

		if (totalItem == currentItem) {
			System.out.println(asf);
			return;
		}

		if (totalBox == currentBox) {
			return;
		}

		combinationsUsingRecursion(totalBox, currentBox + 1, totalItem, currentItem + 1,
				asf + "q" + currentBox + "I" + currentItem + "  ");
		combinationsUsingRecursion(totalBox, currentBox + 1, totalItem, currentItem, asf);
	}
}
