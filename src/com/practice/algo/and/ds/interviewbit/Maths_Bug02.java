package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;

public class Maths_Bug02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maths_Bug02 n = new Maths_Bug02();
		System.out.println(n.squareSum(8));
	}

	public ArrayList<ArrayList<Integer>> squareSum(int A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		for (int a = 0; a * a < A; a++) {
			for (int b = 0; b * b < A; b++) {
				if(a<=b)
				if (a * a + b * b == A) {
					ArrayList<Integer> newEntry = new ArrayList<Integer>();
					newEntry.add(a);
					newEntry.add(b);
					ans.add(newEntry);
				}
			}
		}
		return ans;
	}
}
