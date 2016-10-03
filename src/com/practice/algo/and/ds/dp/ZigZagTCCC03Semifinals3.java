package com.practice.algo.and.ds.dp;

import java.util.Arrays;

public class ZigZagTCCC03Semifinals3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] sequence =  	{396, 549, 22, 819, 611, 972, 730, 638, 978, 342, 566, 514, 752, 871, 911, 172, 488, 542, 482, 974, 210, 474, 66, 387, 1, 872, 799, 262, 567, 113, 578, 308, 813, 515, 716, 905, 434, 101, 632, 450, 74, 254, 1000, 780, 633, 496, 513, 772, 925, 746};
		ZigZagTCCC03Semifinals3 z = new ZigZagTCCC03Semifinals3();
		System.out.println(z.findMaxZigZagSequence(sequence));
	}

	private int findMaxZigZagSequence(int[] sequence) {
		// TODO Auto-generated method stub
		
		int[] diffArray = new int[sequence.length-1];
		int[] dp = new int[sequence.length-1];
		Arrays.fill(dp,1);
		
		for(int i=1;i<sequence.length;i++){
			diffArray[i-1] = sequence[i] - sequence[i-1];
		}
		
		
		for(int i=1;i<diffArray.length;i++){
			boolean isIPositive = (diffArray[i]>0)?true:false;
			for(int j=0;j<i;j++){
				boolean isJPositive = (diffArray[j]>0)?true:false;
				if(isIPositive && !isJPositive){
					
						dp[i] = 1 + dp[j];
					
				}else if(!isIPositive && isJPositive){
					
						dp[i] = 1 + dp[j];
					
				}
			}
		}
		return dp[dp.length-1];
	}

}
