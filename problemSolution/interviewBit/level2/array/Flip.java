package problemSolution.interviewBit.level2.array;

import java.util.*;

public class Flip {

	public static void main(String[] args) {
		String s = "0111000100010";
		ArrayList<Integer> ans = flip(s);
		for (int val : ans) {
			System.out.print(val + "  ");
		}
	}

	public static ArrayList<Integer> flip(String A) {

		int L = -1;
		int R = -1;
		int Ltemp = 0;
		int Rtemp = 0;
		int diffLR = 0;
		int zero = 0, one = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == '0') {
				zero++;
			} else {
				one++;
			}

			if (zero < one) {
				Ltemp = i +  1;
				Rtemp = i + 1;
				zero = 0 ;
				one = 0 ;
			} else {
				if ((zero - one) > diffLR) {
					diffLR = zero - one;
					L = Ltemp;
					R = Rtemp;
					Rtemp++;
				} else {
					Rtemp++;
				}
			}
		}

		if (L >= 0) {
			ArrayList<Integer> ans = new ArrayList<>();
			ans.add(L+1);
			ans.add(R+1);
			return ans ;
		}
		return new ArrayList<Integer>();
	}
}