package com.practice.algo.and.ds.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BackTracking_LeetCode_CombinationSumIV {

	public static void main(String[] args) {
		int[] nums = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
		//int[] nums = {1,2,3};
		int target = 10;
		BackTracking_LeetCode_CombinationSumIV o = new BackTracking_LeetCode_CombinationSumIV();
		System.out.println(o.combinationSum4(nums, target));

	}
    public int combinationSum4(int[] nums, int target) {
    	Arrays.sort(nums);
    	Integer[] mapA = new Integer[target+1];
    	for(int i=1;i<=target;i++){
    		int r = combinationSum4Helper(nums, i,0,mapA); //mapA is for memoization
    		mapA[i] = r;
    		
    	}
    	return mapA[target];
    	//return combinationSum4Helper(nums, target,0);
    }
	private int combinationSum4Helper(int[] nums, int target, int soFar,Integer[] mapA) {
		if(target-soFar>0 && mapA[target-soFar]!=null)
			return mapA[target-soFar];

		if(soFar>target){
			return 0;
		}
		if(soFar == target)
			return 1;
		int result = 0;
		for(int i=0;i<nums.length;i++){
			
			int r = combinationSum4Helper(nums, target,soFar+nums[i],mapA);
			result+=r;
		}
	
		return result;
	}
}
