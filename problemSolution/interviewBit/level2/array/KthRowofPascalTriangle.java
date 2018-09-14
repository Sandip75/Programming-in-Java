package problemSolution.interviewBit.level2.array;

import java.util.*;

public class KthRowofPascalTriangle {

	public static void main(String[] args) {

		int n = 5;
		ArrayList<Integer> ans = getRow(n);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + "  ");
		}

	}

	public static ArrayList<Integer> getRow(int n) {

		ArrayList<Integer> ans = new ArrayList<Integer>();

		int val = 1;
		for (int i = 0; i <= n; i++) {
			ans.add(val);
			val = (val * (n - i)) / (i + 1);
		}

		return ans;
	}

}
