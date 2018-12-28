package problemSolution.interviewBit.level2.array;

import java.util.ArrayList;

public class NextPermutation {

	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<>();
		al.add(27);
		al.add(18);
		al.add(1);

		System.out.println(al);
		nextPermutation(al);
		System.out.println(al);
	}

	public static void nextPermutation(ArrayList<Integer> a) {

		for (int i = a.size() - 1; i > 0; i--) {
			if (a.get(i) > a.get(i - 1)) {

				int k = i;
				while (k < a.size() - 1) {
					for (int m = a.size() - 1; m > k; m--) {
						if (a.get(m) < a.get(m-1)) {
							swap(a, k, k + 1);
						}
					}
				}

				swap(a, i, i - 1);

				return;
			}
		}
		swap(a, 0, a.size() - 1);
	}

	private static void swap(ArrayList<Integer> a, int i, int j) {
		int temp1 = a.get(i);
		int temp2 = a.get(j);
		a.set(i, temp2);
		a.set(j, temp1);
	}

}
