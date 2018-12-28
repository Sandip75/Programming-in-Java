package coreJava.dynamicProgramming;

public class Try1 {

	public static void main(String[] args) {
		// System.out.println(a(85));
		// System.out.println(checkperfectnumber(49));

		String[] q = { "abcd", "hfgl", "mijk" };
		// System.out.println(check(q));

		// patteren(3, 4);
		patteren2(4);

	}

	public static int a(int n) {
		int[] ans = new int[n + 1];

		int count = 0;

		for (int i = 1; i < ans.length; i++) {
			if (((count + 1) * (count + 1)) == i) {
				count = count + 1;
			}
			ans[i] = 1 + ans[i - 1];
			for (int j = 2; j <= count; j++) {
				ans[i] = Math.min(ans[i], 1 + ans[i - (j * j)]);
			}
		}

		return ans[n];
	}

	public static int checkperfectnumber(int a) {
		int sum = 1;

		for (int i = 2; i <= (a / 2); i++) {
			if ((a % i) == 0) {
				sum += i;
			}
		}
		if (sum == a) {
			return 1;
		}
		return 0;
	}

	public static int check(String[] a) {

		int[] ans = new int[26];

		for (int i = 0; i < a.length; i++) {
			String temp = a[i];
			for (int k = 0; k < temp.length(); k++) {
				char current = temp.charAt(k);
				ans[(int) (current - 'a')] += 1;
			}
		}

		for (int i = 0; i < 26; i++) {
			if (ans[i] > 1) {
				return -1;
			}
		}

		return 1;
	}

	public static void patteren(int i, int j) {

		int temp = 0;
		for (int k = 1; k < (2 * j); k++) {
			if (k <= j) {
				temp = temp + 1;
				for (int l = 1; l <= k; l++) {
					System.out.print(temp);
				}
			} else {
				temp = temp - 1;
				for (int l = 1; l <= (j - (k % j)); l++) {
					System.out.print(temp);
				}
			}
			System.out.println();
		}
	}

	public static void patteren2(int n) {

		int temp = 1;
		for (int i = 1; i <= (2 * n); i++) {
			if (i <= n) {
				for (int k = 1; k < i; k++) {
					System.out.print(temp + "*");
				}
				System.out.print(temp);
				temp = temp + 1;
			} else {
				temp = temp - 1;
				for (int k = 1; k < (n - ((i - 1) % n)); k++) {
					System.out.print(temp + "*");
				}
				System.out.print(temp);
			}
			System.out.println();
		}
	}
}
