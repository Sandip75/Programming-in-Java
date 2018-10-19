package coreJava.bitManipulation;

public class ToggleTheBit {

	public static void main(String[] args) {
		int n = 25;
		int k = 3;
		System.out.println(Integer.toBinaryString(n));
		int ans = toggleTheBit(n, k);
		System.out.println(Integer.toBinaryString(ans));
		System.out.println(ans);
	}

	public static int toggleTheBit(int n, int k) {
		int mask = (1 << k);
		n = n ^ mask;
		return n;
	}
}
