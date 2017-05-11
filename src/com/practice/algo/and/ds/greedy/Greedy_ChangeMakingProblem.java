package com.practice.algo.and.ds.greedy;

import java.util.Arrays;

//http://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
//Its a DP problem , see DP_MinCoinChangeProblem in dp package
public class Greedy_ChangeMakingProblem {

	public static void main(String[] args) {
		Greedy_ChangeMakingProblem o = new Greedy_ChangeMakingProblem();
		int[] coins = {25,10,5};
		o.minCoins(coins, 30);

	}
	public int minCoins(int coins[], int V){
		Arrays.sort(coins);
		helper(coins,V,0);
		return min;
	}
	int min = Integer.MAX_VALUE;
	private void helper(int[] coins, int v,int numberOfCoins) {

		if(v==0)
			min = Math.min(min, numberOfCoins);
		for(int i = 0;i<coins.length;i++){
			if(v-coins[i]<0)
				return;
			helper(coins, v-coins[i],numberOfCoins+1);
		}
		
	}
}
