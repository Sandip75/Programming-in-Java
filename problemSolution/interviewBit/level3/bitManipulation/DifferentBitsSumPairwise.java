package problemSolution.interviewBit.level3.bitManipulation;

import java.util.ArrayList;

public class DifferentBitsSumPairwise {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(3);
		A.add(5);
		int ans = differentBitsSumPairwise(A);
		System.out.println(ans);
		int ans2 = differentBitsSumPairwiseBest(A);
		System.out.println(ans2);
	}

	public static int differentBitsSumPairwise(ArrayList<Integer> A) {
		int n = A.size();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = A.get(i) ^ A.get(j);
				int count = 0;
				while (temp != 0) {
					temp = temp & (temp - 1);
					count++;
				}
				ans += 2 * count;
			}
		}
		return ans;
	}

	public static int differentBitsSumPairwiseBest(ArrayList<Integer> A) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			int oneC = 0;
			int zeroC = 0;
			int mask = 1 << i;
			for (int j = 0; j < A.size(); j++) {
				int val = A.get(j);
				if ((val & mask) == mask) {
					oneC++;
				} else {
					zeroC++;
				}
			}
			ans = ans + 2 *oneC * zeroC;
		}
		return ans;
	}

}
