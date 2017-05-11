package com.practice.algo.and.ds.dp;

import java.util.ArrayList;
import java.util.List;

public class DP_RegularExpressionII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DP_RegularExpressionII o = new DP_RegularExpressionII();
		//System.out.println(o.isMatch(".*in.*der", "devinder"));
		System.out.println(o.isMatch("c*a*b", "aab"));
		System.out.println(o.isMatch("a*c", "aaabc"));
		System.out.println(o.isMatch("a*b.*y", "ay"));
		System.out.println(o.isMatch("a*b.*y", "by"));
		System.out.println(o.isMatch("a*b.*y", "bly"));
		
	}

	public int isMatch(String regex, String input) {
        
        boolean[][] dp = new boolean[input.length() + 1][regex.length() + 1];

        dp[0][0] = true;
        for (int j = 1; j <= regex.length(); j++) {
            char c = regex.charAt(j - 1);
            if (c == '*') {
                dp[0][j] = dp[0][j-2];
            }
        }

        for (int i = 1; i <= input.length(); i++) {
            char inputChar = input.charAt(i - 1);
            for (int j = 1; j <= regex.length(); j++) {
                char regexChar = regex.charAt(j - 1);
                if (inputChar == regexChar || regexChar == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (regexChar == '*') {
                    char prevRegexChar = regex.charAt(j - 2);
                    if(prevRegexChar == inputChar || prevRegexChar == '.'){
                        //dp[i][j] = 1 occurance || 0 occurance || more occurances(1+)
                        dp[i][j] = dp[i][j-1] || dp[i][j-2] || dp[i-1][j];
                    } else{
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }

        return dp[input.length()][regex.length()] ? 1 : 0;
    
    }
}
