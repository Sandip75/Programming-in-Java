package coreJava.dynamicProgramming.dynamicProgramming2;

public class MinimumPalindromicCut {

	public static void main(String[] args) {
		String ques = "abccbc";
		int ans = minimumPalindromicCut(ques, 0, ques.length());
		System.out.println(ans);

	}

	public static int minimumPalindromicCut(String ques, int i, int j) {

		if (isPalindrom(ques, i, j) == true) {
			return 0;
		}

		int min_cut = Integer.MAX_VALUE;
		for (int cut_point = i; cut_point < j; cut_point++) {
			int c1 = minimumPalindromicCut(ques, i, cut_point);
			int c2 = minimumPalindromicCut(ques, cut_point + 1, j);
			int total_cut = c1 + c2 + 1;

			min_cut = Math.min(total_cut, min_cut);
		}

		return min_cut;
	}

	public static int minimumPalindromicCutM(String ques, int i, int j, Integer[][] qb) {

		if (isPalindrom(ques, i, j) == true) {
			return 0;
		}

		if (qb[i][j] != null) {
			return qb[i][j];
		}
		int min_cut = Integer.MAX_VALUE;
		for (int cut_point = i; cut_point < j; cut_point++) {
			int c1 = minimumPalindromicCutM(ques, i, cut_point ,qb);
			int c2 = minimumPalindromicCutM(ques, cut_point + 1, j,qb);
			int total_cut = c1 + c2 + 1;

			min_cut = Math.min(total_cut, min_cut);
		}

		qb[i][j];
		return min_cut;
	}

	private static boolean isPalindrom(String ques, int i, int j) {

		int left = i;
		int right = j - 1;
		while (left < right) {
			if (ques.charAt(left) != ques.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}
		return true;
	}
}
