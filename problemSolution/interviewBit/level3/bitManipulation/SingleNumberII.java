package problemSolution.interviewBit.level3.bitManipulation;

import java.util.ArrayList;

public class SingleNumberII {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(3);
		A.add(1);
		A.add(3);
		A.add(5);
		A.add(1);
		A.add(3);
		int ans = singleNumberII(A);
		System.out.println(ans);
	}

	public static int singleNumberII(final ArrayList<Integer> A) {
		int ans = 0;

		for (int i = 0; i < 32; i++) {
			int count = 0;
			int x = 1 << i;

			for (int val : A) {
				if ((val & x) == x) {
					count++;
				}
			}

			count = count % 3;
			if (count == 1) {
				ans = ans | x;
			}
		}

		return ans;
	}

}
