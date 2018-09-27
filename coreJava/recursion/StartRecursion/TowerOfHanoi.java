package coreJava.recursion.StartRecursion;

public class TowerOfHanoi {

	public static void main(String[] args) {
		toh("S", "D", "H", 3);
	}

	public static void toh(String src, String des, String help, int n) {
		if (n == 0) {
			return;
		}
		toh(src, help, des, n - 1);
		System.out.println(src + " to " + des + " --->>> " + n);
		toh(help, des, src, n - 1);
	}
}
