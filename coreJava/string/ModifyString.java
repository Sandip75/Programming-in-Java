package coreJava.string;

public class ModifyString {

	public static void main(String[] args) {
		String input = "abcde";
		String ans = modifyString(input);
		System.out.println(ans);
	}

	public static String modifyString(String input) {
		StringBuilder ansP = new StringBuilder();

		for (int i = 1; i < input.length()-1; i++) {
			char ch = input.charAt(i);
			char chM = input.charAt(i - 1);
			ansP.append(chM);
			ansP.append(ch - chM);
		}
		ansP.append(input.charAt(input.length()-1));
		return ansP.toString();
	}

}
