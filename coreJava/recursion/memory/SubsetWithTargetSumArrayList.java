package coreJava.recursion.memory;

import java.util.ArrayList;

public class SubsetWithTargetSumArrayList {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		int target = 50;
		subsetWithTargetSumAL(arr, target, 0, 0, new ArrayList<>());
	}

	public static void subsetWithTargetSumAL(int[] arr, int target, int vidx, int sum, ArrayList<Integer> ans) {
		if (vidx == arr.length || sum >= target) {
			if (target == sum) {
				System.out.println(ans);
			}
			return;
		}

		ans.add(arr[vidx]);
		subsetWithTargetSumAL(arr, target, vidx + 1, sum + arr[vidx], ans);
		ans.remove(ans.size() - 1);
		subsetWithTargetSumAL(arr, target, vidx + 1, sum, ans);
	}
}