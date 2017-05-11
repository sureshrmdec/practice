package com.practice.algo.and.ds.interviewbit;

public class DP_DistinctSubsequence {

	public static void main(String[] args) {
		DP_DistinctSubsequence o = new DP_DistinctSubsequence();
		String s = "acacc";
		String t = "ac";
		System.out.println(o.getDistinctSequences( s, t));

	}

	/*    0 a c a c c     r a b b b i t
	 * 0  1 1 1 1 1 1   0 1 1 1 1 1 1 1
	 * a  0 1 1 2 2 2   r 1 1 1 1 1 1 1
	 * c  0 0 1 1 3 5 	a 0 1 1 1 1 1 1	if match charAt i and charAt j	
	 *  	 			b 0 0 1 2 3 3 3     	dp[i][j] = dp[i-1][j-1] 
	 * 				 	b 0 0 0 1 3 3 3		if(if match charAt j and charAt j-1)	
	 * 				 	i 0 0 0 0 0 3 3				dp[i][j] = dp[i][j-2]
	 * 				 	t 0 0 0 0 0 0 3
	 * */
	private int getDistinctSequences(String s, String t) {
		// TODO Auto-generated method stub
		int[][] dp = new int[t.length()+1][s.length()+1];
		for(int i=0;i<s.length();i++){
			dp[0][i] = 1; 
		}
		for(int i=1;i<=t.length();i++){
			for(int j=1;j<=s.length();j++){
				if(t.charAt(i-1)==s.charAt(j-1)){
					dp[i][j] =  dp[i-1][j-1] + dp[i][j-1];
					
				}else{
					dp[i][j] =  dp[i][j-1];
				}

			}
		}
		
		return dp[t.length()][s.length()];
	}

}
