package com.practice.algo.and.ds.spoj;

import java.util.Scanner;

public class Editdistance_EDIST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Integer T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			String a = sc.next();
			String b = sc.next();

			int[][] dp = new int[a.length()][b.length()];
			dp[a.length()-1][b.length()-1] = (a.charAt(a.length()-1) == b.charAt(b.length()-1)) ? 0: 1;
			
			for (int j = b.length() - 2; j >= 0; j--) {
					dp[a.length() - 1][j] = 1 + dp[a.length() - 1][j + 1];
		        }
			for (int ii = a.length() - 2; ii >= 0; ii--) {
				 dp[ii][b.length() - 1] = 1 + dp[ii + 1][b.length() - 1];
	        }
			// bottom up
			for (int j = a.length() - 2; j >= 0; j--) {
				for (int k = b.length() - 2; k >= 0; k--) {
					int v = ((a.charAt(j) == b.charAt(k)) ? 0
							: 1) + dp[j+1][k+1];
					int vv = (Math.min(dp[j][k+1], dp[j+1][k])) + 1;
					dp[j][k] = Math.min(v, vv);
				}
			}
			System.out.println(dp[0][0]);
		}
	}

}
