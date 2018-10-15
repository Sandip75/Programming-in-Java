package problemSolution.interviewBit.level3.bitManipulation;

public class ReverseBits {

	public static void main(String[] args) {
		long ans = reverse(3);
		System.out.println(ans);
	}

	public static long reverse(long a) {
		long ans = 0;
		for (int i = 0; i < 32; i++) {
			ans = ans << 1;
			System.out.println(Integer.toBinaryString((int) ans));
			if ((a & (1 << i)) != 0)
				ans = ans | 1;
			//System.out.println(Integer.toBinaryString((int) ans));
		}
		return ans;
	}
}
