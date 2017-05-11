package com.practice.algo.and.ds.dp;

import java.util.ArrayList;
import java.util.List;

public class DP_UniqueBinarySearchTreesII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DP_UniqueBinarySearchTreesII i = new DP_UniqueBinarySearchTreesII();
		System.out.println(i.numTrees(1));
		System.out.println(i.numTrees(2));
		System.out.println(i.numTrees(3));

	}
	public int numTrees(int n) {
		if(n==0){
			return 0;
		}
		int[] dp = new int[n+1];
		dp[0]=1;
		dp[1] = 1;
		
		for(int i=2;i<=n;i++){
			int result = 0;
			for(int j=1;j<=i;j++){
				result+=dp[j-1]*dp[i-j];
			}
			//result+=dp[i-1];
			dp[i] = result;
		}
		

		return dp[n];
	}


}
