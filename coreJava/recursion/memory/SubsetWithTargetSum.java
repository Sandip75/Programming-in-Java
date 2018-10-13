package coreJava.recursion.memory;

public class SubsetWithTargetSum {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int target = 6;
		subsetWithTargetSum(arr, 0, target, 0, "");
	}

	public static void subsetWithTargetSum(int[] arr, int vidx, int target, int sum, String set) {
		if (vidx == arr.length) {
			if (target == sum) {
				System.out.println(set);
			}
			return;
		}
		subsetWithTargetSum(arr, vidx + 1, target, sum + arr[vidx], set + arr[vidx] + " ");
		subsetWithTargetSum(arr, vidx + 1, target, sum, set);
	}

}
