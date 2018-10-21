package coreJava.dynamicProgramming.dynamicProgramming4;

public class UnboundedKnapsack {

	public static void main(String[] args) {
		int[] wt = { 2, 5, 6, 3, 4 };
		int[] price = { 15, 14, 150, 45, 30 };
		int target = 7;
		int ans = unboundedKnapsack(wt, price, target);
		System.out.println(ans);

	}

	public static int unboundedKnapsack(int[] wt, int[] price, int target) {
		int[] ans = new int[target + 1];

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < wt.length; j++) {
				if (i >= wt[j]) {
					ans[i] = Math.max(ans[i], ans[i - wt[j]] + price[j]);
				}
			}
			max = Math.max(max, ans[i]);
		}
		return max;
	}

}
