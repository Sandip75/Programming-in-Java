package problemSolution.interview_prepMY.array;

public class Find_subarray_with_given_sum {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 20, 3, 10, 5 };
		int target = 5;
		sum(arr, target);
	}

	public static void sum(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			int tsum = 0 ;
			for (int j = i; j < arr.length; j++) {
				tsum += arr[j];
				if(tsum == target){
					System.out.println(i + "  " +  j);
					return;
				}
			}
		}
		
		System.out.println(-1);
		return;
	}

}
