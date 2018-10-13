package coreJava.dynamicProgramming;

public class Maze {

	public static void main(String[] args) {
		System.out.println(mazeHVpathT(3, 3));
	}

	public static int mazeHVpathT(int dr, int dc) {

		int[][] ans = new int[dr + 1][dc + 1];

		for (int i = dr; i >= 0; i--) {
			for (int j = dc; j >= 0; j--) {
				if (i == dr || j == dc) {
					ans[i][j] = 1;
				} else {
					ans[i][j] = ans[i + 1][j] + ans[i][j + 1];
				}
			}
		}

		return ans[0][0];
	}

}
