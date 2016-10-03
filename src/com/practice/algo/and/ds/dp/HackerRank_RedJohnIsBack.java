package com.practice.algo.and.ds.dp;

import java.util.Scanner;

public class HackerRank_RedJohnIsBack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++){
			int N = sc.nextInt();
			int[] dp = new int[N+1];
			dp[0] = 1;
			dp[1] = 1;
			int j;
			for(j=2;j<=N;j++){
				dp[j] = dp[j-1] + ((j-4>=0)?dp[j-4]:0);
			}
			int result=0;
			if(dp[j-1]<2){
				System.out.println("0");
			}
			else if(dp[j-1]==2){
				System.out.println("1");
			}else if(dp[j-1]>2){
				result = 1;
				for(int k=3;k<=dp[j-1];k+=2){
					if(isPrime(k)){
						result++;
					}
				}
				System.out.println(result);
			}

			
		}
	}
	static boolean isPrime(int n){
		
		for (int i = 3; i*i <= n; i += 2) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
		
	}

}
