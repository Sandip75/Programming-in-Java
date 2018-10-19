package coreJava.bitManipulation;

public class UniqueNumber {

	public static void main(String[] args) {
		int arr[] = { 9, 5, 3, 9, 3 };
		int ans = uniqueNumber(arr);
		System.out.println(ans);
	}

	public static int uniqueNumber(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans = ans ^ arr[i];
		}
		return ans;
	}
}
