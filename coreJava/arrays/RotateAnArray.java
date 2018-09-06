package coreJava.arrays;

public class RotateAnArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 3;
		rotateAnArray(arr, k);
		for (int val : arr) {
			System.out.print(val + "  ");
		}
	}

	public static void rotateAnArray(int[] arr, int k) {
		reverse(arr, 0, arr.length - k - 1);
		reverse(arr, arr.length - k, arr.length-1);
		reverse(arr, 0, arr.length - 1);
	}

	private static void reverse(int[] arr, int left, int right) {
		while (left <= right) {
			swap(arr, left, right);
			left++;
			right--;
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
