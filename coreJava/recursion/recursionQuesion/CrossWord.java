package coreJava.recursion.recursionQuesion;

public class CrossWord {

	public static void main(String[] args) {
		char[][] input = { { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
				{ '+', '-', '-', '-', '-', '-', '+', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '+', '-', '-', '-', '-', '-', '-', '+', '+' },
				{ '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' } };
		String[] words = { "DELHI", "ICELAND", "ANKARA", "LONDON" };
		crossWord(input, words, 0);
	}

	public static void crossWord(char[][] input, String[] words, int widx) {

		if (words.length == widx) {
			for (int i = 0; i < input.length; i++) {
				for (int j = 0; j < input[0].length; j++) {
					System.out.print(input[i][j]);
				}
				System.out.println();
			}
			return;
		}

		for (int r = 0; r < input.length; r++) {
			for (int c = 0; c < input[0].length; c++) {
				if (input[r][c] == '-' || input[r][c] == words[widx].charAt(0)) {
					if (canPlaceWordHorizontally(input, words[widx], r, c) == true) {
						boolean[] reset = placeTheWordHorizontally(input, words[widx], r, c);
						crossWord(input, words, widx + 1);
						unPlaceTheWordHorizontally(input, reset, r, c);
					}
					if (canPlaceWordVertically(input, words[widx], r, c) == true) {
						boolean[] reset = placeTheWordVertically(input, words[widx], r, c);
						crossWord(input, words, widx + 1);
						unPlaceTheWordVertically(input, reset, r, c);
					}
				}
			}
		}
	}

	private static boolean canPlaceWordHorizontally(char[][] input, String word, int r, int c) {
		if (c + word.length() > input[0].length) {
			return false;
		}

		for (int i = 0; i < word.length(); i++) {
			if (input[r][c + i] != '-' && input[r][c + i] != word.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean canPlaceWordVertically(char[][] input, String word, int r, int c) {
		if (r + word.length() > input.length) {
			return false;
		}

		for (int i = 0; i < word.length(); i++) {
			if (input[r + i][c] != '-' && input[r + i][c] != word.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static boolean[] placeTheWordHorizontally(char[][] input, String word, int r, int c) {
		boolean[] reset = new boolean[word.length()];
		for (int i = 0; i < word.length(); i++) {
			reset[i] = (input[r][c + i] != word.charAt(i));
			input[r][c + i] = word.charAt(i);
		}
		return reset;
	}

	public static boolean[] placeTheWordVertically(char[][] input, String word, int r, int c) {
		boolean[] reset = new boolean[word.length()];
		for (int i = 0; i < word.length(); i++) {
			reset[i] = (input[r + i][c] != word.charAt(i));
			input[r + i][c] = word.charAt(i);
		}
		return reset;
	}

	public static void unPlaceTheWordHorizontally(char[][] input, boolean[] reset, int r, int c) {
		for (int i = 0; i < reset.length; i++) {
			if (reset[i]) {
				input[r][c + i] = '-';
			}
		}
	}

	public static void unPlaceTheWordVertically(char[][] input, boolean[] reset, int r, int c) {
		for (int i = 0; i < reset.length; i++) {
			if (reset[i]) {
				input[r + i][c] = '-';
			}
		}
	}
}
