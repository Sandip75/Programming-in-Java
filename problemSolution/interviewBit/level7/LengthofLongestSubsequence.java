package problemSolution.interviewBit.level7;

import java.util.*;

public class LengthofLongestSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = new ArrayList<>();
		A.add(1);// 1 11 2 10 4 5 2 1
		A.add(11);
		A.add(2);
		A.add(10);
		A.add(4);
		A.add(5);
		A.add(2);
		A.add(1);
		int ans = longestSubsequenceLength(A);
		System.out.println(ans);

	}

	public static int longestSubsequenceLength(final List<Integer> A) {

		int[] ans = new int[A.size()];

		for (int i = 0; i < ans.length; i++) {
			ans[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (A.get(i) >= A.get(j)) {
					ans[i] = Math.max(ans[i], 1 + ans[j]);
				}
			}
		}

		int[] ansD = new int[A.size()];

		for (int i = ansD.length - 1; i >= 0; i--) {
			ansD[i] = 1;
			for (int j = i + 1; j < ansD.length; j++) {
				if (A.get(i) >= A.get(j)) {
					ansD[i] = Math.max(ansD[i], 1 + ansD[j]);
				}
			}
		}
		int max = -1;
		for (int i = 0; i < ans.length; i++) {
			ans[i] = ans[i] + ansD[i];
			if (max < ans[i]) {
				max = ans[i];
			}
		}
		return max - 1;
	}
}
