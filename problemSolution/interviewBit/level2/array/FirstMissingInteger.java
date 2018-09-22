package problemSolution.interviewBit.level2.array;

import java.util.*;

public class FirstMissingInteger {

	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(-7);
		al.add(3);
		al.add(2);
		al.add(9);

		int ans = firstMissingPositive(al);
		System.out.println(ans);

	}

	public static int firstMissingPositive(ArrayList<Integer> A) {
		int sum = 0;
		int count = 0;

		for (int val : A) {
			if (val > 0 && val < (A.size() + 1)) {
				sum = sum + val;
				count = count + 1;
			}
		}
		count = count + 1;
		int totalSum = (count * (count + 1)) / 2;
		return totalSum - sum;
	}

}
