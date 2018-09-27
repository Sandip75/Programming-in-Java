package coreJava.recursion.StartRecursion;

public class PrintDecreasing {

	public static void main(String[] args) {
		printDecreasing(3);
	}

	public static void printDecreasing(int n) {
		if(n==0){
			return ;
		}
		System.out.print(n + "  ");
		printDecreasing(n-1);
		System.out.println("HI");
	}

}
