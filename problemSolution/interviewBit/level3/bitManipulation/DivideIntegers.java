package problemSolution.interviewBit.level3.bitManipulation;

public class DivideIntegers {

	public static void main(String[] args) {
		int A = 15;
		int B = 4;
		int ans = divide(A, B);
		System.out.println(ans);
	}

	public static int divide(int A, int B) {

		int ans = A & ~(B - 1);
		int temp = B - 1;
		int count = 0;
		while (temp != 0) {
			temp = temp & (temp - 1);
			count++;
		}

		int i = 1;
		while (i <= count) {
			System.out.println("hii");
			ans = ans >>> 1;
			i++;
		}

		return ans;
	}

}
