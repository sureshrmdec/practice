package com.practice.algo.and.ds.interview.questions;

public class LeetCode_Maximum_Subarray {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		LeetCode_Maximum_Subarray o = new LeetCode_Maximum_Subarray();
		o.maxSubArray(nums);

	}
	public int maxSubArray(int[] nums) {
        int last = 0;
        int sum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            last+=nums[i];
            sum = Math.max(sum,last);
            if(last<0)
                last=0;
        }
        return sum;
    }
}
