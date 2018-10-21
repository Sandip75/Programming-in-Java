package coreJava.dynamicProgramming.dynamicProgramming4;

import java.util.*;

public class MinJump {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 0, 1, 2, 0, 3, 1, 0, 2, 1 };
		int target = 10;
		int ans = minJump(arr, target);
		System.out.println(ans);
	}

	public static int minJump(int[] arr, int target) {
		Integer[] ans = new Integer[arr.length + 1];

		ans[arr.length] = 0;
		for (int i = ans.length - 2; i >= 0; i--) {
			for (int j = i + 1; j <= i + arr[i] && j < ans.length; j++) {
				if (ans[j] != null) {
					if (ans[i] == null || ans[j] + 1 < ans[i]) {
						ans[i] = ans[j] + 1;
					}
				}
			}
		}
		return ans[0];
	}
}