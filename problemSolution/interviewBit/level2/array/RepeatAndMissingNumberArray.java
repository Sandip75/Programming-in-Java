package problemSolution.interviewBit.level2.array;

import java.util.*;

public class RepeatAndMissingNumberArray {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<>();
		l.add(1);
		l.add(1);
		l.add(2);
		l.add(5);
		l.add(1);
		l = repeatedNumber(l);
		for (int val : l) {
			System.out.print(val + "  ");
		}

	}

	public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
		ArrayList<Integer> ans = new ArrayList<>();
		int a = 0, b = 0;
		int tempAns = 0;
		for (int i = 0; i < A.size(); i++) {
			tempAns = tempAns ^ A.get(i);
			tempAns = tempAns ^ (i + 1);
		}

		int mask = tempAns & (-tempAns);
		for (int i = 0; i < A.size(); i++) {
			if ((A.get(i) & mask) == mask) {
				a = a ^ A.get(i);
			} else {
				b = b ^ A.get(i);
			}

			if (((i + 1) & mask) == mask) {
				a = a ^ (i + 1);
			} else {
				b = b ^ (i + 1);
			}
		}
		boolean flag = false;
		for (int i = 0; i < A.size(); i++) {
			if ((A.get(i) ^ a) == 0) {
				flag = true;
			}
		}

		if (flag) {
			ans.add(a);
			ans.add(b);
		} else {
			ans.add(b);
			ans.add(a);
		}
		return ans;
	}

}
