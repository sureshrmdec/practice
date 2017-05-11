package com.practice.algo.and.ds.dp;

public class DP_BestTimeToBuyAndSellStocksIi {

	public static void main(String[] args) {
		DP_BestTimeToBuyAndSellStocksIi o = new DP_BestTimeToBuyAndSellStocksIi();
		int[] prices = {1,2,3,1,5};
		System.out.println(o.maxProfit(prices));

	}

	public int maxProfit(int[] prices) {
		int currentMin = prices[0];		
		int profit = 0;
		
		for(int i=1;i<prices.length;i++){
			
			if(prices[i]<prices[i-1]){
				// Sell the Stock
				profit+=prices[i-1]-currentMin;
				currentMin = prices[i];
			}
			
		}
		if(prices[prices.length-1]>currentMin)
			profit+=prices[prices.length-1]-currentMin;			
		return profit;
	}
}
