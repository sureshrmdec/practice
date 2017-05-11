package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hashing_TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<Integer> twoSum(final List<Integer> nums, int target) {
	    
	    
        
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
	 
		for (int i = 1; i <= nums.size(); i++) {
			if (map.containsKey(nums.get(i-1))) {
				int index = map.get(nums.get(i-1));
				result.add(i);
				result.add(0,index);
				break;
			} else {
			    if(!map.containsKey(target - nums.get(i-1)))
				    map.put(target - nums.get(i-1), i);
			}
		}
	 
		return result;
	    
		
		}
}
