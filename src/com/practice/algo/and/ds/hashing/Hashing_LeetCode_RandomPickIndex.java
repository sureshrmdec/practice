package com.practice.algo.and.ds.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Given an array of integers with possible duplicates, randomly output the index of a given target number. 
You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
*/
public class Hashing_LeetCode_RandomPickIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Map<Integer,List<Integer>> map = new HashMap<>();
	public Hashing_LeetCode_RandomPickIndex(int[] nums) {

		for(int i=0;i<nums.length;i++){
			int num = nums[i];
			if(!map.containsKey(num))
				map.put(num, new ArrayList<>());
			map.get(num).add(i);

		}
	} 
	public int pick(int target) {
		List<Integer> indexes = this.map.get(target);
		int i = (int) (Math.random() * indexes.size()); //Math.random generates number greater than 0.0 and less than 1.0..so when multiply with size of the list, it gives
														// value between the 0 and list.size()-1 with equal probability.
		return indexes.get(i);	    
	}
}
