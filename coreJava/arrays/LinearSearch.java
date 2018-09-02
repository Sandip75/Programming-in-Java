package coreJava.arrays;

public class LinearSearch {

	public static void main(String[] args) {
		int[] arr = { 10, 15, 55, 22, 11, 33 };
		int data = 22;
		int index = linearSearch(arr, data);
		System.out.println(index);
	}

	private static int linearSearch(int[] arr, int data) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == data) {
				return i;
			}
		}
		return -1;
	}
}
