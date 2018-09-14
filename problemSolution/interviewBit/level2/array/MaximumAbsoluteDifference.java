package problemSolution.interviewBit.level2.array;

import java.util.*;

public class MaximumAbsoluteDifference {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(3);
		al.add(-1);
		int ans = maxArr(al);
		System.out.println(ans);
		int ans1 = maxArrBetter(al);
		System.out.println(ans1);
	}

	public static int maxArr(ArrayList<Integer> A) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j < A.size(); j++) {
				int temp = A.get(i) - A.get(j);
				if (temp < 0) {
					temp = -temp;
				}
				temp = temp + j - i;
				if (temp > max) {
					max = temp;
				}
			}
		}
		return max;
	}

	public static int maxArrBetter(ArrayList<Integer> A) {
		int Mmax = Integer.MIN_VALUE;
		int Mmin = Integer.MAX_VALUE;
		int Pmax = Integer.MIN_VALUE;
		int Pmin = Integer.MAX_VALUE;
		for (int i = 0; i < A.size(); i++) {
			if ((A.get(i) - (i + 1)) > Mmax) {
				Mmax = A.get(i) - (i + 1);
			}

			if ((A.get(i) - (i + 1)) < Mmin) {
				Mmin = A.get(i) - (i + 1);
			}

			if ((A.get(i) + (i + 1)) > Pmax) {
				Pmax = A.get(i) + (i + 1);
			}

			if ((A.get(i) + (i + 1)) < Pmin) {
				Pmin = A.get(i) + (i + 1);
			}
		}
		return ((Mmax - Mmin) > (Pmax - Pmin)) ? (Mmax - Mmin) : (Pmax - Pmin);
	}
}
