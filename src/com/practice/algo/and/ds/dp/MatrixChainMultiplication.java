package com.practice.algo.and.ds.dp;

public class MatrixChainMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {40,20,30,10};
		int[] b = {20,30,10,30};
		MatrixChainMultiplication m = new MatrixChainMultiplication();
		System.out.println(m.findMinCalculations(a,b));
	}

	private int findMinCalculations(int[] a, int[] b) {
		// TODO Auto-generated method stub
		int[][] dp = new int[a.length][a.length];
		int gap= 1,l,h;
		for(gap=1;gap<a.length;gap++){
			for(l=0,h=gap;h<a.length;l++,h++){
				dp[l][h] = Math.min(dp[l][h-1],dp[l+1][h]) + (a[l]*a[h]*b[h]);
			}
		}
		return dp[0][a.length-1];

	}
}


