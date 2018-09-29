package coreJava.recursion.pAndC;

public class Permutations {

	public static void main(String[] args) {
		boolean[] boxes = new boolean[4];
		// permutations(boxes, 2, 0, "");
		permutationUsingBitMasking(0, 4, 2, 0, "");
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

	public static void permutationUsingBitMasking(int choicebm, int totalBox, int totalItems, int CurrentItem,
			String asf) {

		if (totalItems == CurrentItem) {
			System.out.println(Integer.toBinaryString(choicebm));
			System.out.println(asf);
			return;
		}

		for (int i = 0; i < totalBox; i++) {
			if ((choicebm & (1 << i)) == 0) {
				choicebm = choicebm | (1 << i);
				permutationUsingBitMasking(choicebm, totalBox, totalItems, CurrentItem + 1,
						asf + "b" + (i) + "I" + (CurrentItem + 1) + "  ");
				choicebm = choicebm & (~(1 << i));
			}
		}
	}
}
