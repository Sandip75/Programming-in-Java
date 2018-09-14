package coreJava.arrays;

public class SprialDisplay {

	public static void main(String[] args) {
		int[][] arr = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 }, { 41, 42, 43, 44 } };
		sprialDisplay(arr);
	}

	public static void sprialDisplay(int[][] arr) {
		int rMin = 0;
		int cMin = 0;
		int rMax = arr.length - 1;
		int cMax = arr[0].length - 1;
		int count = arr.length * arr[0].length;

		while (count > 0) {

			for (int i = rMin; i <= rMax; i++) {
				System.out.print(arr[i][cMin]);
				count--;
			}
			cMin++;
			for (int i = cMin; i <= cMax; i++) {
				System.out.print(arr[rMax][i]);
				count--;
			}
			rMax--;
			for (int i = rMax; i <= rMin; i++) {
				System.out.print(arr[i][cMax]);
				count--;
			}
			cMax--;
			for (int i = cMax; i <= cMin; i++) {
				System.out.print(arr[rMin][i]);
				count--;
			}
			rMin++;
		}
	}

}
