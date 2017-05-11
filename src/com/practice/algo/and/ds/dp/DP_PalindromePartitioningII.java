package com.practice.algo.and.ds.dp;

//Similar to Word Break Problem
public class DP_PalindromePartitioningII {

	public static void main(String[] args) {
		DP_PalindromePartitioningII o = new DP_PalindromePartitioningII();
		//	System.out.println(o.minCutS("aaba"));

		System.out.println(o.minCutS("aaabbaaaa"));
		System.out.println(o.minCutS("abcc"));
		//System.out.println(o.minCutS("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
	public int minCut(String s) {
		int[][] dp = new int[s.length()][s.length()];

		//i is a step size here
		for (int i = 0; i < s.length(); i++){
			for (int j = 0; j < s.length() - i; j++) {
				int r = j, c = i + j;
				if(i==0){
					dp[r][c] = 0;
				}else{
					if(isPalindrome(s.substring(r, c+1))){
						dp[r][c] = 0;
					}else{
						int cutsForThis = Integer.MAX_VALUE;
						for(int ii=r;ii<c;ii++){
							int cutsForThisPossibility = dp[r][ii] + dp[ii+1][c] + 1;
							cutsForThis = Math.min(cutsForThis, cutsForThisPossibility);
						}
						dp[r][c] = cutsForThis;
					}
				}

			}
		}


		return dp[0][s.length()-1];
	}
	public boolean isPalindrome(String s) {
		int l = 0;
		int h = s.length()-1;
		while(l<h){
			if (s.charAt(l) != s.charAt(h)) {
				return false;
			}
			l++;
			h--;
		}

		return true;
	}
	static boolean[][] dpPalindromeCheck ;
	public boolean isPalindrome(int start,int end,String s) {
		if(end-start==1){
			if(s.charAt(start)==s.charAt(end))
				dpPalindromeCheck[start][end] = true;
			return dpPalindromeCheck[start][end];
		}
		if(end-start==0){
			dpPalindromeCheck[start][end] = true;
			return dpPalindromeCheck[start][end];
		}
		if(s.charAt(start)!=s.charAt(end))
			return false;
		if(dpPalindromeCheck[start+1][end-1]){
			dpPalindromeCheck[start][end]=true;
			return dpPalindromeCheck[start][end];
		}
		

		return false;
	}

	public int minCutS(String s) {

		int[] dp = new int[s.length()];
		dpPalindromeCheck = new boolean[s.length()][s.length()];
		for(int i=0;i<s.length();i++){
			dpPalindromeCheck[i][i] = true;
		}
		
		dp[0] = 0;

		for(int i=1;i<s.length();i++){
			if(isPalindrome(0,i,s)){
				dp[i]=0;
			}else{
					dp[i]=dp[i-1]+1;
					for(int k=1;k<=i;k++){
						if(isPalindrome(k,i,s)){
							dp[i] = Math.min(dp[i],dp[k-1]+1);
							//break;
						}
					}
				
			}
		}
		return dp[s.length()-1];
	}
}
