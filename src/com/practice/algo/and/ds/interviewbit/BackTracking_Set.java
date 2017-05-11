package com.practice.algo.and.ds.interviewbit;


//https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/2
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackTracking_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		ArrayList<Integer> numsL = new ArrayList<>();
		numsL.add(1);
		numsL.add(2);
		numsL.add(3);
		//numsL.add(3);
		BackTracking_Set o = new BackTracking_Set();

		System.out.println(o.subsets(numsL));
	}

    public List<List<Integer>> subsets(ArrayList<Integer> nums) {
    	List<List<Integer>> result = new ArrayList<>();
    	Collections.sort(nums);
    	subsetsHelper(nums,result,0, new ArrayList<>());
    	return result;
    }
	private void subsetsHelper(ArrayList<Integer> nums, List<List<Integer>> result, int start, ArrayList<Integer> tempList) {
		result.add(new ArrayList<>(tempList));
		for(int i=start;i<nums.size();i++){
			tempList.add(nums.get(i));
			subsetsHelper(nums,result,i+1,tempList);
			tempList.remove(tempList.size()-1);
		}
		
	}

}
