package coreJava.dynamicProgramming.dynamicProgramming4;

public class CoinChangeCombination {

	public static void main(String[] args) {
		int[] coin = { 2, 3, 5, 6 };
		int target = 10;
		int ans = coinChangeCombination(coin, target);
		System.out.println(ans);
	}

	private static int coinChangeCombination(int[] coin, int target) {

		int[] ans = new int[target + 1];
		ans[0] = 1;
		for (int i = 0; i < coin.length; i++) {
			for (int j = coin[i]; j < ans.length; j++) {
				ans[j] = ans[j] + ans[j - coin[i]];
			}
		}

		return ans[target];
	}

}
