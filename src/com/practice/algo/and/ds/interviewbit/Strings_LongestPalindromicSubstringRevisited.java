package com.practice.algo.and.ds.interviewbit;

public class Strings_LongestPalindromicSubstringRevisited {

	public static void main(String[] args) {
		String s = "abcda";
		Strings_LongestPalindromicSubstringRevisited o = new Strings_LongestPalindromicSubstringRevisited();
		System.out.println(o.longestPalindrome(s));

	}
	public String longestPalindrome(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		for(int i=0;i<s.length();i++){
			dp[i][i] = true;
		}
		String result = "";
		//i is a step size here
		for (int i = 0; i < s.length(); i++){
			for (int j = 0; j < s.length() - i; j++) {
				int r = j, c = i + j;
				if(r==c){
					dp[r][c]=true;
					if(result.length()<c-r+1){
						result = s.substring(r, c+1);
					}
				}
				else if(c==r+1){
					if(s.charAt(r)==s.charAt(c)){
						dp[r][c]=true;
						if(result.length()<c-r+1){
							result = s.substring(r, c+1);
						}
					}
				}else if(s.charAt(r)==s.charAt(c)){
					if(dp[r+1][c-1]){
						dp[r][c]=true;
						if(result.length()<c-r+1){
							result = s.substring(r, c+1);
						}
					}

				}

			}
		}
		return result;
	}
}