package problemSolution.interviewBit.level2.array;

import java.util.ArrayList;

public class RotateMatrix {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		int n = 2;
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				list.add((i + 1) * j);
			}
			ans.add(list);
		}
		
		for (int i = 0; i < ans.size(); i++) {
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + "  ");
			}
			System.out.println();
		}
		
		rotate(ans);
		
	}

	public static void rotate(ArrayList<ArrayList<Integer>> ans) {
		for (int i = 0; i < ans.size(); i++) {
			for (int j = i; j < ans.get(i).size(); j++) {
				swap(ans, i, j, j, i);
			}
		}

		int lc = 0;
		int rc = ans.get(0).size()-1;

		while (lc < rc) {
			for (int r = 0; r < ans.size(); r++) {
				swap(ans, r, lc, r, rc);
			}
			lc++;
			rc--;
		}
	}

	private static void swap(ArrayList<ArrayList<Integer>> ans, int r1, int c1, int r2, int c2) {
		int temp1 = ans.get(r1).get(c1);
		int temp2 = ans.get(r2).get(c2);

		ans.get(r1).set(c1, temp2);
		ans.get(r2).set(c2, temp1);
	}

}
