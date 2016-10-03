package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class DP_CoinSumInfinite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] S = {1,2,3}; 
		int N = 4;
		DP_CoinSumInfinite dp = new DP_CoinSumInfinite();
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(S));
		System.out.println(dp.ways(S, N));
		System.out.println(dp.coinchange2(a, N));
	}

	public int ways(Integer[] S,int N){
		int coinsL = S.length;
		int sum = N;
		int[][] dp = new int[coinsL+1][sum+1];
		for(int i=1;i<=S.length;i++){
			dp[i][0]  = 1;
		}
		for(int i=1;i<=coinsL;i++){
			int currentCoinValue = S[i-1];
			for(int j=1;j<=sum;j++){
				if(j<currentCoinValue){
					// just copy the value from the top
					dp[i][j] = dp[i-1][j];
					continue;
				}
				dp[i][j] = dp[i][j-currentCoinValue] + dp[i-1][j];
			}
		}
		return (dp[coinsL][sum]) ;
	}
	public int coinchange2(ArrayList<Integer> a, int b) {

		int coinsL = a.size();
		int sum = b;
		Integer[][] dp = new Integer[coinsL+1][sum+1];
		for(int i=0;i<dp.length;i++){
			Arrays.fill(dp[i], 0);
		}
		for(int i=1;i<=coinsL;i++){
			dp[i][0]  = 1;
		}
		for(int i=1;i<=coinsL;i++){
			int currentCoinValue = a.get(i-1);
			for(int j=1;j<=sum;j++){
				if(j<currentCoinValue){
					// just copy the value from the top
					dp[i][j] = dp[i-1][j];
					continue;
				}
						   //include this coin value + exclude	
				dp[i][j] = dp[i][j-currentCoinValue] + (dp[i-1][j]);
			}
		}
		return (BigInteger.valueOf(dp[coinsL][sum]%1000007)).intValue();
	
    }
}
