package com.practice.algo.and.ds.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class BackTracking_SubsetsIIRevisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		ArrayList<Integer> numsL = new ArrayList<>();
		//numsL.add(1);
		//numsL.add(2);
		//numsL.add(2);
		//numsL.add(3);
		//numsL.add(3);
		numsL.add(1);
		numsL.add(2);
		numsL.add(2);
		numsL.add(3);

		BackTracking_SubsetsIIRevisited o = new BackTracking_SubsetsIIRevisited();

		System.out.println(o.subsetsWithDup(numsL));
		System.out.println(o.subsetsWithDup(numsL).size());
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Collections.sort(nums);
		getSubSets(nums, 0,new ArrayList<Integer>(),result);
		return result;
	}

	private void getSubSets(ArrayList<Integer> nums, int start, ArrayList<Integer> tmpList,ArrayList<ArrayList<Integer>> result) {
		result.add(new ArrayList<>(tmpList));
		for(int i=start;i<nums.size();i++){
			if(i>start && nums.get(i).equals(nums.get(i-1)))
				continue;
			tmpList.add(nums.get(i));
			getSubSets(nums, i+1, tmpList, result);
			tmpList.remove(tmpList.size()-1);
		}
	}

	

}
