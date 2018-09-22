package problemSolution.interviewBit.level2.array;

import java.util.*;

public class LargestNumber {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		l.add(3);
		l.add(30);
		l.add(34);
		l.add(5);
		l.add(9);
		l.add(0);
		l.add(8);

		System.out.println(largestNumber(l));
	}

	public static String largestNumber(final List<Integer> a) {
		List<String> strs = new ArrayList<String>();
		for (Integer i : a) {
			strs.add(String.valueOf(i));
		}

		Collections.sort(strs, new MyCompartor());

		StringBuffer ans = new StringBuffer();
		for (String s : strs) {
			if ("0".equals(s) && ans.length() != 0) {
				continue;
			}
			ans.append(s);
		}

		return ans.toString();
	}

}

class MyCompartor implements Comparator<String> {
	@Override
	public int compare(String i, String j) {
		String temp1 = i + j;
		String temp2 = j + i;
		return temp2.compareTo(temp1);
	}
}
