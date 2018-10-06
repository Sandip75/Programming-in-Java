package coreJava.recursion.nQueens;

public class NKnight {

	public static void main(String[] args) {
		boolean[][] board = new boolean[4][4];
		nKnight(board, 1, 1, "");
	}

	static int cou = 0;

	public static void nKnight(boolean[][] board, int cq, int cell_no, String asf) {
		if (cq > board.length) {
			cou++;
			System.out.println(cou + " " + asf);
			return;
		}
		if (cell_no > board.length * board.length) {
			return;
		}
		nKnight(board, cq, cell_no + 1, asf);
		int rno = (cell_no - 1) / board.length;
		int cno = (cell_no - 1) % board.length;
		if (board[rno][cno] == false && isTheKnightSafe(board, rno, cno) == true) {
			board[rno][cno] = true;
			nKnight(board, cq + 1, cell_no + 1, asf + " " + cell_no);
			board[rno][cno] = false;
		}
	}

	private static boolean isTheKnightSafe(boolean[][] board, int row, int col) {

		int[][] check = { { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -1, -2 }, { -2, -1 } };

		for (int ch = 0; ch < check.length; ch++) {
			int rc = row + check[ch][0];
			int cc = col + check[ch][1];
			if (rc >= 0 && cc >= 0 && rc < board.length && cc < board[0].length) {
				if (board[rc][cc] == true) {
					return false;
				}
			}
		}
		return true;
	}
}