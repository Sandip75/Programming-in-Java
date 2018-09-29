package coreJava.string;

public class PrintSubstring {

	public static void main(String[] args) {
		String input = "abcd";
		printSubstring(input);
	}

	public static void printSubstring(String input) {
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j<=input.length(); j++) {
				System.out.println(input.substring(i, j));
			}
		}
	}

}
