package coreJava.recursion.Array;

public class AllIndex {

	public static void main(String[] args) {
		int arr[] = { 5, 44, 44, 1, 44, 18, 44 };
		int ans[] = allIndex(arr, 44, 0, 0);
		for (int val : ans) {
			System.out.print(val + "-->>");
		}
	}

	public static int[] allIndex(int[] arr, int data, int vidx, int count) {
		if (vidx == arr.length) {
			int[] baseArray = new int[count];
			return baseArray;
		}
		if (arr[vidx] == data) {
			count = count + 1;
		}
		int[] ansP = allIndex(arr, data, vidx + 1, count);
		if (arr[vidx] == data) {
			ansP[count - 1] = vidx;
		}
		return ansP;
	}
}
