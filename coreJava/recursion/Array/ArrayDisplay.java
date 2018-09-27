package coreJava.recursion.Array;

public class ArrayDisplay {

	public static void main(String[] args) {
		int arr[] = { 5, 4, 9, 1, 18 };
		arrayDisplay(arr, 0);
	}

	public static void arrayDisplay(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		System.out.print(arr[vidx] + "  ");
		arrayDisplay(arr, vidx + 1);
	}

}
