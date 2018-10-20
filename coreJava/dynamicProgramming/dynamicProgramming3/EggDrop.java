package coreJava.dynamicProgramming.dynamicProgramming3;

public class EggDrop {

	public static void main(String[] args) {
		int egg = 2;
		int floor = 10;
		int ans = eggDrop(egg, floor, new int[egg + 1][floor + 1]);
		System.out.println(ans);
	}

	public static int eggDrop(int egg, int floor, int[][] m) {

		if (floor == 0 || floor == 1 || egg == 1) {
			return floor;
		}

		if (m[egg][floor] != 0) {
			return m[egg][floor];
		}

		int min = Integer.MAX_VALUE;
		for (int x = 1; x <= floor; x++) {
			int res = Math.max(eggDrop(egg, floor - x, m), eggDrop(egg - 1, x - 1, m));
			if (res < min) {
				min = res;
			}
		}

		m[egg][floor] = min + 1;
		return min + 1;
	}

}
