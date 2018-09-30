package problemSolution.interviewBit.level3.string;

public class PalindromeString {

	public static void main(String[] args) {
		String input = "A man, a plan, a canal: Panama";
		int ans = isPalindrome(input);
		System.out.println(ans);
	}

	public static int isPalindrome(String A) {
		int left = 0;
		int right = A.length() - 1;
		while (left < right) {
			char l = A.charAt(left);
			char r = A.charAt(right);
			if (((l >= 'a' && 'z' >= l) || (l >= 'A' && 'Z' >= l))
					&& ((r >= 'a' && 'z' >= r) || (r >= 'A' && 'Z' >= r))) {

				if (l != r) {
					if ((l >= 'a' && 'z' >= l)) {
						l = (char) (l + 'A' - 'a');
					} else {
						l = (char) (l + 'a' - 'A');
					}

					if (l != r) {
						return 0;
					}
				}
				left++;
				right--;
			} else if ((l >= 'a' && 'z' >= l) || (l >= 'A' && 'Z' >= l)) {
				right--;
			} else if ((r >= 'a' && 'z' >= r) || (r >= 'A' && 'Z' >= r)) {
				left++;
			} else {
				left++;
				right--;
			}
		}
		return 1;
	}
}
