package coreJava.bitManipulation;

public class TurnTheBitON {

	public static void main(String[] args) {
		int n = 25;
		int k = 1;
		System.out.println(Integer.toBinaryString(n));
		int ans = turnTheBitON(n, k);
		System.out.println(Integer.toBinaryString(ans));
		System.out.println(ans);
	}

	public static int turnTheBitON(int n, int k) {
		int mask = (1 << k);
		n = n | mask;
		return n;
	}

	
	 
}
