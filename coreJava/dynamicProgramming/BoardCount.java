package coreJava.dynamicProgramming;

public class BoardCount {

	public static void main(String[] args) {
		// System.out.println(boardCountPath(0, 10));
		// System.out.println(boardCountPathMemoizatation(0, 10, new int[11]));
		// System.out.println(boardCountPathTabulation(0, 30));
		System.out.println(boardCountPathTabulationBetter(0, 10));
		System.out.println(boardCountPathTabulationBest(0, 10));
	}

	public static int boardCountPath(int src, int des) {
		if (src == des) {
			return 1;
		}
		int total_count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			int inter = src + dice;
			if (inter <= des) {
				int curr_count = boardCountPath(inter, des);
				total_count += curr_count;
			}
		}
		return total_count;
	}

	public static int boardCountPathMemoizatation(int src, int des, int[] m) {
		if (src == des) {
			return 1;
		}
		if (m[src] != 0) {
			return m[src];
		}

		int total_count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			int inter = src + dice;
			if (inter <= des) {
				int curr_count = boardCountPathMemoizatation(inter, des, m);
				total_count += curr_count;
			}
		}

		m[src] = total_count;
		return total_count;
	}

	public static int boardCountPathTabulation(int src, int des) {
		int[] ans = new int[des + 1];
		ans[des] = 1;

		for (int i = des - 1; i >= src; i--) {
			for (int k = i + 1; k <= 6 + i && k <= des; k++) {
				ans[i] = ans[i] + ans[k];
			}
		}
		return ans[0];
	}

	public static int boardCountPathTabulationBetter(int src, int des) {
		int[] ans = new int[6];
		ans[(des - 1) % 6] = 1;

		for (int i = des - 1; i >= src; i--) {
			int temp = 0;
			for (int k = i + 1; k <= 6 + i && k <= des; k++) {
				temp += ans[(k - 1) % 6];
			}
			if (i == 0) {
				ans[0] = temp;
			} else {
				ans[(i - 1) % 6] = temp;
			}
		}
		return ans[0];
	}

	public static int boardCountPathTabulationBest(int src, int des) {
		int[] ans = new int[6];
		ans[0] = 1;

		for (int i = des-1; i >= src; i--) {
			int temp = ans[0] + ans[1] + ans[2] + ans[3] + ans[4] + ans[5];
			ans[5] = ans[4];
			ans[4] = ans[3];
			ans[3] = ans[2];
			ans[2] = ans[1];
			ans[1] = ans[0];
			ans[0] = temp;
		}
		return ans[0];
	}

}
