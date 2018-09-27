package coreJava.recursion.Array;

public class FindNumberInArray {

	public static void main(String[] args) {
		int arr[] = { 5, 44, 9, 1, 18 };
		boolean ans = findNumberInArray(arr, 1, 0);
		System.out.println(ans);
	}

	public static boolean findNumberInArray(int[] arr, int data, int vidx) {
		if (vidx == arr.length) {
			return false;
		}
		if (arr[vidx] == data) {
			return true;
		}
		boolean ans = findNumberInArray(arr, data, vidx + 1);
		return ans;
	}
}
