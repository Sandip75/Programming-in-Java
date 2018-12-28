package coreJava.bitManipulation;

public class PrintBits {

	public static void main(String[] args) {
		int n = 75;
		System.out.println(Integer.toBinaryString(n));
		printBit(n);
	}

	public static void printBit(int n) {
		for (int i = 31; i >= 0; i--) {
			int mask = (1 << i);
			if ((mask & n) == mask) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}
	}
}
