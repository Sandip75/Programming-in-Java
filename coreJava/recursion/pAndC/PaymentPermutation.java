package coreJava.recursion.pAndC;

public class PaymentPermutation {

	public static void main(String[] args) {
		int[] coins = { 2, 3 ,5,6};
		int amount = 10;
		paymentPermutation(coins, amount, 0, "");

	}

	public static void paymentPermutation(int[] coins, int tAmount, int paid, String asf) {

		if (tAmount == paid) {
			System.out.println(asf);
			return;
		}
		
		for (int i = 0; i < coins.length; i++) {
			if ((paid + coins[i]) <= tAmount) {
				paymentPermutation(coins, tAmount, paid + coins[i], asf + coins[i]);
			}
		}

	}

}
