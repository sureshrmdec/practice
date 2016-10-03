package com.practice.algo.and.ds.dp;

import java.math.BigInteger;
import java.util.Scanner;

public class HackerRank_StockMaximize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] array;
		for(int i =0;i<t;i++){
			int s = sc.nextInt();
			array = new int[s];
			for(int j=0;j<s;j++){
				array[j] = sc.nextInt();
			}
			maxProfit(array);
		}
		
	}

	private static void maxProfit(int[] array) {
		
		 int max_current_future_price = 0;
	     BigInteger profit = BigInteger.ZERO;
	        for (int i=array.length-1; i>=0; --i) {
	            max_current_future_price = Math.max(max_current_future_price, array[i]);
	            profit = profit.add(BigInteger.valueOf(max_current_future_price).subtract(BigInteger.valueOf(array[i])));
	        }
	 System.out.println(profit);	

		
	}

}
