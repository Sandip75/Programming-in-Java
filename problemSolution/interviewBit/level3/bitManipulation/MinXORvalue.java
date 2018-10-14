package problemSolution.interviewBit.level3.bitManipulation;

import java.util.*;

public class MinXORvalue {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(0);
		A.add(4);
		A.add(7);
		A.add(9);
		int ans = findMinXor(A);
		System.out.println(ans);
	}

	public static int findMinXor(ArrayList<Integer> A) {

		Collections.sort(A); 
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.size() - 1; i++) {
			int temp = A.get(i) ^ A.get(i + 1);
			if (min > temp) {
				min = temp;
			}
		}
		return min;
	}

}
