package com.practice.algo.and.ds.interviewbit;

import java.util.List;

public class DP_LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DP_LongestIncreasingSubsequence o = new DP_LongestIncreasingSubsequence();
		Integer[] nums = {1};
		System.out.println(o.lengthOfLIS(nums));
	}

	public int lengthOfLIS(Integer[] nums) {
		if(nums.length==0){
			return 0;
		}
		int[] dp = new int[nums.length];
		int result = 1;

		for (int i = 0; i < nums.length; i++) {
			dp[i]=1;
		}
		for (int i = 1; i < nums.length; i++) {
			int max = dp[i];
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] <= nums[i]) {
					max = Math.max(dp[j] + 1, max);
				}
			}
			dp[i] = max;
			result = Math.max(dp[i], result);
		}
		return result;
	}
	public int lis(final List<Integer> a) {

		if(a.size()==0){
			return 0;
		}
		int[] dp = new int[a.size()];
		int result = 1;

		for (int i = 0; i < a.size(); i++) {
			dp[i]=1;
		}
		for (int i = 1; i < a.size(); i++) {
			int max = dp[i];
			for (int j = i - 1; j >= 0; j--) {
				if (a.get(j) < a.get(i)) {
					max = Math.max(dp[j] + 1, max);
				}
			}
			dp[i] = max;
			result = Math.max(dp[i], result);
		}
		return result;
	
	}
}
