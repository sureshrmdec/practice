package com.practice.algo.and.ds.dp;

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

			minDistance(a, b);
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

	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
	 
		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];
	 
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
	 
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}
	 
		//iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);
	 
				//if last two chars equal
				if (c1 == c2) {
					//update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;
	 
					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}
	 
		return dp[len1][len2];
	}
}
