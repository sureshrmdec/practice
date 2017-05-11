package com.practice.algo.and.ds.dp;

/*Given an array of integers, find the length of longest subsequence which is first increasing then decreasing.

 **Example: **

For the given array [1 11 2 10 4 5 2 1]

Longest subsequence is [1 2 10 4 2 1]

Return value 6
 */
public class DP_LengthofLongestSubsequence {

	public static void main(String[] args) {
		DP_LengthofLongestSubsequence o = new DP_LengthofLongestSubsequence();
		int[] nums = {1, 11, 2, 10, 4, 5, 2, 1};
		o.lengthOfLongestSeq(nums);

	}
	public int lengthOfLongestSeq(int[] nums){

		int[] left = new int[nums.length];
		int[] right = new int[nums.length];


		for (int i = 0; i < nums.length; i++)
			left[i] = 1;

		for(int i = 1;i<nums.length;i++){
			for(int j= i-1;j>=0;j--){
				if(nums[i]>nums[j] && left[i] < left[j] + 1){
					left[i] = left[j]+1;
				}
			}

		}

		for (int i = 0; i < nums.length; i++)
			right[i] = 1;
		for(int i = nums.length-2;i>=0;i--){
			for(int j= i+1;j<nums.length;j++){
				if(nums[j]<nums[i] && right[i] < right[j] + 1){
					right[i] = right[j]+1;
				}
			}

		}

		int result = left[0] + right[0] - 1;
		for (int i = 1; i < nums.length; i++)
			if (left[i] + right[i] - 1 > result)
				result = left[i] + right[i] - 1;

		System.out.println(result);
		return result;
	}

}
