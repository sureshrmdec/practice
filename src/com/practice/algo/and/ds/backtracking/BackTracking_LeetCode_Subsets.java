package com.practice.algo.and.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/2
	
public class BackTracking_LeetCode_Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		BackTracking_LeetCode_Subsets o = new BackTracking_LeetCode_Subsets();
		System.out.println(o.subsets(nums));
	}
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
    	subsetsHelper(nums,result,0, new ArrayList<>());
    	return result;
    }
	private void subsetsHelper(int[] nums, List<List<Integer>> result, int start, ArrayList<Integer> tempList) {
		result.add(new ArrayList<>(tempList));
		for(int i=start;i<nums.length;i++){
			tempList.add(nums[i]);
			subsetsHelper(nums,result,i+1,tempList);
			tempList.remove(tempList.size()-1);
		}
		
	}
}
