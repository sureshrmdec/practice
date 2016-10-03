package com.practice.algo.and.ds.dp;

import org.omg.CosNaming.NamingContextPackage.NotFound;

public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 =  "abxbaxc";
		String str2 = "cabccbacbacab";
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		lcs.longestCommonSubsequence(str1,str2);
	}

	int dp[][] ;
	private void longestCommonSubsequence(String str1, String str2) {
		// TODO Auto-generated method stub
	dp	= new int[str1.length()+1][str2.length()+1];	
	String lcs = "";
	int i=0,j=0;
	for(i=0;i<str1.length();i++){
		for(j=0;j<str2.length();j++){
		
			if(str1.charAt(i)==str2.charAt(j)){
				dp[i+1][j+1] = dp[i][j] + 1; 
				
			}else{
				dp[i+1][j+1] =
                    Math.max(dp[i+1][j], dp[i][j+1]);
			}
		}	
		
		
		
	}
		System.out.println(dp[dp.length-1][dp[0].length-1]);
		
	}
	}
