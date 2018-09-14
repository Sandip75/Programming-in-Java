package problemSolution.interviewBit.level2.array;

import java.util.ArrayList;

public class PascalTriangle {

	public static void main(String[] args) {

		int n = 4;
		ArrayList<ArrayList<Integer>> ans = solve(n);
		for (int i = 0; i < ans.size(); i++) {
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + "  ");
			}
			System.out.println();
		}

	}

	public static ArrayList<ArrayList<Integer>> solve(int n) {
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < n; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				list.add(0);
			}
			ans.add(list);
		}
		
		for (int i = 0; i < n; i++) {
			int val = 1 ; 
			for (int j = 0; j <= i; j++) {
				ans.get(i).set(j, val);
				val = ( val * (i-j)) / (j+1); 
			}
		}
		return ans;
	}


}
