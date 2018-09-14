package coreJava.arrays;

public class MatrixMultiplication {

	public static void main(String[] args) {
		int[][] one = { { 10, 0, 0 }, { 0, 5, 1 } };
		int[][] two = { { 0, 5, 10, 2 }, { 20, 0, 1, 2 }, { 1, 1, 1, 53 } };
		matrixMultiplication(one, two);
	}

	public static void matrixMultiplication(int[][] one, int[][] two) {
		int r1 = one.length;
		int c1 = one[0].length;
		int r2 = two.length;
		int c2 = two[0].length;

		if (c1 != r2) {
			System.out.println("Matrix Multiplication Not possible ");
			return;
		}
		int[][] ans = new int[r1][c2];
		for (int i = 0; i < r1; i++) {
			for (int j = 0; j < c2; j++) {
				for (int k = 0; k < r1; k++) {
					ans[i][j] += one[i][k] * two[k][j];
				}
			}
		}
		display(ans);
	}

	private static void display(int[][] ans) {
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + "  ");
			}
			System.out.println();
		}
	}

}