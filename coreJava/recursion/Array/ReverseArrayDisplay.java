package coreJava.recursion.Array;

public class ReverseArrayDisplay {

	public static void main(String[] args) {
		int arr[] = { 5, 4, 9, 1, 18 };
		reverseArrayDisplay(arr, 0);
	}

	public static void reverseArrayDisplay(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		reverseArrayDisplay(arr, vidx + 1);
		System.out.print(arr[vidx] + "  ");
	}

}
