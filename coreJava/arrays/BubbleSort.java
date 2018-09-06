package coreJava.arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 10, 15, 2, -1, 7 };
		bubbleSort(arr);
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 1; i < arr.length ; i++) {
			for (int j = 0; j < (arr.length - i ); j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
