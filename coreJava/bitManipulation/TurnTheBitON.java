package coreJava.bitManipulation;

public class TurnTheBitON {

	public static void main(String[] args) {
		int n = 75;
		int k = 2;
		System.out.println(Integer.toBinaryString(n));
		int ans = turnTheBitON(n, k);
		System.out.println(Integer.toBinaryString(ans));
		System.out.println(ans);
	}

	public static int turnTheBitON(int n, int k) {
		int mask = (1 << k);
		System.out.println(Integer.toBinaryString(mask));
		n = n | mask;
		return n;
	}

}
