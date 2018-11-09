package coreJava.greedy.greedy1;

public class Item implements Comparable<Item> {

	int wt;
	int val;
	double ratio;

	@Override
	public int compareTo(Item o) {
		if (this.ratio > o.ratio) {
			return 1;
		} else if (this.ratio < o.ratio) {
			return -1;
		} else {
			return 0;
		}
	}

}
