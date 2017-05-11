package com.practice.algo.and.ds.dp;


//I was asked this in Uber
public class DP_WaysToDecode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DP_WaysToDecode o = new DP_WaysToDecode();
		System.out.println(o.numDecodings("261105"));
	}
	public int numDecodings(String a) {
		if(a.charAt(0)=='0')
			return 0;
		if(a==null || a.isEmpty()){
			return 0;
		}
		int[] dp = new int[a.length()+1];
		
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=a.length();i++){
			
			dp[i] = dp[i-1];
			int n = Integer.parseInt(Character.toString(a.charAt(i-2)).concat(Character.toString(a.charAt(i-1))));
			if(n==0 || (n%10==0 && n>26))
				return 0;
			if(n>=1 && n<=26){
				if(n%10==0){
					dp[i] =  dp[i-2];
				}
				else if(n>=10){
					dp[i] +=  dp[i-2];	
				}
			}
			
		}
		return dp[dp.length-1];
	}
}
