package coreJava.string;

public class ModifyEvenPandOddM {

	public static void main(String[] args) {
		String input = "abcde";
		String ans = modifyEvenPandOddM(input);
		System.out.println(ans);
	}

	public static String modifyEvenPandOddM(String input) {
		StringBuilder ansP = new StringBuilder(input);
		boolean flag = true;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (flag) {
				ch = (char) (ch + 1);
				flag = false;
			} else {
				ch = (char) (ch - 1);
				flag = true;
			}
			ansP.setCharAt(i, ch);
		}
		return ansP.toString();
	}
}
