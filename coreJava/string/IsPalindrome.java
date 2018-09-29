package coreJava.string;

public class IsPalindrome {

	public static void main(String[] args) {
		String input = "naman";
		boolean ans = isPalindrome(input);
		System.out.println(ans);
	}

	public static boolean isPalindrome(String input) {
		int left = 0;
		int right = input.length() - 1;
		while (left < right) {
			if (input.charAt(left) != input.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
