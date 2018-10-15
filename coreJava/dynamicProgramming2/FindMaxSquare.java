package coreJava.dynamicProgramming2;

public class FindMaxSquare {

	public static void main(String[] args) {

		int[][] arr = { { 1, 0, 1, 0, 1, 1, 1 }, { 1, 0, 1, 1, 0, 1, 1 }, { 1, 1, 1, 1, 0, 1, 0 },
				{ 0, 1, 1, 1, 1, 0, 0 }, { 1, 0, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 1, 1, 0, 0 },
				{ 1, 0, 1, 1, 1, 0, 1 } };

		findMaxSquare(arr);

	}

	public static void findMaxSquare(int[][] arr) {

		int[][] ans = new int[arr.length][arr[0].length];

		int row = 0;
		int col = 0;
		
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {

				if (i == arr.length - 1 || j == arr[0].length - 1) {
					ans[i][j] = arr[i][j];
				} else {
					if (arr[i][j] == 1) {
						ans[i][j] = arr[i][j] + Math.min(ans[i][j + 1], Math.min(ans[i + 1][j], ans[i + 1][j + 1]));
					}
				}
				
				
			}
		}

		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

		int max = 0;
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				if (max <= ans[i][j]) {
					max = ans[i][j];
					row = i + 1;
					col = j + 1;
				}
			}
		}
		System.out.println("Max Size square is " + max + " at Row and Col : " + row + " " + col);
	}

}
