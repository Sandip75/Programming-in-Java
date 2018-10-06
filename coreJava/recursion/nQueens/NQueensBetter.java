package coreJava.recursion.nQueens;

public class NQueensBetter {

	public static void main(String[] args) {
		boolean[][] board = new boolean[4][4];
		nQueensBetter(board, 1, 1, "");
	}

	static int cou = 0;

	public static void nQueensBetter(boolean[][] board, int cq, int cell_no, String asf) {

		if (cq > board.length) {
			cou++;
			System.out.println(cou + " " + asf);

			return;
		}

		for (int i = cell_no; i <= board.length * board.length; i++) {

			int rno = (i - 1) / board.length;
			int cno = (i - 1) % board.length;

			if (board[rno][cno] == false && isTheQueenSafe(board, rno, cno) == true) {
				board[rno][cno] = true;
				nQueensBetter(board, cq + 1, i + 1, asf + i + " ");
				board[rno][cno] = false;
			}
		}
	}

	private static boolean isTheQueenSafe(boolean[][] board, int row, int col) {

		int[][] check = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

		for (int qr = 1; qr < board.length; qr++) {
			for (int ch = 0; ch < check.length; ch++) {

				int rc = row + qr * check[ch][0];
				int cc = col + qr * check[ch][1];

				if (rc >= 0 && cc >= 0 && rc < board.length && cc < board[0].length) {
					if (board[rc][cc] == true) {
						return false;
					}
				}

			}
		}
		return true;
	}
}
