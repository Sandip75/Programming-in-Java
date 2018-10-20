package coreJava.dynamicProgramming.dynamicProgramming2;

public class TotalPalndromInString {

	public static void main(String[] args) {

		String ques = "abccbc";
		tps(ques);
	}

	public static void tps(String ques) {

		boolean[][] ans = new boolean[ques.length()][ques.length()];

		for (int gap = 0; gap < ques.length(); gap++) {
			for (int i = 0; i + gap < ans.length; i++) {

				int j = i + gap;

				if (gap == 0) {
					ans[i][j] = true;
				} else if (gap == 1) {
					ans[i][j] = ques.charAt(i) == ques.charAt(j);
				} else {
					ans[i][j] = (ques.charAt(i) == ques.charAt(j)) && (ans[i + 1][j - 1] == true);
				}

				if (ans[i][j] == true) {
					System.out.println(ques.substring(i, j + 1));
				}
			}
		}
	}

}
