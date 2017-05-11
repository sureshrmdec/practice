package com.practice.algo.and.ds.hashing;

import java.util.HashMap;
import java.util.Map;

public class Hashing_LeetCode_MaximumSizeSubarraySumEqualsK {

	public static void main(String[] args) {
		int[] nums = {1,1,0};
		int k = 1;
		Hashing_LeetCode_MaximumSizeSubarraySumEqualsK o = new Hashing_LeetCode_MaximumSizeSubarraySumEqualsK();
		System.out.println(o.maxSubArrayLen(nums, k));
	}
    public int maxSubArrayLen(int[] nums, int k) {
     
    	Map<Integer,Integer> map = new HashMap<>();
    	int sum = 0;
    	int result = 0;
    	map.put(0, -1);
    	for(int i=0;i<nums.length;i++){
    		sum+=nums[i];
    		if(map.containsKey(sum-k)){
    			int storedIndex  = map.get(sum-k);
    			result = Math.max(result, i- (storedIndex + 1) +1);
    		}	
    		if(!map.containsKey(sum)){
    			map.put(sum, i);
    		}
    	}
    	return result;
    }
}
