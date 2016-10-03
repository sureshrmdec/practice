package com.practice.algo.and.ds.dp;

import java.util.Arrays;
import java.util.Scanner;

public class HackerRank_LIS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[]  a = new int[N];
		for(int i =0;i<N;i++){
			a[i] = sc.nextInt();
		}
		int[] dp = new int[N];
		
		Arrays.fill(dp, 1);
		dp[0] = 1;
		int res = Integer.MIN_VALUE;
		for(int i =1;i<N;i++){
			for(int j =0;j<i;j++){
				if(a[i] > a[j] && (dp[i]<dp[j]+1)){
					dp[i] = dp[j]+1;
					res = Math.max(res, dp[i]);
				}
			}	
		}
		System.out.println(res);
	}

}
