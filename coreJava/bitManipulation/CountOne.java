package coreJava.bitManipulation;

public class CountOne {

	public static void main(String[] args) {
		int n = 15;
		int ans = countOne(n);
		System.out.println(ans);
	}

	public static int countOne(int n) {
		int count = 0;
		while (n != 0) {
			int help = n - 1;
			// System.out.println(Integer.toBinaryString(n));
			// System.out.println(Integer.toBinaryString(help));
			n = n & help;
			// System.out.println(Integer.toBinaryString(n));
			// System.out.println();
			count++;
		}
		
		return count;
	}

}
