package coreJava.string;

public class ToggleCharacters {

	public static void main(String[] args) {
		String input = "Sandip";
		String ans = toggleCharacters(input);
		System.out.println(ans);
	}

	public static String toggleCharacters(String input) {
		StringBuilder ansP = new StringBuilder(input);

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				ch = (char) ( ch +  'a' - 'A' );
			} else if (ch >= 'a' && ch <= 'z') {
				ch = (char) ( ch +  'A' - 'a' );
			}
			ansP.setCharAt(i, ch);
		}
		return ansP.toString();
	}

}
