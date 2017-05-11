package com.practice.algo.and.ds.interviewbit;

public class DP_EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DP_EditDistance o = new DP_EditDistance();
		System.out.println(o.minDistance("wet", "wwet"));
	}
	public int minDistance(String a, String b) {
		int[][] dp = new int[a.length()+1][b.length()+1];
		if(a.trim().isEmpty() && b.trim().isEmpty())
			return 0;
		if(a.trim().isEmpty()){
			return b.length();
		}
		if(b.trim().isEmpty()){
			return a.length();
		}
		//we have to insert i characters to make empty string [0] to make string of length [i]
		for(int i=0;i<=b.length();i++){
			dp[0][i] = i;
		}
		//we have to delete i characters to make string of length [i] to make empty string [0]
		for(int i=0;i<=a.length();i++){
			dp[i][0] = i;
			
		}
		
		for(int i=1;i<=a.length();i++){
			for(int j=1;j<=b.length();j++){
				if(a.charAt(i-1)==b.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]; 
				}else{
					//Replace
					int replace = dp[i-1][j-1]+1;
					int insert = dp[i][j-1]+1;
					int delete = dp[i-1][j] + 1;
					dp[i][j] = Math.min(replace, Math.min(insert,delete));
				}
				
			}
		}
		return dp[a.length()][b.length()];
	}
}
