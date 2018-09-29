package coreJava.string;

public class PrintCharacter {

	public static void main(String[] args) {
		String input = "Sandip";
		printCharacter(input);
	}

	public static void printCharacter(String input) {
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			System.out.println(ch);
		}
	}
}
