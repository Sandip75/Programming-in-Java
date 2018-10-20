package coreJava.dynamicProgramming.dynamicProgramming3;

public class TargetSum {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 4, 1, 3 };
		int target = 10;
		boolean ans = tagetSum(arr, target);
		System.out.println(ans);

	}

	public static boolean tagetSum(int[] arr, int target) {
		boolean[][] ans = new boolean[arr.length + 1][target + 1];

		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				if (i == 0 && j == 0) {
					ans[i][j] = true;
				} else if (((i - 1) >= 0) && (ans[i - 1][j] == true)) {
					ans[i][j] = true;
				} else if (((i - 1) >= 0) && ((j - arr[i - 1]) >= 0) && (ans[i - 1][j - arr[i - 1]] == true)) {
					ans[i][j] = true;
				} else {
					ans[i][j] = false;
				}
			}
		}
		printTagetSumPath(ans, arr, arr.length, target, "");

		return ans[arr.length][target];
	}

	public static void printTagetSumPath(boolean[][] ans, int[] arr, int i, int j, String asf) {
		if (j == 0) {
			System.out.println(asf);
			return;
		}

		if (i == 0) {
			return;
		}

		if (ans[i - 1][j] == true) {
			printTagetSumPath(ans, arr, i - 1, j, asf);
		}

		if ((j >= arr[i - 1]) && (ans[i - 1][j - arr[i - 1]] == true)) {
			printTagetSumPath(ans, arr, i - 1, j - arr[i - 1], asf + arr[i - 1] + " ");
		}

	}
}
