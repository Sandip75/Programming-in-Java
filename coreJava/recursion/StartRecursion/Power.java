package coreJava.recursion.StartRecursion;

public class Power {

	public static void main(String[] args) {
		int ans = power(5, 3);
		System.out.println(ans);
	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int ansPartial = x * power(x, n - 1);
		return ansPartial;
	}

}
