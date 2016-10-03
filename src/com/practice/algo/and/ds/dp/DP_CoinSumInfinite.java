package com.practice.algo.and.ds.dp;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class DP_CoinSumInfinite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = {1,2,3}; 
		int N = 5;
		DP_CoinSumInfinite dp = new DP_CoinSumInfinite();
		System.out.println(dp.ways(S, N));
	}

	public int ways(int[] S,int N){
		int coinsL = S.length;
		int sum = N;
		int[][] dp = new int[coinsL+1][sum+1];
		for(int i=1;i<S.length;i++){
			dp[i][0]  = 1;
		}
		for(int i=1;i<=coinsL;i++){
			int currentCoinValue = S[i-1];
			for(int j=1;j<=sum;j++){
				if(j<currentCoinValue){
					dp[i][j] = dp[i-1][j];
					continue;
				}
				dp[i][j] = dp[i][j-currentCoinValue] + dp[i-1][j];
			}
		}
		return dp[coinsL][sum];
	}
}
