package problemSolution.interview_prepMY.array;

import java.util.*;

public class K_Concatenation {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while (T != 0) {

			int n = s.nextInt();
			int k = s.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			System.out.println(K_Con(arr, k));
			T--;
		}

	}

	public static int K_Con(int[] arr, int k) {
		int m = arr.length * k;
		
		int max = Integer.MIN_VALUE;
		int tmax = arr[0];

		for (int i = 1; i < m; i++) {
			tmax = tmax + arr[i % arr.length];
			if (tmax <= 0) {
				tmax = 0;
			}
			
			if(max < tmax){
				max = tmax;
			}
		}

		return max;
	}

}
