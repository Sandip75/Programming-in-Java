package coreJava.dynamicProgramming;

public class Fibonacci {

	public static void main(String[] args) {
		int n = 10;
		int ans = fibonacciMemoizatation(n, new int[n + 1]);
		System.out.println(ans);
		int ans1 = fibonacciTabulation(n);
		System.out.println(ans1);

	}

	public static int fibonacciMemoizatation(int n, int[] m) {
		if (n == 0 || n == 1) {
			return n;
		}

		if (m[n] != 0) {
			return m[n];
		}

		int fm1 = fibonacciMemoizatation(n - 1, m);
		int fm2 = fibonacciMemoizatation(n - 2, m);
		int f = fm1 + fm2;

		m[n] = f;
		return f;
	}

	public static int fibonacciTabulation(int n) {
		int[] m = new int[n + 1];
		m[0] = 0;
		m[1] = 1;

		for (int i = 2; i < m.length; i++) {
			m[i] = m[i - 1] + m[i - 2];
		}

		return m[n];
	}
}
