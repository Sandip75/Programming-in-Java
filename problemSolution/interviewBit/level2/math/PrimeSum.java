package problemSolution.interviewBit.level2.math;

import java.util.*;

public class PrimeSum {

	public static void main(String[] args) {
		int n = 40;
		System.out.println(primeSum(n));
	}

	public static ArrayList<Integer> primeSum(int A) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int l = 2;
		int r = A - 2;
		while (l <= r) {
			if (isPrime(l) && isPrime(r)) {
				ans.add(l);
				ans.add(r);
				break;
			}
			l++;
			r--;
		}
		return ans;
	}

	private static boolean isPrime(int a) {

		int i = 2;
		while ((i * i) <= a) {
			if (a % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}
}
