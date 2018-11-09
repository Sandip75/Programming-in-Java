package coreJava.greedy.greedy1;

import java.util.*;

public class FractionalKnapsack {

	public static void main(String[] args) {
		int[] wts = { 10, 40, 20, 30 };
		int[] price = { 60, 40, 100, 120 };
		int target = 50;
		fractionalKnapsack(wts, price, target);
	}

	public static void fractionalKnapsack(int[] wts, int[] price, int target) {
		Item[] items = new Item[wts.length];

		for (int i = 0; i < items.length; i++) {
			items[i] = new Item();
			items[i].wt = wts[i];
			items[i].val = price[i];
			items[i].ratio = price[i] * 1.0 / wts[i];
		}

		Arrays.sort(items);
		int rc = target;
		int value = 0;
		int i = items.length - 1;
		while (rc != 0) {
			if (rc >= items[i].wt) {
				rc -= items[i].wt;
				value += items[i].val;
				i--;
			} else {
				value += rc * items[i].ratio;
				rc = 0;
			}
		}
		System.out.println(value);
	}
}
