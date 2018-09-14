package problemSolution.interviewBit.level2.array;

import java.util.ArrayList;

public class AntiDiagonals {

	public static void main(String[] args) {
		int n = 4;
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		int c = 1;
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				list.add(c);
				c++;
			}
			ans.add(list);
		}

		for (int i = 0; i < ans.size(); i++) {
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}
			System.out.println();
		}

		ans = diagonal(ans);

		for (int i = 0; i < ans.size(); i++) {
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + "  ");
			}
			System.out.println();
		}

	}

	public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < A.size(); i++) {
			int k = i;
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				list.add(A.get(j).get(k));
				k--;
			}
			ans.add(list);
		}
		
		for (int i = 0  ; i < A.size()-1; i++) {
			int k = A.size()-1;
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = i+1;  j <= (A.size() - 1) ; j++) {
				list.add(A.get(j).get(k));
				k--;
			}
			ans.add(list);
		}
		return ans;
	}

}
