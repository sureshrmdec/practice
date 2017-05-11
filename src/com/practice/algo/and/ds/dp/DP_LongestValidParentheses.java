package com.practice.algo.and.ds.dp;

public class DP_LongestValidParentheses {
//http://www.sigmainfy.com/blog/leetcode-longest-valid-parentheses.html
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "()((()))";
		System.out.println(longestValidParentheses(s));


	}
	public static  int longestValidParentheses(String s) {
		if(s.isEmpty() || s.length()<2){
            return 0;
        }
		int res = 0;
		int[] dp = new int[s.length()+1];
		for(int i=2;i<=s.length();i++){
			if(s.charAt(i-1)==')'){
				int a=0;
				int b = 0;
				if(s.charAt(i-2)=='('){
					a = dp[i-2] + 2;
				}
				if(s.charAt(i-2)==')' && i-dp[i-1]-2 >=0 && s.charAt(i-dp[i-1]-2)=='('){
					b = dp[i-1] + 2 + dp[i-dp[i-1]-2];
				}
				dp[i] = Math.max(a, b);
				res = Math.max(res, dp[i]);
			}
		}
		return res;
	}
}
