package com.practice.algo.and.ds.stacksqueues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Stacks_LeetCode_NextGreaterElementI {

	public static void main(String[] args) {
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		Stacks_LeetCode_NextGreaterElementI o = new Stacks_LeetCode_NextGreaterElementI();
		o.nextGreaterElement(nums1, nums2);

	}
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
       	 while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
       		 map.put(nums[stack.pop()], nums[i]);
       	 }
       	 stack.push(i);
        }
        int[] result = new int[findNums.length];
        Arrays.fill(result, -1);
        for(int i=0;i<findNums.length;i++){
       	 if(map.containsKey(findNums[i]))
       		 result[i] = map.get(findNums[i]);
        }
        return result;
       }
}
