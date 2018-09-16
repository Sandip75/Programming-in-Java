package problemSolution.interviewBit.level2.array;

import java.util.*;

public class FindDuplicateinArray {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<>();
		l.add(3);
		l.add(4);
		l.add(2);
		l.add(1);
		int ans = repeatedNumber(l);
		System.out.println(ans);

	}

	public static int repeatedNumber(final List<Integer> a) {
		int ans = 0;
		for (int i = 0; i < a.size(); i++) {
			ans = ans ^ a.get(i) ^ (i + 1);
		}

		if (ans == 0) {
			return -1;
		}
		int mask = ans & (-ans);
		int ansL = 0, ansR = 0;
		for (int i = 0; i < a.size(); i++) {
			if ((a.get(i) & mask) == mask) {
				ansL = ansL ^ a.get(i);
			} else {
				ansR = ansR ^ a.get(i);
			}
			if (((i + 1) & mask) == mask) {
				ansL = ansL ^ (i + 1);
			} else {
				ansR = ansR ^ (i + 1);
			}
		}

		for (int i : a) {
			if ((i ^ ansL) == 0) {
				return ansL;
			}
		}
		return ansR;
	}

}
