package problemSolution.interviewBit.level2.array;

import java.util.*;

public class MaximumConsecutiveGap {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(5);
		l.add(7);
		int ans = maximumGap(l);
		System.out.println(ans);
	}

	public static int maximumGap(final List<Integer> A) {
		int ans =0;
		Collections.sort(A);
		for (int i = 1; i < A.size(); i++) {
			int diff = A.get(i) - A.get(i-1);
			if(diff > ans ){
				ans = diff ;
			}
		}
		return ans;
	}
}
