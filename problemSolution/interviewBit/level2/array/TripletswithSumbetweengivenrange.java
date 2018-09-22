package problemSolution.interviewBit.level2.array;

import java.util.*;

public class TripletswithSumbetweengivenrange {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("0.6");
		al.add("0.7");
		al.add("0.8");
		al.add("1.2");
		al.add("0.4");

		int ans = solve(al);
		System.out.println(ans);
	}

	public static int solve(ArrayList<String> A) {

		for(int i=0 ; i < A.size() ; i++){
			String t = A.get(i); 
			int temp = (int)(t - "0");
		}
		
		
		return 0;
	}

}
