package com.practice.algo.and.ds.dp;

public class DP_LeetCode_LongestPalindromicSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DP_LeetCode_LongestPalindromicSequence lps = new DP_LeetCode_LongestPalindromicSequence();
		String str = "bbbab";
		System.out.println(lps.find(str));
		
	}

	private int find(String str) {
		// TODO Auto-generated method stub
		int[][] dp = new int[str.length()][str.length()];
		
		for(int i=0;i<dp.length;i++){
			dp[i][i] = 1;
		}
/*		for(int i=0;i<dp.length-1;i++){
			if(str.charAt(i)==str.charAt(i+1)){
				dp[i][i+1] = 2;	
			}else{
				dp[i][i+1] = 1;
			}
			
			
		}*/
		
		for(int gap=1;gap<str.length();gap++){
			for(int i=0;i<dp.length-gap;i++){
				if(str.charAt(i) == str.charAt(i+gap)){
					dp[i][i+gap] = dp[i+1][i+gap-1] + 2; 
				}else{
					dp[i][i+gap] = Math.max(dp[i][i+gap-1],dp[i+1][i+gap]);	
				}
		}
		}
		return dp[0][dp.length-1];
		
	}

}
