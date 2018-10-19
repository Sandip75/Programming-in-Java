package coreJava.bitManipulation;

public class UniqueNumberTwo {

	public static void main(String[] args) {
		int arr[] = { 9, 5, 3, 9, 9, 3, 3 };
		int ans = uniqueNumber(arr);
		System.out.println(ans);
	}

	public static int uniqueNumber(int[] arr) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			int mask = 1 << i;
			for (int j = 0; j < arr.length; j++) {
				if ((arr[j] & mask) == mask) {
					count++;
				}
			}
			count = count % 3;
			if (count != 0) {
				ans = ans | mask;
			}
		}
		return ans;
	}
}
