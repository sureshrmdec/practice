package com.practice.algo.and.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays_N3RepeatNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] ina = {1,1,1,1,2,3,3,3,3,5,5,5,5};
		// {1000727, 1000727, 1000641, 1000517, 1000212, 1000532, 1000727,
		// 1001000, 1000254, 1000106, 1000405, 1000100, 1000736, 1000727,
		// 1000727, 1000787, 1000105, 1000713, 1000727, 1000333, 1000069,
		// 1000727, 1000877, 1000222, 1000727, 1000505, 1000641, 1000533,
		// 1000727, 1000727, 1000727, 1000508, 1000475, 1000727, 1000573,
		// 1000727, 1000618, 1000727, 1000309, 1000486, 1000792, 1000727,
		// 1000727, 1000426, 1000547, 1000727, 1000972, 1000575, 1000303,
		// 1000727, 1000533, 1000669, 1000489, 1000727, 1000329, 1000727,
		// 1000050, 1000209, 1000109};
		// {1,1,1,1,2,3,3,3,3,5,5,5,5};
		Arrays_N3RepeatNumber f = new Arrays_N3RepeatNumber();
		System.out.println(f.repeatedNumber(new ArrayList<Integer>(Arrays.asList(ina))));
		
	}

/*	public int repeatedNumber(final List<Integer> a) {

		int n = a.size();
		int counts = 0;
		Element[] k = new Element[2];
		for (int i = 0; i < a.size(); i++) {
			int e = a.get(i);
			boolean done = false;
			for (int j = 0; j < 2; j++) {
				if (k[j] != null && k[j].number == e) {
					k[j].count++;
					done = true;
					break;
				}
				if (k[j] == null) {
					k[j] = new Element(e, 0);
					done = true;
					break;
				}
			}
			if (!done) {
				boolean done2 = false;
				for (int j = 0; j < 2; j++) {
					Element existing = k[j];
					if (existing.number == e) {
						existing.count++;
						k[j] = existing;
						done2 = true;
					}

				}
				if (!done2) {
					for (int j = 0; j < 2; j++) {
	
							if (k[j].count == 0) {// find the empty place and add it
								k[j].number = e;
								break;
							}
						}
						// if we have reached here means array is full
						// reduce the counter of every element
						for (int j = 0; j < emts.length; j++) {
							emts[j].count--;
						}
					}

				}
			}
		}
		 Step 3: Check actual counts of potential candidates in temp[] 
		for (int i = 0; i < 2; i++) {
			// Calculate actual count of elements
			int ac = 0; // actual count
			if (k[i] != null) {
				for (int j = 0; j < n; j++)
					if (a.get(j) == k[i].number)
						ac++;
			}
			// If actual count is more than n/k, then print it
			if (ac > n / 3)
				return k[i].number;
		}
		return -1;
	}*/

	public int repeatedNumber(final List<Integer> a) {
		Integer[] arrA = new Integer[a.size()]; 
		a.toArray(arrA);
		Element[] emts = new Element[2];
		for (int j = 0; j < emts.length; j++) {
			emts[j] = new Element(0, 0);
		}
		for (int i = 0; i < arrA.length; i++) {
			int index = found(emts, arrA[i]);
			if (index >= 0) {
				// means element found in Elements array
				// just increase its count
				emts[index].count++;
			} else {
				addtoArray(emts, arrA[i]);
			}
		} //
		// now check if any of the elements in the Elements array appears
		// more than n/k times
		for (int i = 0; i < emts.length; i++) {
			int cnt = 0;
			for (int j = 0; j < arrA.length; j++) {
				if (arrA[j] == emts[i].number) {
					cnt++;
				}
			}
			if (cnt > (arrA.length / 3)) {
				System.out.println(emts[i].number + " appears more than n/" + 3 + " times, Actual count is " + cnt);
				return emts[i].number;
				
			}
		}
		return -1;
	}

	public void addtoArray(Element[] emts, int x) {
		// check is array is full or not
		for (int j = 0; j < emts.length; j++) {
			if (emts[j].count == 0) {// find the empty place and add it
				emts[j].number = x;
				emts[j].count = 1;
				return;
			}
		}
		// if we have reached here means array is full
		// reduce the counter of every element
		for (int j = 0; j < emts.length; j++) {
			emts[j].count--;
		}
	}

	// This found function will check whether element already exist or not
	// if yes then return its index else return -1
	public int found(Element[] emts, int x) {
		for (int j = 0; j < emts.length; j++) {
			if (emts[j].number == x) {
				return j;
			}
		}
		return -1;
	}

}

class Element {
	int number;
	int count;

	public Element(int number, int count) {
		this.number = number;
		this.count = count;
	}
}