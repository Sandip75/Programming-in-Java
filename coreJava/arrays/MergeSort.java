package coreJava.arrays;

public class MergeSort {

	public static void main(String[] args) {

		int[] arr = { 99, 45, 1, 555, 2, 13, 6, 19 };
		int[] ans = mergeSort(arr, 0, arr.length - 1);
		for (int val : ans) {
			System.out.print(val + "  ");
		}
	}

	public static int[] mergeSort(int[] arr, int left, int right) {

		if (left == right) {
			int[] bA = new int[1];
			bA[0] = arr[left];
			return bA;
		}

		int mid = (left + right) / 2;
		int[] leftA = mergeSort(arr, left, mid);
		int[] rightA = mergeSort(arr, mid + 1, right);
		int[] sorted = merge(leftA, rightA);
		return sorted;
	}

	private static int[] merge(int[] one, int[] two) {
		int[] ans = new int[one.length + two.length];
		int oneCount = 0;
		int twoCount = 0;

		for (int i = 0; i < ans.length; i++) {
			if (oneCount == one.length) {
				ans[i] = two[twoCount];
				twoCount++;
			} else if (twoCount == two.length) {
				ans[i] = one[oneCount];
				oneCount++;
			} else {
				if (one[oneCount] < two[twoCount]) {
					ans[i] = one[oneCount];
					oneCount++;
				} else {
					ans[i] = two[twoCount];
					twoCount++;
				}
			}
		}
		return ans;
	}
}
