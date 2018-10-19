package coreJava.bitManipulation;

public class TwoUniqueNumber {

	public static void main(String[] args) {
		int arr[] = { 9, 5, 3, 9, 3, 4, 9, 9 };
		twoUniqueNumber(arr);
	}

	public static void twoUniqueNumber(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans = ans ^ arr[i];
		}

		int changingBit = ans & -ans;
		int n1 = 0;
		int n2 = 0;

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & changingBit) != 0) {
				n1 = n1 ^ arr[i];
			} else {
				n2 = n2 ^ arr[i];
			}
		}

		System.out.println(n1);
		System.out.println(n2);
	}
}
