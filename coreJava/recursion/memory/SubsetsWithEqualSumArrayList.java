package coreJava.recursion.memory;

import java.util.*;

public class SubsetsWithEqualSumArrayList {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		subsetsWithEqualSumAL(arr, 0, 0, new ArrayList<>(), 0, new ArrayList<>());
	}

	public static void subsetsWithEqualSumAL(int[] arr, int vidx, int sum1, ArrayList<Integer> set1, int sum2,
			ArrayList<Integer> set2) {

		if (arr.length == vidx) {
			if (sum1 == sum2) {
				System.out.println(set1 + "  &  " + set2);
			}
			return;
		}
		set1.add(arr[vidx]);
		subsetsWithEqualSumAL(arr, vidx + 1, sum1 + arr[vidx], set1, sum2, set2);
		set1.remove(set1.size() - 1);

		set2.add(arr[vidx]);
		subsetsWithEqualSumAL(arr, vidx + 1, sum1, set1, sum2 + arr[vidx], set2);
		set2.remove(set2.size() - 1);
	}
}
