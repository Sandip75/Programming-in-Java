package coreJava.dynamicProgramming.dynamicProgramming3;

public class LongestIncressingSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		int ans = longestIncressingSubSequence(arr);
		System.out.println(ans);
	}

	public static int longestIncressingSubSequence(int[] arr) {
		int[] ans = new int[arr.length];

		ans[0] = 1;
		int omax = 0;
		for (int i = 0; i < arr.length; i++) {
			ans[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					ans[i] = Math.max(ans[i], ans[j] + 1);
				}
			}
			omax = Math.max(omax, ans[i]);
		}

		return omax;
	}

}
