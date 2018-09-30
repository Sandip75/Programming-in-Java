package coreJava.recursion.pAndC;

public class Sudoku {

	public static void main(String[] args) {
		int[][] arr = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		int[] rownos = new int[9];
		int[] colnos = new int[9];
		int[] subM = new int[9];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] != 0) {
					makeChoice(arr, i * arr.length + j + 1, rownos, colnos, subM, arr[i][j]);
				}
			}
		}
		sudoku(arr, 1, rownos, colnos, subM);
	}

	public static void sudoku(int[][] arr, int cellNo, int[] rownos, int[] colnos, int[] subM) {

		if (cellNo == 82) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			return;
		}

		int rno = (cellNo - 1) / arr.length;
		int cno = (cellNo - 1) % arr.length;

		if (arr[rno][cno] == 0) {
			int rowNo = rownos[rno];
			int colNo = colnos[cno];
			int subNo = subM[(rno / 3) * 3 + (cno / 3)];
			int no = rowNo | colNo | subNo;
			for (int choice = 1; choice <= 9; choice++) {
				if ((no & (1 << choice)) == 0) {
					makeChoice(arr, cellNo, rownos, colnos, subM, choice);
					sudoku(arr, cellNo + 1, rownos, colnos, subM);
					unMakeChoice(arr, cellNo, rownos, colnos, subM, choice);
				}
			}
		} else {
			sudoku(arr, cellNo + 1, rownos, colnos, subM);
		}
	}

	public static void makeChoice(int[][] arr, int cellNo, int[] rownos, int[] colnos, int[] subM, int choice) {

		int rno = (cellNo - 1) / arr.length;
		int cno = (cellNo - 1) % arr.length;

		arr[rno][cno] = choice;
		rownos[rno] ^= (1 << choice);
		colnos[cno] ^= (1 << choice);
		subM[(rno / 3) * 3 + (cno / 3)] ^= (1 << choice);
	}

	public static void unMakeChoice(int[][] arr, int cellNo, int[] rownos, int[] colnos, int[] subM, int choice) {
		int rno = (cellNo - 1) / arr.length;
		int cno = (cellNo - 1) % arr.length;

		arr[rno][cno] = 0;
		rownos[rno] ^= (1 << choice);
		colnos[cno] ^= (1 << choice);
		subM[(rno / 3) * 3 + (cno / 3)] ^= (1 << choice);
	}
}
