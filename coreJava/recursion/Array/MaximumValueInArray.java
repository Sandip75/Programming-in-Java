package coreJava.recursion.Array;

public class MaximumValueInArray {

	public static void main(String[] args) {
		int arr[] = { 5, 44, 9, 1, 18 };
		int ans = maximumValueInArray(arr, 0);
		System.out.println(ans);
	}

	public static int maximumValueInArray(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return Integer.MIN_VALUE;
		}

		int ansPartial = maximumValueInArray(arr, vidx + 1);
		if (arr[vidx] > ansPartial) {
			return arr[vidx];
		} else {
			return ansPartial;
		}
	}
}
