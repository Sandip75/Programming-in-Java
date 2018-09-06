package coreJava.arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 10, 15, -1, 2, 7 };
		selectionSort(arr);
		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
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
