package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;
import java.util.List;

//https://www.careercup.com/question?id=5643607445864448

public class CareerCup_AddANumberToAnArray {
	public static void main(String[] args) {


		Integer[] a = {9, 9, 2};
		int g = 385;
		List<Integer> list = new ArrayList<>();
		for (int i = a.length -1 ; i >= 0; i--) {
			g = a[i] + g;
			list.add(0, g % 10);
			g = g / 10;
		}
		//In case the number is greater than array size 
		while ( g >= 10) {
			list.add(0, g % 10);
			g = g / 10;
		}
		list.add(0, g);
		list.toArray(a);
		System.out.println(list);
	}
}
