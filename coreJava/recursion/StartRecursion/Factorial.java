package coreJava.recursion.StartRecursion;

public class Factorial {

	public static void main(String[] args) {
		int ans = factorial(5);
		System.out.println(ans);
	}

	public static int factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int ansParical = n * factorial(n - 1);
		return ansParical;
	}

}
