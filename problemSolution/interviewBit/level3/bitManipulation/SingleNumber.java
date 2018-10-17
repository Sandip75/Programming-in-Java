package problemSolution.interviewBit.level3.bitManipulation;

import java.util.ArrayList;

public class SingleNumber {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(3);
		A.add(1);
		A.add(3);
		A.add(5);
		int ans = singleNumber(A);
		System.out.println(ans);
	}

	public static int singleNumber(final ArrayList<Integer> A) {
		int ans = 0;

		for (int i : A) {
			ans = ans ^ i;
		}

		return ans;
	}
}
