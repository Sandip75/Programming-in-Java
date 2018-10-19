package coreJava.bitManipulation;

public class IsKthBitONorOFF {

	public static void main(String[] args) {
		int n = 25;
		int k = 4;
		// System.out.println(Integer.toBinaryString(n));
		isKthBitONorOFF(n, k);
	}

	public static void isKthBitONorOFF(int n, int k) {

		int mask = (1 << k);

		if ((n & mask) == mask) {
			System.out.println("ON");
		} else {
			System.out.println("OFF");
		}

	}

}