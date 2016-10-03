package com.practice.algo.and.ds.dp;

public class LongestPalindromicSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LongestPalindromicSequence lps = new LongestPalindromicSequence();
		String str = "astsklmlkstas";
		System.out.println(lps.find(str));
		
	}

	private int find(String str) {
		// TODO Auto-generated method stub
		int[][] dp = new int[str.length()+1][str.length()+1];
		
		for(int i=1;i<dp.length;i++){
			dp[i][i] = 1;
		}
		for(int i=1;i<dp.length-1;i++){
			if(str.charAt(i-1)==str.charAt(i)){
				dp[i][i+1] = 2;	
			}
			
		}
		
		for(int gap=2;gap<str.length();gap++){
			for(int i=0;i<dp[0].length-gap-1;i++){
				if(str.charAt(i) == str.charAt(i+gap)){
					dp[i+1][i+gap] = dp[i+1][i+gap-1] + 2; 
				}else{
					dp[i+1][i+gap] = Math.max(dp[i+1][i+gap-1],dp[i+2][i+gap]);	
				}
		}
		}
		return dp[1][dp.length-2];
		
	}

}
