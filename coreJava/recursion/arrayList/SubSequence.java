package coreJava.recursion.arrayList;

import java.util.*;

public class SubSequence {

	public static void main(String[] args) {
		ArrayList<String> ans = subSequence("abc");
		System.out.println(ans);
	}

	public static ArrayList<String> subSequence(String input) {

		if (input.length() == 0) {
			ArrayList<String> ans = new ArrayList<>();
			ans.add("");
			return ans;
		}
	
		char ch = input.charAt(0);
		String subString = input.substring(1);
		ArrayList<String> ansS = subSequence(subString);
		ArrayList<String> ans = new ArrayList<>();
		for (String val : ansS) {
			ans.add(val);
			ans.add(ch + val);
		}
		return ans;
	}
}
