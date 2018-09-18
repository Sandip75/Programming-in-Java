package problemSolution;

import java.util.*;

public class Parenthesis {

	public static void main(String[] args) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		String s = "3+6*2-1";
		ans = Allpossible(s);
		for (int val : ans) {
			System.out.print(val + "   ");
		}
	}

	public static ArrayList<Integer> Allpossible(String input) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '-' || c == '+' || c == '*') {
				String left = input.substring(0, i);
				String right = input.substring(i + 1);
				ArrayList<Integer> leftList = Allpossible(left);
				ArrayList<Integer> rightList = Allpossible(right);
				for (int x : leftList) {
					for (int y : rightList) {
						if (c == '-') {
							res.add(x - y);
						} else if (c == '+') {
							res.add(x + y);
						} else if (c == '*') {
							res.add(x * y);
						}
					}
				}
			}
		}
		if (res.size() == 0)
			res.add(Integer.valueOf(input));
		return res;
	}
}
