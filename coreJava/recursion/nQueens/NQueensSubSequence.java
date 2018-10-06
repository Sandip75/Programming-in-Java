package coreJava.recursion.nQueens;

public class NQueensSubSequence {

	public static void main(String[] args) {
		boolean[][] board = new boolean[4][4];
		nQueensSubSequence(board, 1, 1, "");
	}

	public static void nQueensSubSequence(boolean[][] board, int cq, int cell_no, String asf) {

		if (cq > board.length) {
			System.out.println(asf);
			return;
		}

		if (cell_no == board.length * board.length) {
			return;
		}
		nQueensSubSequence(board, cq, cell_no + 1, asf);

		int rno = (cell_no - 1) / board.length;
		int cno = (cell_no - 1) % board.length;

		if (board[rno][cno] == false && isTheQueenSafe(board, rno, cno) == true) {
			board[rno][cno] = true;
			nQueensSubSequence(board, cq + 1, cell_no + 1, asf + cell_no + " ");
			board[rno][cno] = false;
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
