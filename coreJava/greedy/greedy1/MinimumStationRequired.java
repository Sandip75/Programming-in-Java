package coreJava.greedy.greedy1;

import java.util.*;

public class MinimumStationRequired {

	public static void main(String[] args) {
		int[] arrivals = { 900, 940, 950, 1100, 1500, 1800 };
		int[] departures = { 910, 1200, 1120, 1130, 1900, 2000 };
		int ans = minimumStationRequired(arrivals, departures);
		System.out.println(ans);

	}

	public static int minimumStationRequired(int[] arrivals, int[] departures) {

		Arrays.sort(arrivals);
		Arrays.sort(departures);
		int i = 0;
		int j = 0;
		int cars = 0;

		int max = Integer.MIN_VALUE;
		while (i < arrivals.length && j < departures.length) {
			if (arrivals[i] < departures[j]) {
				cars++;
				i++;
			} else {
				cars--;
				j++;
			}

			if (max < cars) {
				max = cars;
			}
		}

		return max;
	}
}
