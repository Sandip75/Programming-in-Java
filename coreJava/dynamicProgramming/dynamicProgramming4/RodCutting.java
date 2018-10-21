package coreJava.dynamicProgramming.dynamicProgramming4;

public class RodCutting {

	public static void main(String[] args) {
		int[] arr = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
		int target = 8;
		int ans = rodCutting(arr, target);
		System.out.println(ans);
	}

	public static int rodCutting(int[] arr, int target) {
		int[] ans = new int[target + 1];

		for (int i = 1; i < ans.length; i++) {
			ans[i] = arr[i];
			int left = 1;
			int right = i - 1;
			while (left <= right) {
				ans[i] = Integer.max(ans[i], ans[left] + ans[right]);
				left++;
				right--;
			}
		}

		return ans[target];
	}

}
