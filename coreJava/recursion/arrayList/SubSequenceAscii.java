package coreJava.recursion.arrayList;

import java.util.*;

public class SubSequenceAscii {

	public static void main(String[] args) {
		ArrayList<String> ans = subSequenceAscii("bc");
		System.out.println(ans);
		
	}

	public static ArrayList<String> subSequenceAscii(String input) {

		if (input.length() == 0){
			ArrayList<String> news = new ArrayList<>();
			news.add("");
			return news;
		}
		
		char first= input.charAt(0);
		String nw= input.substring(1);
			
		ArrayList<String> ans = new ArrayList<String>();
		ans = subSequenceAscii(nw);
		
		ArrayList<String> fans = new ArrayList<String>();
		for(String str:ans){
			fans.add(str);
			fans.add(first+str);
			fans.add((int)first+str);
			
		}
		return fans;
		
	}

}
