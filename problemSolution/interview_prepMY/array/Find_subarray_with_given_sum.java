// https://www.geeksforgeeks.org/find-subarray-with-given-sum/

package problemSolution.interview_prepMY.array;

public class Find_subarray_with_given_sum {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 20, 3, 10, 5 };
		int target = 18;
		sum(arr, target);
		sumBetter(arr, target);
	}

	public static void sum(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			int tsum = 0;
			for (int j = i; j < arr.length; j++) {
				tsum += arr[j];
				if (tsum == target) {
					System.out.println(i + "  " + j);
					return;
				}
			}
		}

		System.out.println(-1);
		return;
	}

	public static void sumBetter(int[] arr, int target) {

		int[] ans = new int[arr.length];
		ans[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			ans[i] = arr[i] + ans[i - 1];
		}

		int traverse = 0;
		for (int i = 0; i < ans.length; i++) {
			if (target == ans[i]) {
				System.out.println(0 + " " + i);
				return;
			} else if (target < ans[i]) {
				traverse = i;
				break;
			}
		}

		while (traverse != ans.length) {
			for (int i = 0; i < traverse; i++) {
				int diff = ans[traverse] - ans[i];
				if (diff == target) {
					System.out.println(i+1 + "  " + traverse);
					return;
				} else if (diff < target) {
					break;
				}
			}
			traverse++;
		}
		System.out.println("NO subarray found");
	}

}
