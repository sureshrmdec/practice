package com.practice.algo.and.ds.dp;

import java.util.Arrays;


public class DP_MinCoinChangeProblem {

	public static void main(String[] args) {
		DP_MinCoinChangeProblem o = new DP_MinCoinChangeProblem();
		int[] coins = {2};
		o.coinChange(coins, 1);

	}
	public int coinChange(int coins[], int amount){
		if(amount<1) return 0;
		int[] dp = new int[amount+1];
		Arrays.sort(coins);
		dp[0] = 0;
		for(int i =1;i<=amount;i++){
			int min = -1;
			for(int j = 0;j<coins.length;j++){
				if(coins[j] > i) 
					break;
				if(coins[j]<=i){
					if(dp[i-coins[j]]!=-1){
						int temp = dp[i-coins[j]]+1;
						min = min<0 ? temp : (temp < min ? temp : min);
					}   
				}
			}
			dp[i] = min;
		}
		return dp[amount];
	}
	
	
	
	
	
	
	// DP recursive
	public int coinChangeRecursive(int[] coins, int amount) {
	    if(amount<1) return 0;
	    return helper(coins, amount, new int[amount]);
	}

	private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
	    if(rem<0) return -1; // not valid
	    if(rem==0) return 0; // completed
	    if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse
	    int min = Integer.MAX_VALUE;
	    for(int coin : coins) {
	        int res = helper(coins, rem-coin, count);
	        if(res>=0 && res < min)
	            min = 1+res;
	    }
	    count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
	    return count[rem-1];
	}

}
