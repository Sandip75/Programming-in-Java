package coreJava.recursion.pAndC;

public class PaymentCombination {

	public static void main(String[] args) {
		int[] coins = { 2, 3 , 5,6 };
		int amount = 10;
		paymentCombination(coins, amount,  0, "");

	}

	public static void paymentCombination(int[] coins, int tAmount, int coinIdx,  String asf) {

		if (tAmount == 0) {
			System.out.println(asf);
			return;
		}

		for (int i = coinIdx; i < coins.length; i++) {
			if ( coins[i] <= tAmount) {
				paymentCombination(coins, tAmount - coins[i], i,  asf + coins[i]);
			}
		}
	}

}
