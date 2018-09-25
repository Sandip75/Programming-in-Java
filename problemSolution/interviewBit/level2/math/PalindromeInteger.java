package problemSolution.interviewBit.level2.math;

public class PalindromeInteger {

	public static void main(String[] args) {
		int ans = isPalindrome(121);
		System.out.println(ans);
	}

	public static int isPalindrome(int A) {
		int org = A;
		
		boolean flag = false;
		if (A < 0) {
			flag = true;
			A = -A;
		}
		int rev = 0;
		while (A != 0) {
			int rem = A % 10;
			if (rev > Integer.MAX_VALUE / 10 || ((rev == Integer.MAX_VALUE / 10) && rem > Integer.MAX_VALUE % 10)) {
				return 0;
			}
			rev = rev * 10 + rem;
			A = A / 10;
		}

		if (flag == true) {
			rev = -rev;
		}
		
		if (org - rev == 0) {
			return 1;
		}
		return 0;
	}
}
