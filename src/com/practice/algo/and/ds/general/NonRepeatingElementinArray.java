package com.practice.algo.and.ds.general;

public class NonRepeatingElementinArray { 

	public static void main(String[] args) {
		int a[] = { 3,4,3};

		System.out.println(nonRepeatingElement(a));
	}

	private static int nonRepeatingElement(int[] a) {
		int element = 0;

		for (int i = 0; i < a.length; i++) {
			element ^= a[i];
			System.out.println(element);
		}

		return element;
	}
}
