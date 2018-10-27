package coreJava.dynamicProgramming.dynamicProgramming5;

public class LongestCommenSubsequence {

	public static void main(String[] args) {
		String s1 = "acbg";
		String s2 = "abcg";
		int ans = longestCommenSubsequenceM(s1, s2, new Integer[s1.length() + 1][s2.length() + 1]);
		System.out.println(ans);

		int ans2 = longestCommenSubsequenceT(s1, s2);
		System.out.println(ans2);

	}

	public static int longestCommenSubsequenceM(String s1, String s2, Integer[][] qb) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		if (qb[s1.length()][s2.length()] != null) {
			return qb[s1.length()][s2.length()];
		}

		char ch1 = s1.charAt(0);
		String s1rest = s1.substring(1);
		char ch2 = s2.charAt(0);
		String s2rest = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = 1 + longestCommenSubsequenceM(s1rest, s2rest, qb);
		} else {
			int f1 = longestCommenSubsequenceM(s1, s2rest, qb);
			int f2 = longestCommenSubsequenceM(s1rest, s2, qb);
			ans = Integer.max(f1, f2);
		}
		qb[s1.length()][s2.length()] = ans;
		return ans;
	}

	public static int longestCommenSubsequenceT(String s1, String s2) {
		int[][] ans = new int[s1.length() + 1][s2.length() + 1];

		for (int i = ans.length - 2; i >= 0; i--) {
			for (int j = ans.length - 2; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					ans[i][j] = 1 + ans[i + 1][j + 1];
				} else {
					ans[i][j] = Integer.max(ans[i + 1][j], ans[i][j + 1]);
				}
			}
		}

		return ans[0][0];
	}

}
