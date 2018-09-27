package coreJava.recursion.StartRecursion;

public class PrintIncreasing {

	public static void main(String[] args) {
		printIncreasing(5);
	}

	public static void printIncreasing(int n) {
		if (n == 0) {
			return;
		}
		printIncreasing(n - 1);
		System.out.print(n + "  ");
	}

}
