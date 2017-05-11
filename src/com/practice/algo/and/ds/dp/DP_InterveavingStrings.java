package com.practice.algo.and.ds.dp;

public class DP_InterveavingStrings {

	public static void main(String[] args) {
		DP_InterveavingStrings o = new DP_InterveavingStrings();
		System.out.println(o.isInterleaved("aabcc","dbbca", "aadbbcbcac"));

	}

	public boolean isInterleaved(String a,String b,String c){
		if(c.length()<a.length()+b.length()){
			return false;
		}
		boolean[][] dp = new boolean[a.length()+1][b.length()+1];
		for(int i=1;i<=a.length();i++){
			if(c.substring(0, i).equals(a.substring(0, i))){
				dp[i][0] = true;
			}else{
				dp[i][0] = false;
			}
		}
		for(int i=1;i<=b.length();i++){
			if(c.substring(0, i).equals(b.substring(0, i))){
				dp[0][i] = true;
			}else{
				dp[0][i] = false;
			}
		}
		
		for(int i=1;i<=a.length();i++){
			for(int j=1;j<=b.length();j++){
				if(dp[i-1][j]){
					char ci = a.charAt(i-1);
					if(c.charAt(i+j-1)==ci){
						dp[i][j]=true;
					}
				}
				if(dp[i][j-1]){
					char cj = b.charAt(j-1);
					if(c.charAt(i+j-1)==cj){
						dp[i][j]=true;
					}
				}
			}
		}
		return dp[a.length()][b.length()];
	}
}
