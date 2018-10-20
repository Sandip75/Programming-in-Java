package coreJava.dynamicProgramming.dynamicProgramming1;

public class MinCostPath {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 5, 3, 5 }, { 4, 2, 2, 6, 0 }, { 0, 8, 1, 1, 4 }, { 4, 0, 2, 5, 100 },
				{ 0, 2, 6, 7, 1 } };
		System.out.println(minCostPath(arr));
	}

	public static int minCostPath(int[][] arr) {
		int[][] ans = new int[arr.length][arr[0].length];

		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {
				if (i == arr.length - 1 && j == arr[0].length - 1) {
					ans[i][j] = arr[i][j];
				} else if (i == arr.length - 1) {
					ans[i][j] = arr[i][j] + ans[i][j + 1];
				} else if (j == arr[0].length - 1) {
					ans[i][j] = arr[i][j] + ans[i + 1][j];
				} else {
					ans[i][j] = arr[i][j] + Math.min(ans[i][j + 1], ans[i + 1][j]);
				}
			}
		}

		return ans[0][0];
	}

}
