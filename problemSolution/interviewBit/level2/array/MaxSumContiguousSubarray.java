package problemSolution.interviewBit.level2.array;

import java.util.*;

public class MaxSumContiguousSubarray {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<>();
		l.add(-11);// -2,1,-3,4,-1,2,1,-5,4
		// l.add(1);
		// l.add(-3);
		// l.add(4);
		// l.add(-1);
		// l.add(2);
		// l.add(1);
		// l.add(-5);
		l.add(-3);

		int ans = maxSubArray(l);
		System.out.println(ans);

	}

	public static int maxSubArray(final List<Integer> A) {
		int current = A.get(0);
		int total = A.get(0);

		for (int i = 1; i < A.size(); i++) {
			if (current < 0) {
				current = A.get(i);
			} else {
				current = current + A.get(i);
			}

			if (current > total) {
				total = current;
			}
		}

		return total;
	}

}
