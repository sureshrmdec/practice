package com.practice.algo.and.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Arrays_SetMatrixZeros {

	public static void main(String[] args) {

		Arrays_SetMatrixZeros aa = new Arrays_SetMatrixZeros();
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		Integer[] a1 = { 1, 0 };
		Integer[] a2 = { 1, 1 };
		Integer[] a3 = { 1, 0 };
		// Integer[] a3 = {1,1,1};
		a.add(new ArrayList<Integer>(Arrays.asList(a1)));
		a.add(new ArrayList<Integer>(Arrays.asList(a2)));
		a.add(new ArrayList<Integer>(Arrays.asList(a3)));
		aa.setZeroes(a);

	}

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		int rows = a.size();
		int cols = a.get(0).size();
		boolean[] rowzero = new boolean[rows];
		boolean[] colzero = new boolean[cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (a.get(r).get(c) == 0) {
					rowzero[r] = true;
					colzero[c] = true;
				}
			}
		}
		for (int r = 0; r < rows; r++) {
			if (rowzero[r]) {
				for (int c = 0; c < cols; c++) {
					a.get(r).set(c, 0);
				}
			}
		}
		for (int c = 0; c < cols; c++) {
			if (colzero[c]) {
				for (int r = 0; r < rows; r++) {
					a.get(r).set(c, 0);
				}
			}
		}
	}

}
