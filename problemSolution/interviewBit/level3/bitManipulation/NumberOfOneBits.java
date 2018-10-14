package problemSolution.interviewBit.level3.bitManipulation;

public class NumberOfOneBits {

	public static void main(String[] args) {
		int ans = numSetBits(429496729);
		System.out.println(ans);
		int ans2 = numSetBitsBetter(429496729);
		System.out.println(ans2);
	}

	public static int numSetBits(long a) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			int mask = 1 << i;
			if ((mask & a) == mask) {
				count = count + 1;
			}
		}
		return count;
	}

	public static int numSetBitsBetter(long a) {
		int count = 0;
		while (a != 0) {
			count = count + 1;
			a = a & (a - 1);
		}
		return count;
	}

}
