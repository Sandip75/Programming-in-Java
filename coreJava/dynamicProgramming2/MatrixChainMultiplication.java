package coreJava.dynamicProgramming2;

public class MatrixChainMultiplication {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50, 60 };
		int ans = matrixChainMultiplication(arr, 0, arr.length - 1);
		System.out.println(ans);
	}

	public static int matrixChainMultiplication(int[] arr, int i, int j) {

		if (i == j - 1) {
			return 0;
		}

		int min_coast = Integer.MAX_VALUE;
		for (int cut = i + 1; cut < j; cut++) {
			int c1 = matrixChainMultiplication(arr, i, cut);
			int c2 = matrixChainMultiplication(arr, cut, j);
			int muc = arr[i] * arr[cut] * arr[j];
			int total_cost = c1 + c2 + muc;

			min_coast = Math.min(min_coast, total_cost);
		}

		return min_coast;
	}

	public static int matrixChainMultiplicationT(int[] arr) {
		int[][] ans = new int[arr.length - 1][arr.length - 1];

		for (int gap = 0; gap < arr.length; gap++) {
			for (int i = 0; i + gap < arr.length; i++) {
				int j = i + gap;

				if (gap == 0) {
					ans[i][j] = 0;
				} else if (gap == 1) {
					ans[i][j] = arr[i - 1] * arr[i] * arr[i + 1];
				} else {
					int mic = Integer.MAX_VALUE;

					for (int k = 1; k <= gap; k++) {

						int c1 = ans[i][i + k - 1];
						int c2 = ans[i + k][j];
						int muc = arr[i] * arr[i + k] * arr[j + 1];
						int tc = c1 + c2 + muc;
						mic = Math.min(mic, tc);

					}

					ans[i][j] = mic;
				}
			}
		}
		return ans[0][arr.length - 1];
	}
}
