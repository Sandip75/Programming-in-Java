package coreJava.bitManipulation;

public class TurnTheBitOFF {

	public static void main(String[] args) {
		int n = 75;
		int k = 3;
		System.out.println(Integer.toBinaryString(n));
		int ans = turnTheBitOFF(n, k);
		System.out.println(Integer.toBinaryString(ans));
		System.out.println(ans);
	}

	public static int turnTheBitOFF(int n, int k) {
		int mask = ( 1 << k ) ; 
		n =  n & (~ mask );
		return 1;
	}

}
