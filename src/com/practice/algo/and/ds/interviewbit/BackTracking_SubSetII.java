package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.practice.algo.and.ds.backtracking.BackTracking_LeetCode_SubsetsII;

/*1 2 2 3 3

3
3 3
--------
2
2 3
2 3 3
3
3 3
--------
2
2 2
2 2 3
2 2 3 3
2 3
2 3 3
3
3 3
 */
public class BackTracking_SubSetII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2,3,3};
		ArrayList<Integer> numsL = new ArrayList<>();
		//numsL.add(1);
		//numsL.add(2);
		//numsL.add(2);
		//numsL.add(3);
		//numsL.add(3);
		numsL.add(5);
		numsL.add(5);
		numsL.add(5);
		numsL.add(5);

		BackTracking_LeetCode_SubsetsII o = new BackTracking_LeetCode_SubsetsII();

		System.out.println(o.subsetsWithDup(nums));

	}
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
		list.add(new ArrayList<>(tempList));
		for(int i = start; i < nums.length; i++){
			if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}
