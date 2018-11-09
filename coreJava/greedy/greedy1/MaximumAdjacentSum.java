package coreJava.greedy.greedy1;

public class MaximumAdjacentSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 6, 15, 100, 25, 5 };
		int ans = maximumAdjacentSum(arr);
		System.out.println(ans);
	}

	public static int maximumAdjacentSum(int[] arr) {
		int inc = arr[0];
		int exc = 0;

		for (int i = 1; i < arr.length; i++) {
			int oinc = inc;
			int oexc = exc;
			inc = exc + arr[i];
			exc = Math.max(oinc, oexc);
		}

		return Math.max(inc, exc);
	}

}
