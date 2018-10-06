package coreJava.recursion.arrayList;

import java.util.*;

public class SubSequenceAscii {

	public static void main(String[] args) {
		ArrayList<String> ans = subSequenceAscii("abc");
		System.out.println(ans);
	}

	public static ArrayList<String> subSequenceAscii(String input) {

		if (input.length() == 0) {
			ArrayList<String> ans = new ArrayList<>();
			ans.add("");
			return ans;
		}
		char ch = input.charAt(0);
		String subString = input.substring(1);
		ArrayList<String> ansS = subSequenceAscii(subString);
		ArrayList<String> ans = new ArrayList<>();
		for (String val : ansS) {
			ans.add(val);
			ans.add(ch + val);
			ans.add((int) ch + val);
		}
		return ans;
	}

}
