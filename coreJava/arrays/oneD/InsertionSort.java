package coreJava.arrays.oneD;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 10, 2, 17, -1, 5, 3 };
		insertionSort(arr);
		for (int val : arr) {
			System.out.print(val + "  ");
		}
	}

	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
				} else {
					break;
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] + arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] = arr[i] - arr[j];
	}
}