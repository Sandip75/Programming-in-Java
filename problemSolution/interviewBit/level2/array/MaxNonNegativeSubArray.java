package problemSolution.interviewBit.level2.array;

import java.util.*;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {

		ArrayList<Integer> l = new ArrayList<>();
		l.add(-926);
		l.add(-16);
		l.add(-5);
		l.add(142980);

		ArrayList<Integer> ans = maxset(l);
		for (int val : ans) {
			//System.out.print(val + "  ");
		}

		ArrayList<Integer> ans1 = maxsetBetter(l);
		for (Integer val : ans1) {
			System.out.print(val + "  ");
		}
	}

	public static ArrayList<Integer> maxset(ArrayList<Integer> A) {

		long current = 0;
		int currentL = 0;
		int currentR = 0;

		long total = 0;
		int totalL = -1;
		int totalR = -1;

		int totalLF = -1;
		int totalRF = -1;

		int diff = -1;
		for (int i = 0; i < A.size(); i++) {
			long temp = A.get(i);
			if (temp < 0) {
				current = 0;
				currentL = i + 1;
				currentR = i + 1;
				continue;
			} else if ((current + temp) >= total) {
				current = current + temp;
				total = current;
				totalL = currentL;
				totalR = currentR;
				currentR = i + 1;
			} else {
				current = current + temp;
				currentR = i + 1;
				if (current < 0) {
					current = 0;
					currentL = i + 1;
				}
			}

			if (((totalR - totalL + 1) > diff) && ((totalR - totalL + 1) > 0)) {
				diff = totalR - totalL + 1;
				totalLF = totalL;
				totalRF = totalR;
			}
		}

		if (diff != -1) {
			ArrayList<Integer> ans = new ArrayList<>();
			for (int i = totalLF; i <= totalRF; i++) {
				ans.add(A.get(i));
			}
			return ans;
		}
		return new ArrayList<>();
	}

	public static ArrayList<Integer> maxsetBetter(ArrayList<Integer> A) {
		long maxSum = 0;
		long newSum = 0;

		ArrayList<Integer> newAL = new ArrayList<Integer>();
		ArrayList<Integer> maxAL = new ArrayList<Integer>();

		for (Integer i : A) {

			if (i >= 0) {
				newSum = newSum + i;
				newAL.add(i);
			} else {
				newSum = 0;
				newAL = new ArrayList<Integer>();
			}

			if ((maxSum < newSum) || ((maxSum == newSum) ) && (newAL.size() > maxAL.size())) {
				maxSum = newSum;
				maxAL = newAL;
			}

		}
		return maxAL;
	}
}
