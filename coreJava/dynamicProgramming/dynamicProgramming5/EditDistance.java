package coreJava.dynamicProgramming.dynamicProgramming5;

public class EditDistance {

	public static void main(String[] args) {
		String s1 = "abcdeghi";
		String s2 = "acdfgkhi";
		int ans = editDistanceM(s1, s2, new Integer[s1.length() + 1][s2.length() + 1]);
		System.out.println(ans);

		int ans2 = editDistanceT(s1, s2);
		System.out.println(ans2);
	}

	public static int editDistanceM(String s1, String s2, Integer[][] qb) {

		if (s1.length() == 0) {
			return s2.length(); // delete
		} else if (s2.length() == 0) {
			return s1.length(); // add
		}

		if (qb[s1.length()][s2.length()] != null) {
			return qb[s1.length()][s2.length()];
		}

		char ch1 = s1.charAt(0);
		String restS1 = s1.substring(1);
		char ch2 = s2.charAt(0);
		String restS2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = editDistanceM(restS1, restS2, qb);
		} else {
			// Add
			int f1 = editDistanceM(restS1, s2, qb);
			// Delete
			int f2 = editDistanceM(s1, restS2, qb);
			// Replace
			int f3 = editDistanceM(restS1, restS2, qb);

			ans = 1 + Math.min(f1, Math.min(f2, f3));
		}
		qb[s1.length()][s2.length()] = ans;
		return ans;
	}

	public static int editDistanceT(String s1, String s2) {
		int[][] ans = new int[s1.length() + 1][s2.length() + 1];

		for (int i = ans.length - 1; i >= 0; i--) {
			for (int j = ans[0].length - 1; j >= 0; j--) {
				if (i == (ans.length - 1) && j == (ans[0].length - 1)) {
					ans[i][j] = 0;
				} else if (i == (ans.length - 1)) {
					ans[i][j] = ans[i][j + 1] + 1;
				} else if (j == (ans[0].length - 1)) {
					ans[i][j] = ans[i + 1][j] + 1;
				} else if (s1.charAt(i) == s2.charAt(j)) {
					ans[i][j] = ans[i + 1][j + 1];
				} else {
					ans[i][j] = 1 + Math.min(ans[i + 1][j], Math.min(ans[i][j + 1], ans[i + 1][j + 1]));
				}
			}
		}
		return ans[0][0];
	}
}
