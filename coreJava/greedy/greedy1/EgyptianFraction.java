package coreJava.greedy.greedy1;

public class EgyptianFraction {

	public static void main(String[] args) {
		egyptianFraction(3, 7);
	}

	public static void egyptianFraction(int num, int dem) {
		if (num == 0) {
			return;
		}

		if (num == 1) {
			System.out.print(num + "/" + dem);
			return;
		}

		int dem1 = demB(num, dem);
		dem1 = dem1 / num;
		System.out.print("1" + "/" + dem1 + "  " + " + ");
		egyptianFraction(num * dem1 - dem, dem * dem1);

	}

	private static int demB(int num, int dem) {
		while ((dem % num) != 0) {
			dem = dem + 1;
		}
		return dem;
	}
}
