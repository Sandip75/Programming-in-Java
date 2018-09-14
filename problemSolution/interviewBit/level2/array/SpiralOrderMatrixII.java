package problemSolution.interviewBit.level2.array;

import java.util.*;

public class SpiralOrderMatrixII {

	public static void main(String[] args) {

		int n = 4;
		ArrayList<ArrayList<Integer>> ans = generateMatrix(n);
		for (int i = 0; i < ans.size(); i++) {
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + "  ");
			}
			System.out.println();
		}

	}

	public static ArrayList<ArrayList<Integer>> generateMatrix(int n) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < n; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				list.add(0);
			}
			ans.add(list);
		}

		int rmin = 0;
		int rmax = n - 1;
		int cmin = 0;
		int cmax = n - 1;

		int total = n * n;
		int current = 1;

		while (current <= total) {
			for (int i = cmin; i <= cmax && current <= total; i++) {
				ans.get(rmin).set(i, current);
				current++;
			}
			rmin++;

			for (int i = rmin; i <= rmax && current <= total; i++) {
				ans.get(i).set(cmax, current);
				current++;
			}
			cmax--;

			for (int i = cmax; i >= cmin && current <= total; i--) {
				ans.get(rmax).set(i, current);
				current++;
			}
			rmax--;

			for (int i = rmax; i >= rmin && current <= total; i--) {
				ans.get(i).set(cmin, current);
				current++;
			}
			cmin++;
		}

		return ans;
	}

}
