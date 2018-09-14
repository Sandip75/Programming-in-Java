package problemSolution.interviewBit.level2.array;

import java.util.*;

public class AddOneToNumber {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(0);
		al.add(9);
		al.add(9);
		al.add(9);
		al.add(9);
		al = plusOne(al);
		for (int val : al) {
			System.out.print(val + "  ");
		}
	}

	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		ArrayList<Integer> al = new ArrayList<>();

		int current = 1;
		for (int i = A.size() - 1; i >= 0; i--) {
			current = current + A.get(i);
			if (current / 10 != 0) {
				A.set(i, (current % 10));
				current = current / 10;
			} else {
				A.set(i, current);
				current = current / 10;
				break;
			}
		}

		if (current != 0) {
			A.add(0, current);
		}

		for (int i = 0; i < A.size(); i++) {
			current = A.get(i);
			if (current != 0) {
				break;
			} else {
				A.remove(i);
				i--;
			}
		}
		return A;
	}
}
