package com.practice.algo.and.ds.interviewbit;
//http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
public class SubSetSumProblem {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] set = {3,6,7,8};
		int k = 11;
		SubSetSumProblem s = new SubSetSumProblem();
		System.out.println(s.isSumPossible(set,k));
	}

	private boolean isSumPossible(int[] set, int k) {

		boolean[][] dp = new boolean[k+1][set.length+1];
		for(int i =0;i<dp[0].length;i++){
			dp[0][i]= true;
		}
		for(int i =1;i<dp.length;i++){
			dp[i][0]= false;
		}

		for(int i =1;i<dp.length;i++){
			for(int j =1;j<dp[0].length;j++){
				dp[i][j] = dp[i][j-1];
				if(i >= set[j-1]){
					dp[i][j] = dp[i][j] || dp[i-set[j-1]][j-1];
				}
			}	
		}
		return dp[k][dp[0].length-1];
	}

}
