package coreJava.dynamicProgramming;

public class Try1 {

	public static void main(String[] args) {
		System.out.println(a(85));
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
}
