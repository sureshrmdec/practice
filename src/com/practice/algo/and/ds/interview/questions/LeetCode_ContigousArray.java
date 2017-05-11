package com.practice.algo.and.ds.interview.questions;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/contest/leetcode-weekly-contest-20/problems/contiguous-array/
public class LeetCode_ContigousArray {

	public static void main(String[] args) {
		LeetCode_ContigousArray o = new LeetCode_ContigousArray();
		int[] nums = {1,0,1,1,1,1,0,0,1,1,1,0,0,1,0,1,1};
		System.out.println(o.findMaxLength2(nums));

	}
	public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        
        int zero=0;
        int one=0;
        int len=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }else{
                one++;
            }
            
            if(map.containsKey(zero-one)){
                len=Math.max(len,i-map.get(zero-one));
            }else{
                map.put(zero-one,i);
            }
        }
        
        return len;
    }
	//https://discuss.leetcode.com/topic/79906/easy-java-o-n-solution-presum-hashmap
	public int findMaxLength2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            }
            else {
                sumToIndex.put(sum, i);
            }
        }
        
        return max;
    }
}
