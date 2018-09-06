package coreJava.arrays;

public class InverseArray {

	public static void main(String[] args) {
		int[] arr = { 3, 0, 1, 4, 2 };
		int[] ans = inverseOfAnArray(arr);
		for (int val : ans) {
			System.out.print(val + "  ");
		}
	}

	public static int[] inverseOfAnArray(int[] arr) {
		int[] inverse = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			inverse[val] = i;
		}
		return inverse;
	}

}
