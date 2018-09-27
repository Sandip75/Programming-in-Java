package coreJava.recursion.StartRecursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		// toh("S", "D", "H", 3);
		int ans = tohCount("S", "D", "H", 3);
		System.out.println(ans);
	}

	public static void toh(String src, String des, String help, int n) {
		if (n == 0) {
			return;
		}
		toh(src, help, des, n - 1);
		System.out.println(src + " to " + des + " --->>> " + n);
		toh(help, des, src, n - 1);
	}

	public static int tohCount(String src, String des, String help, int n) {
		if (n == 0) {
			return 0;
		}
		int steps = tohCount(src, help, des, n - 1);
		System.out.println(src + " to " + des + " --->>> " + n);
		steps = steps + tohCount(help, des, src, n - 1);
		return steps + 1;
	}
}
