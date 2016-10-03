package com.practice.algo.and.ds.interview.questions;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_FirstMissingInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode_FirstMissingInteger o = new LeetCode_FirstMissingInteger();
		int[] nums = {-8, -7, -6};
		System.out.println(o.firstMissingPositive(nums));
	}
	public int firstMissingPositive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<nums.length;i++){
			if(nums[i]>0){
				set.add(nums[i]);
			}
		}
		int i=1;
		while(true){
			if(!set.contains(i)){
				break;
			}
			i++;
		}
		return i;
		
	}
}
