package coreJava.arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		int ans = binarySearch(arr, 50);
		System.out.println(ans);
	}

	public static int binarySearch(int[] arr, int data) {
		int left = 0;
		int right = arr.length;
		int idx = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] > data) {
				right = mid - 1;
			} else if (arr[mid] < data) {
				left = mid + 1;
			} else {
				idx = mid;
				break;
			}
		}
		return idx;
	}

}
