package com.practice.algo.and.ds.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class Hashing_LeetCode_ContinousDuplicateII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++){
			if(i > k) 
				set.remove(nums[i-k-1]); //remove element if its distance to nums[i] is not lesser than k
			if(!set.add(nums[i]))  
				return true;   //because all still existed elements is closer than k distance to the num[i], 
		}					   //therefore if the add() return false, it means there's a same value element already existed within the 
		return false;		   //distance k, therefore return true.
	}
}
