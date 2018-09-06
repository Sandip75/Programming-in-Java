package coreJava.arrays;

public class IsArrayMirrorInverse {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 2, 0, 1 };
		boolean ans = isArrayMirrorInverse(arr);
		System.out.println(ans);
	}

	public static boolean isArrayMirrorInverse(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			if (arr[val] != i) {
				return false;
			}
		}
		return true;
	}

}
