package coreJava.dynamicProgramming.dynamicProgramming4;

public class LongestBiotionicSubSequence {

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		int ans = longestBiotionicSubSequence(arr);
		System.out.println(ans);
	}

	private static int longestBiotionicSubSequence(int[] arr) {
		int[] anslis = new int[arr.length];

		anslis[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			anslis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					anslis[i] = Math.max(anslis[i], anslis[j] + 1);
				}
			}
		}

		int[] anslds = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			anslds[i] = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					anslds[i] = Math.max(anslds[i], anslds[j] + 1);
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			anslis[i] = anslis[i] + anslds[i] - 1;
			if (max < anslis[i]) {
				max = anslis[i];
			}
		}
		return max;
	}
}
