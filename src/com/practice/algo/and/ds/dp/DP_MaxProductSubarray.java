package com.practice.algo.and.ds.dp;

import java.util.Arrays;
import java.util.List;

public class DP_MaxProductSubarray {

	public static void main(String[] args) {
		//Integer[] numsA = {0, 0, 2, 0, 0};
		//Integer[] numsA = {2,3,-2,4};
		//Integer[] numsA = {-4, 0, -5, 0};
		//Integer[] numsA = {0, -2, -3, -3, 0};
		Integer[] numsA = {2,-3,-3,0,5,2,-8};
		List<Integer> nums = Arrays.asList(numsA);
		DP_MaxProductSubarray  o = new DP_MaxProductSubarray();
		System.out.println(o.maxProduct(nums));

	}
	
/*	You have three choices to make at any position in array.
	1. You can get maximum product by multiplying the current element with 
	    maximum product calculated so far.  (might work when current 
	    element is positive).
	2. You can get maximum product by multiplying the current element with 
	    minimum product calculated so far. (might work when current 
	    element is negative).
	3.  Current element might be a starting position for maximum product sub
	     array


	https://www.quora.com/How-do-I-solve-maximum-product-subarray-problems
*/
	public int maxProduct(final List<Integer> nums) {
		
		int currentmax = nums.get(0);
		int previousPositive = nums.get(0);
		int previousNegative = nums.get(0);
		
		for(int i=1;i<nums.size();i++){
			int currNum = nums.get(i);
			int currentPositive = Math.max(previousPositive*currNum, Math.max(currNum,previousNegative*currNum));
			int currentNegative = Math.min(previousPositive*currNum, Math.min(currNum,previousNegative*currNum));
			currentmax = Math.max(currentmax, currentPositive);
			previousNegative = currentNegative;
			previousPositive = currentPositive;
			
		}
		return currentmax;
		
	}
}
