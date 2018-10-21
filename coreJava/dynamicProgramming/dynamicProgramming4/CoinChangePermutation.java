package coreJava.dynamicProgramming.dynamicProgramming4;

public class CoinChangePermutation {

	public static void main(String[] args) {
		int[] coin = { 2, 3, 5, 6 };
		int target = 10;
		int ans = coinChangePermutation(coin, target);
		System.out.println(ans);
	}

	public static int coinChangePermutation(int[] coin, int target) {

		int[] ans = new int[target + 1];
		ans[0] = 1;
		for (int i = 1; i < ans.length; i++) {
			for (int j = 0; j < coin.length; j++) {
				if (i >= coin[j]) {
					ans[i] = ans[i] + ans[i - coin[j]];
				}
			}
		}
		return ans[target];
	}

}
