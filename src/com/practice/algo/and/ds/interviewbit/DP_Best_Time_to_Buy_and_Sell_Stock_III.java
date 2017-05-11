package com.practice.algo.and.ds.interviewbit;

public class DP_Best_Time_to_Buy_and_Sell_Stock_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,4,5,7,6,3,2,9};
		//int[] prices = {3,4,5,1,2,3,4,2,9};	
		System.out.println(maxProfit2(prices));
		System.out.println(maxProfit(prices));
	}
	public static int maxProfit(int[] prices) {
		if(prices.length==0){
            return 0;
        }
		int res = 0;
		int[] profitOnorBeforeI = new int[prices.length];
		int[] profitOnorAfterI = new int[prices.length];
		int min = prices[0];
		int maxProfit = Integer.MIN_VALUE;
		for(int i =1;i<prices.length;i++){
			if(prices[i]<min){
				min = prices[i];
			}
			profitOnorBeforeI[i] = Math.max(prices[i]-min, maxProfit);
			maxProfit = Math.max(maxProfit, profitOnorBeforeI[i]);
		}
		int max = prices[prices.length-1];
		maxProfit = Integer.MIN_VALUE;
		for(int i =prices.length-2;i>=0;i--){
			if(prices[i]>max){
				max = prices[i];
			}
			profitOnorAfterI[i] = Math.max(max-prices[i], maxProfit);
			maxProfit = Math.max(maxProfit, profitOnorAfterI[i]);
		}
		
		for(int i=0;i<profitOnorAfterI.length;i++){
			res = Math.max(res, profitOnorAfterI[i]+profitOnorBeforeI[i] );
		}
		return res;
	}
	
	public static int maxProfit2(int[] prices) {
		
		int currentMin = prices[0];
		int[] topTwo = new int[2];
		for(int i=1;i<prices.length;i++){
			if(prices[i]<prices[i-1]){
				int currentProfit = prices[i-1]-currentMin;
				int currentMininTopTwo = Math.min(topTwo[0], topTwo[1]);
				for(int j=0;j<topTwo.length;j++){
					if(topTwo[j]==0){
						topTwo[j] = currentProfit;
						break;
					}
					else if(currentProfit>currentMininTopTwo && topTwo[j]==currentMininTopTwo){
						topTwo[j] = currentProfit;
						break;
					}
				}
				currentMin = prices[i]; 
			}
		}
		if(prices[prices.length-1]>currentMin){
			int currentProfit = prices[prices.length-1]-currentMin;
			int currentMininTopTwo = Math.min(topTwo[0], topTwo[1]);
			for(int j=0;j<topTwo.length;j++){
				if(topTwo[j]==0){
					topTwo[j] = currentProfit;
					break;
				}
				else if(currentProfit>currentMininTopTwo && topTwo[j]==currentMininTopTwo){
					topTwo[j] = currentProfit;
					break;
				}
			}
		}
		return topTwo[0]+topTwo[1];
	}
}
