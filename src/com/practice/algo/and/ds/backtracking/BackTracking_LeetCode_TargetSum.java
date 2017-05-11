package com.practice.algo.and.ds.backtracking;

public class BackTracking_LeetCode_TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackTracking_LeetCode_TargetSum o = new BackTracking_LeetCode_TargetSum();
		int[] nums = {1,1,1,1,1};
		System.out.println(o.findTargetSumWays(nums, 3));
	}

    public int findTargetSumWays(int[] nums, int S) {
        
        return findTargetSumWaysHelper(nums, S,0,0);
        
    }

	private int findTargetSumWaysHelper(int[] nums, int s,int start,int current) {
		if(start==nums.length){
			if(s==current)
				return 1;
			return 0;
		}
		int cur = nums[start];
		return findTargetSumWaysHelper(nums, s, start+1, current+cur) + findTargetSumWaysHelper(nums, s, start+1, current-cur);
	}
}
