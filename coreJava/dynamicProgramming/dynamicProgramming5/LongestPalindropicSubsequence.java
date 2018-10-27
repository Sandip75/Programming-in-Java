package coreJava.dynamicProgramming.dynamicProgramming5;

public class LongestPalindropicSubsequence {

	public static void main(String[] args) {
		String s1 = "abckczbycbhehfjeuhjkjkhajafhewkj";
		// int ans = longestPalindropicSubsequence(s1);
		// System.out.println(ans);
		int ans2 = longestPalindropicSubsequenceM(s1, 0, s1.length() - 1, new int[s1.length() + 1][s1.length() + 1]);
		System.out.println(ans2);
		int ans3 = longestPalindropicSubsequenceT(s1);
		System.out.println(ans3);
	}

	public static int longestPalindropicSubsequence(String s1) {

		if (s1.length() == 0 || s1.length() == 1) {
			return s1.length();
		}

		int ans = 0;
		char chF = s1.charAt(0);
		char chL = s1.charAt(s1.length() - 1);
		String rest = s1.substring(1, s1.length() - 1);

		if (chF == chL) {
			ans = 2 + longestPalindropicSubsequence(rest);
		} else {
			int f1 = longestPalindropicSubsequence(rest + chL);
			int f2 = longestPalindropicSubsequence(chF + rest);
			ans = Math.max(f1, f2);
		}
		return ans;
	}

	public static int longestPalindropicSubsequenceM(String s1, int i, int j, int[][] qb) {

		if (i > j || i == j) {
			return i == j ? 1 : 0;
		}

		if (qb[i][j] != 0) {
			return qb[i][j];
		}

		int ans = 0;
		char chF = s1.charAt(i);
		char chL = s1.charAt(j);

		if (chF == chL) {
			ans = 2 + longestPalindropicSubsequenceM(s1, i + 1, j - 1, qb);
		} else {
			int f1 = longestPalindropicSubsequenceM(s1, i, j - 1, qb);
			int f2 = longestPalindropicSubsequenceM(s1, i + 1, j, qb);
			ans = Math.max(f1, f2);
		}
		qb[i][j] = ans;
		return ans;
	}

	public static int longestPalindropicSubsequenceT(String s1) {
		int[][] ans = new int[s1.length()][s1.length()];

		for (int gap = 0; gap < s1.length(); gap++) {
			for (int i = 0; i + gap < s1.length(); i++) {
				int j = i + gap;
				if (gap == 0) {
					ans[i][j] = 1;
				} else if (gap == 1) {
					if (s1.charAt(i) == s1.charAt(j)) {
						ans[i][j] = 2;
					} else {
						ans[i][j] = 1;
					}
				} else {
					if (s1.charAt(i) == s1.charAt(j)) {
						ans[i][j] = 2 + ans[i + 1][j - 1];
					} else {
						ans[i][j] = Math.max(ans[i][j - 1], ans[i + 1][j]);
					}
				}
				j++;

			}
		}

		for (int i = ans.length - 2; i >= 0; i--) {
			for (int j = ans.length - 2; j >= 0; j--) {
				if (s1.charAt(i) == s1.charAt(j)) {
					ans[i][j] = 2 + ans[i + 1][j + 1];
				} else {
					ans[i][j] = Math.max(ans[i + 1][j], ans[i][j + 1]);
				}
			}
		}

		return ans[0][0];
	}
}
