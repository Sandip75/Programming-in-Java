package coreJava.recursion.Array;

public class FindFirstIndex {

	public static void main(String[] args) {
		int arr[] = { 5, 44, 9, 1, 44, 18 };
		int ans = findFirstIndex(arr, 44, 0);
		System.out.println(ans);
		int ans2 = findFirstIndexBetter(arr, 44, 0);
		System.out.println(ans2);
	}

	public static int findFirstIndex(int[] arr, int data, int vidx) {
		if (vidx == arr.length) {
			return -1;
		}

		int ans = findFirstIndex(arr, data, vidx + 1);
		if (data == arr[vidx]) {
			return vidx;
		} else {
			return ans;
		}
	}

	public static int findFirstIndexBetter(int[] arr, int data, int vidx) {
		if (vidx == arr.length) {
			return -1;
		}
		if (data == arr[vidx]) {
			return vidx;
		}
		int ans = findFirstIndexBetter(arr, data, vidx + 1);
		return ans;
	}

}
