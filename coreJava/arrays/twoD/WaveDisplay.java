package coreJava.arrays.twoD;

public class WaveDisplay {

	public static void main(String[] args) {
		int[][] arr = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 }, { 41, 42, 43, 44 } };
		waveDisplay(arr);
	}

	public static void waveDisplay(int[][] arr) {
		for (int j = 0; j < arr[0].length; j++) {
			if (j % 2 == 0) {
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[j][i] + "  ");
				}
			} else {
				for (int i = arr.length - 1; i >= 0; i--) {
					System.out.print(arr[j][i] + "  ");
				}
			}
		}
	}
}