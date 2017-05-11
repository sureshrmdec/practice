package com.practice.algo.and.ds.hashing;

import java.util.HashMap;

//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

public class Hashing_LeetCode_ContiguousArray {

	public static void main(String[] args) {
		int[] nums = {0,1,1,1,0,0,1,0,1,1,0,0,1};
		Hashing_LeetCode_ContiguousArray o = new Hashing_LeetCode_ContiguousArray();
		System.out.println(o.findMaxLength(nums));

	}

	public int findMaxLength(int[] nums) {

		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		int result = 0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0){
				sum-=1;
			}else
				sum+=1;
			if(!map.containsKey(sum)){
				map.put(sum, i);
			}else{
				int storedIndex = map.get(sum);
				result = Math.max(result, i-(storedIndex+1)+1);
			}
			
		}
		return result;
	}
}
