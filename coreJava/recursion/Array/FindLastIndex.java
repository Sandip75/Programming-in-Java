package coreJava.recursion.Array;

public class FindLastIndex {

	public static void main(String[] args) {
		int arr[] = { 5, 44, 9, 1, 44, 18 };
		int ans = findLastIndex(arr, 44, 0);
		System.out.println(ans);
	}

	public static int findLastIndex(int[] arr, int data, int vidx) {
		if (vidx == arr.length) {
			return -1;
		}
		int ans = findLastIndex(arr, data, vidx + 1);
		if (ans != -1) {
			return ans;
		} else {
			if (data == arr[vidx]) {
				return vidx;
			} else {
				return ans;
			}
		}
	}
}