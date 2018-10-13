package coreJava.dynamicProgramming;

public class GoldMine {

	public static void main(String[] args) {
		int[][] arr = { { 2, 1, 3, 10, 2 }, { 6, 0, 8, 1, 8 }, { 3, 9, 5, 6, 7 }, { 4, 2, 4, 7, 4 },
				{ 1, 5, 0, 2, 3 } };
		System.out.println(goldMine(arr));
	}

	public static int goldMine(int[][] arr) {

		int[][] ans = new int[arr.length][arr[0].length];

		for (int j = arr[0].length - 1; j >= 0; j--) {
			for (int i = arr.length - 1; i >= 0; i--) {
				if (j == arr[0].length - 1) {
					ans[i][j] = arr[i][j];
				} else if (i == arr.length - 1) {
					ans[i][j] = arr[i][j] + Math.max(ans[i - 1][j + 1], ans[i][j + 1]);
				} else if (i == 0) {
					ans[i][j] = arr[i][j] + Math.max(ans[i][j + 1], ans[i + 1][j + 1]);
				} else {
					ans[i][j] = arr[i][j] + Math.max(ans[i - 1][j + 1], Math.max(ans[i][j + 1], ans[i + 1][j + 1]));
				}
			}
		}
		int max = ans[0][0];
		for (int i = 1; i < arr[0].length; i++) {
			if (ans[i][0] > max) {
				max = ans[i][0];
			}
		}
		return max;

	}

}
