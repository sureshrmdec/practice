package com.practice.algo.and.ds.dp;

public class MinimumInsertionPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "abcddc";
		MinimumInsertionPalindrome m = new MinimumInsertionPalindrome();
		System.out.println(m.findMinInsertion(str));
	}

	private int findMinInsertion(String str) {
		// TODO Auto-generated method stub
		int[][] dp = new int[str.length()][str.length()];
		int gap = 1;int i;
		for(gap=1;gap<str.length();gap++){
			for(i=0;i<str.length()-gap;i++){
				if(str.charAt(i)==str.charAt(i+gap)){
					dp[i][i+gap] =  dp[i+1][gap-1];	
				}else{
					dp[i][i+gap] = Math.min(dp[i][i+gap-1], 
							dp[i+1][i+gap])+1;
				}
				
			}
		}
		return dp[0][str.length()-1];
	}

}
