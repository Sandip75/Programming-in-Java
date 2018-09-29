package coreJava.string;

public class PrintPalindromeSubstring {

	public static void main(String[] args) {
		String input = "naman";
		printPalindromeSubstring(input);
	}

	public static void printPalindromeSubstring(String input) {
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				String substring = input.substring(i, j);
				boolean check = isPalindrome(substring);
				if (check) {
					System.out.println(substring);
				}
			}
		}
	}

	private static boolean isPalindrome(String substring) {
		int left = 0;
		int right = substring.length() - 1;
		while (left < right) {
			if (substring.charAt(left) != substring.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
