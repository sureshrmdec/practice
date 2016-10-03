package com.practice.algo.and.ds.interviewbit;

/*
 * Well, This problem can be solved by Suffix Tree too.
 *  This problem can be solved in linear time and space [ Θ(n) ] by building a suffix tree for the string.
 *  URL : https://en.wikipedia.org/wiki/Longest_repeated_substring_problem
 */
public class DP_RepeatingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DP_RepeatingSubsequence o = new DP_RepeatingSubsequence();
		String a = "abc";
		System.out.println(o.getLongestRepeatingSubsequence(a));
	}

	public int getLongestRepeatingSubsequence(String a){
		int result = 0;
		int[][] dp = new int[a.length()+1][a.length()+1];
		for(int i=1;i<=a.length();i++){
			for(int j=1;j<=a.length();j++){
				if(a.charAt(i-1)==a.charAt(j-1) && i!=j){
					dp[i][j] = 1 + dp[i-1][j-1]; 
				}else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}	
		}
		return dp[dp.length-1][dp.length-1];
	}
}
