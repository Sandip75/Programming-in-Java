package coreJava.recursion.memory;

public class SubsetsWithEqualSum {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		subsetsWithEqualSum(arr, 0, 0, "", 0, "");
	}

	public static void subsetsWithEqualSum(int[] arr, int vidx, int sum1, String set1, int sum2, String set2) {
		if (arr.length == vidx) {
			if (sum1 == sum2) {
				System.out.println(set1 + " && " + set2);
			}
			return;
		}
		subsetsWithEqualSum(arr, vidx + 1, sum1 + arr[vidx], set1 + arr[vidx] + " ", sum2, set2);
		subsetsWithEqualSum(arr, vidx + 1, sum1, set1, sum2 + arr[vidx], set2 + arr[vidx] + " ");
	}
}
