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
}
