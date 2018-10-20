package coreJava.dynamicProgramming.dynamicProgramming3;

public class KnapSack01 {

	public static void main(String[] args) {
		int[] wt = { 2, 5, 1, 3, 4 };
		int[] price = { 15, 14, 10, 16, 30 };
		int target = 7;
		int ans = knapSack01(wt, price, target);
		System.out.println(ans);
	}

	public static int knapSack01(int[] wt, int[] price, int target) {
		int[][] ans = new int[wt.length + 1][target + 1];

		for (int i = 1; i < ans.length; i++) {
			for (int j = 1; j < ans[0].length; j++) {

				ans[i][j] = ans[i - 1][j];

				if (j >= wt[i - 1]) {
					ans[i][j] = Math.max(ans[i][j], ans[i - 1][j - wt[i - 1]] + price[i - 1]);
				}
			}
		}

		for (int i = 1; i < ans.length; i++) {
			for (int j = 1; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + "  ");
			}
			System.out.println();
		}
		printknapSack01Path(wt, ans, wt.length, target, "");
		return ans[wt.length][target];
	}

	public static void printknapSack01Path(int[] wt, int[][] ans, int i, int j, String asf) {

		if (j == 0) {
			System.out.println(asf);
			return;
		}

		if (j == 0) {
			return;
		}

		if (ans[i - 1][j] == ans[i][j]) {
			printknapSack01Path(wt, ans, i - 1, j, asf);
		} else {
			printknapSack01Path(wt, ans, i - 1, j - wt[i - 1], asf + wt[i - 1] + " ");
		}

	}

}
