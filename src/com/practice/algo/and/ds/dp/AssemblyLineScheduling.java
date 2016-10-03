package com.practice.algo.and.ds.dp;

public class AssemblyLineScheduling {


	public static void main(String[] args) {

		int a[][]  = {{4, 5, 3, 2},
					  {2, 10, 1, 4}};
		int t[][] = {{0, 7, 4, 5},
				     {0, 9, 2, 8}};
		int e[] = {10, 12}, x[] = {18, 7};
		carAssembly(a, t, e, x);
	}

	private static void carAssembly(int[][] a, int[][] t, int[] e, int[] x) {
		// TODO Auto-generated method stub

		
		
		int[][] dp = new int[2][a[0].length];
		dp[0][0] = e[0] + a[0][0];
		dp[1][0] = e[1] + a[1][0];
		
		for(int i=1;i<a[0].length;i++){
			dp[0][i] = Math.min(dp[0][i-1] + a[0][i],dp[1][i-1] + t[1][i] + a[0][i]); 
			dp[1][i] = Math.min(dp[1][i-1] + a[1][i],dp[0][i-1] + t[0][i] + a[1][i]);
		}
	}

}
