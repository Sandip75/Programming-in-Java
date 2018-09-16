package problemSolution.interviewBit.level2.array;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(5);
		al.add(3);
		al.add(2);
		al.add(4);
		//al.add(6);

		al = wave(al);
		for (int val : al) {
			System.out.print(val + " ");
		}
	}

	public static ArrayList<Integer> wave(ArrayList<Integer> A) {
		ArrayList<Integer> ans = new ArrayList<>();
		Collections.sort(A);
		for (int i = 0; i < A.size(); i = i + 2) {
			if ((i + 1) < A.size()) {
				ans.add(A.get(i + 1));
			}
			ans.add(A.get(i));
		}
		return ans;
	}

}
