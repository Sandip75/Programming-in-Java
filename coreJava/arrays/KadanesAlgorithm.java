package coreJava.arrays;

public class KadanesAlgorithm {

	public static void main(String[] args) {
		int[] arr = { 2, 3, -6, 1, 2, 3, -4, 5 };
		int ans = kadanesAlgorithm(arr);
		System.out.println(ans);
	}

	public static int kadanesAlgorithm(int[] arr) {
		int current_sum = arr[0];
		int overall_sum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			current_sum = current_sum + arr[i];
			if (current_sum < arr[i]) {
				current_sum = arr[i];
			}
			if (overall_sum < current_sum) {
				overall_sum = current_sum;
			}
		}
		return overall_sum;
	}
}