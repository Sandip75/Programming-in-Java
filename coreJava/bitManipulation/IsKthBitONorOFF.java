package coreJava.bitManipulation;

public class IsKthBitONorOFF {

	public static void main(String[] args) {
		int n = 57;
		int k = 4;
		System.out.println(Integer.toBinaryString(n));
		isKthBitONorOFF(n, k);

	}

	public static void isKthBitONorOFF(int n, int k) {
		int mask = 1 << k;

		if ((mask & n) == 0) {
			System.out.println("OFF");
		} else {
			System.out.println("ON");
		}
	}

}
