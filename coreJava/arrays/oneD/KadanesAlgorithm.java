package coreJava.arrays.oneD;

public class KadanesAlgorithm {

	public static void main(String[] args) {
		int[] input = { 2, 3, -6, 1, 2, 3, -4, 5 };
		int ans = kadanesAlgorithm(input);
		System.out.println(ans);
	}

	public static int kadanesAlgorithm(int[] arr) {
		int current_sum = arr[0];
		int overall_sum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			
			if(current_sum < 0){
				current_sum = arr[i];
			}else{
				current_sum += arr[i];
			}			
			overall_sum = Math.max(current_sum, overall_sum);
		}
		return overall_sum;
	}
}