package com.practice.algo.and.ds.backtracking;

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
		numsL.add(3);
		BackTracking_Set o = new BackTracking_Set();

		System.out.println(o.subsets(numsL));
	}


    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> nums) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    	Collections.sort(nums);
    	subsetsHelper(nums,result,0, new ArrayList<>());
    	return result;
    }
	private void subsetsHelper(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result, int start, ArrayList<Integer> tempList) {
		result.add(new ArrayList<>(tempList));
		for(int i=start;i<nums.size();i++){
			tempList.add(nums.get(i));
			subsetsHelper(nums,result,i+1,tempList);
			tempList.remove(tempList.size()-1);
		}
		
	}

}
