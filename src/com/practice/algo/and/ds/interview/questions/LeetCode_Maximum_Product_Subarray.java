package com.practice.algo.and.ds.interview.questions;

public class LeetCode_Maximum_Product_Subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,-2,3,-4,-3,-4,-3};
		//int[] nums = {-2,0,-1};
		System.out.println(maxProduct(nums));
	}
	public static int maxProduct(int[] nums) {
		if(nums.length==1){
			return nums[0];
		}
		int maxSoFar = 1;
		int maxEndingHere = 1;
		int minEndingHere = 1;
		for(int i=0;i<nums.length;i++){
			int num = nums[i];
			if(num<0){
				int temp = maxEndingHere;
				maxEndingHere = Math.max(num*minEndingHere, 1);
				minEndingHere = num*temp;
			}else if(num>0){
				maxEndingHere = maxEndingHere*num;
				minEndingHere = Math.min(minEndingHere * num, 1);
			}else{
				minEndingHere = 1;
				maxEndingHere = 1;
			}

			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}

}
