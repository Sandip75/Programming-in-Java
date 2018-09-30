package problemSolution;

import java.util.*;

public class Parenthesis {

	public static void main(String[] args) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		String s = "311*63-1";
		ans = Allpossible(s);
		for (int val : ans) {
			System.out.print(val + "   ");
		}
	}

	public static ArrayList<Integer> Allpossible(String input) {
		ArrayList<Integer> ans = new ArrayList<Integer>();

		for (int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);

			if (current == '-' || current == '+' || current == '*') {
				String left = input.substring(0, i);
				ArrayList<Integer> leftList = Allpossible(left);

				String right = input.substring(i + 1);
				ArrayList<Integer> rightList = Allpossible(right);

				// cartesian product
				for (int l : leftList) {
					for (int r : rightList) {
						if (current == '-') {
							ans.add(l - r);
						} else if (current == '+') {
							ans.add(l + r);
						} else if (current == '*') {
							ans.add(l * r);
						}
					}
				}
			}
		}
		if (ans.size() == 0)
			ans.add(Integer.valueOf(input));

		return ans;
	}
}
