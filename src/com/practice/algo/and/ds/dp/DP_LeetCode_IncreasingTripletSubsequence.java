package com.practice.algo.and.ds.dp;

public class DP_LeetCode_IncreasingTripletSubsequence {

	public static void main(String[] args) {
		DP_LeetCode_IncreasingTripletSubsequence o = new DP_LeetCode_IncreasingTripletSubsequence();
		//int[] nums = {3,4,2,1,5};
		int[] nums = {3,4,2,1,5};
		o.increasingTriplet(nums);

	}
	
/*	Starting from left to right, the numbers could lie in range [-----] for any small<big<thirdvalue
	-----small< -----big< -----thirdvalue

	a) if currentelement is less than small : update small to currentelement now the range for big can expand between new small and big
	b) if currentelement is between small and bigand less than current big : update big to currentelement now the range for thirdvalue can be any number greater than big
	c) if currentelement is greater than big: we found 3 such values return true*/
	
	public boolean increasingTriplet(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }
}
