package com.practice.algo.and.ds.twopointers;

public class TwoPointers_LeetCode_MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int[] nums = {7,7,2,3,1,2,4,3};
		int s = 6;
		TwoPointers_LeetCode_MinimumSizeSubarraySum o = new TwoPointers_LeetCode_MinimumSizeSubarraySum();
		System.out.println(o.minSubArrayLen(s, nums));
	}
	  public int minSubArrayLen(int s, int[] nums) {
	        if(nums.length==0)
	            return 0;
	      int left = 0;
	      int sum = nums[0];
	      int minLength = nums[0]>=s?1:0;
	      for(int i=1;i<nums.length;i++){
	    	  sum+=nums[i];
	    	  if(sum>=s){
	    		  while(sum>=s){
	    			  if(minLength==0)
	    				  minLength = i-left+1;
	    			  else
	    				  minLength = Math.min(minLength, i-left+1);
	    			  sum-=nums[left];
	    			  left++;
	    		  }
	    	  }
	      }
		  return minLength;
	    }
}
