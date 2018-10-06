package coreJava.arrays;

public class MergeSort {

	public static void main(String[] args) {

		int[] one = { 0, 1, 2, 3 ,10};
		int[] two = { 9, 11 };
		int[] ans = merge(one, two);
		for (int val : ans) {
			System.out.print(val + "  ");
		}

	}

	public static int[] merge(int[] one, int[] two) {
		int oneCount = 0;
		int twoCount = 0;
		int[] ans = new int[one.length + two.length];
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
