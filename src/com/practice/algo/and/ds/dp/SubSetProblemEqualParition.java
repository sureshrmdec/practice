package com.practice.algo.and.ds.dp;
//http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
public class SubSetProblemEqualParition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3, 1, 1, 2, 2, 1};
		inPartitionPossible(A);
	}

	private static boolean inPartitionPossible(int[] a) {
		int sum = 0;
		for(Integer i:a){
			sum+=i;
		}
		if(sum%2!=0){
			return false;
		}else{
			sum = sum/2;
		}
		boolean[][] dp = new boolean[sum+1][a.length+1];
		
				
		for(int i=0;i<dp[0].length;i++){
			dp[0][i] = true;
		}
		for(int i=1;i<dp.length;i++){
			dp[i][0] = false;
		}
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				dp[i][j] = dp[i][j-1] ;
				if(i<a[j-1]){
					continue;
				}
				dp[i][j] = dp[i][j] || dp[i-a[j-1]][j-1];
			}	
		}
		return dp[sum][dp[0].length-1];
	}

}
