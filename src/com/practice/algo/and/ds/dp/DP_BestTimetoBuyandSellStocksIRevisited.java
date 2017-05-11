package com.practice.algo.and.ds.dp;

public class DP_BestTimetoBuyandSellStocksIRevisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7, 6, 4, 3, 1};
		DP_BestTimetoBuyandSellStocksIRevisited o = new DP_BestTimetoBuyandSellStocksIRevisited();
		System.out.println(o.maxProfit(prices));
	}
    public int maxProfit(int[] prices) {
    	if(prices.length==0){
    		return 0;
    	}
       int result = 0;
       int min = prices[0];
       for(int i=1;i<prices.length;i++){
    	   if(prices[i]<min){
    		   min = prices[i];
    	   }
    		   result = Math.max(result, prices[i]-min);
       }
       return result;
    }
}
