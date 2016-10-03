package com.practice.algo.and.ds.dp;

import java.util.Scanner;

public class LongestCommonSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonSubstring s= new LongestCommonSubstring();

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++){
			String a = sc.next();
			String b = sc.next();
			s.getLongestCommonSubstring(a, b);
		}

	
	
	}

	private void getLongestCommonSubstring(String a, String b) {
		// TODO Auto-generated method stub
		int[][] dp = new int [a.length()+1][b.length()+1];
		int result =0;
		for(int i=0;i<a.length();i++){
			for(int j=0;j<b.length();j++){
				if(a.charAt(i)==b.charAt(j)){
					dp[i+1][j+1]= 1 + dp[i][j];
					result = Math.max(dp[i+1][j+1], result);
				}else{
					dp[i+1][j+1]= 0;
				}
			}	
		}
	System.out.println(result);	
	}

}
