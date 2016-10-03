package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_Majority_Element_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {3,2,3};
		LeetCode_Majority_Element_II o = new LeetCode_Majority_Element_II();
		System.out.println(o.majorityElement(nums));
	}
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>(2);
		Map<Integer,Integer> map = new HashMap();
		for(Integer i : nums){
			if(map.containsKey(i)){
				map.put(i, map.get(i)+1);
			}else{
				if(map.size()==2){
					List<Integer> toRemoveZero = new ArrayList<>();
					for(Integer ii: map.keySet()){
						map.put(ii, map.get(ii)-1);
						if(map.get(ii)==0){
							toRemoveZero.add(ii);
						}
					}
					for(Integer rem : toRemoveZero)
						map.remove(rem);
					
				}else{
					map.put(i, 1);
				}
			}
		}
		for(Integer ii: map.keySet()){
			// now check if any of the elements in the Elements array appears
			// more than n/k times
			
				int cnt = 0;
				for (int j = 0; j < nums.length; j++) {
					if (nums[j] == ii) {
						cnt++;
					}
				}
				if (cnt > (nums.length / 3)) {
					//System.out.println(emts[i].number + " appears more than n/" + 3 + " times, Actual count is " + cnt);
					res.add(ii);
					
				}
			
		}
	return res;
	}

}
