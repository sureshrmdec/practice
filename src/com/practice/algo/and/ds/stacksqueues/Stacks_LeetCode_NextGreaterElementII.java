package com.practice.algo.and.ds.stacksqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Stacks_LeetCode_NextGreaterElementII {

	public static void main(String[] args) {
		//int[] nums = {1,2,1};
		int[] nums = {4,3,5,2,6,1,7,9,3,2,1};
		Stacks_LeetCode_NextGreaterElementII o = new Stacks_LeetCode_NextGreaterElementII();
		o.nextGreaterElements(nums);

	}
	
	//https://discuss.leetcode.com/topic/77923/java-10-lines-and-c-12-lines-linear-time-complexity-o-n-with-explanation
	public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n]; 
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) 
            	stack.push(i);
        }   
        return next;
    }
	
	
	
	//Accepted too 
	public int[] nextGreaterElementsMine(int[] nums) {
		List<Integer> searchList = new ArrayList<>();
		searchList.add(nums[0]);
		int currentLargest = nums[0];
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(nums[i]>currentLargest){
				currentLargest = nums[i];
				searchList.add(nums[i]);
			}
			while(!stack.isEmpty() && nums[i]>nums[stack.peek()]){
				map.put(stack.peek(), nums[i]);
				stack.pop();
			}
			stack.push(i);

		}
		int[] result = new int[nums.length];
		Arrays.fill(result, -1);

		for(int i=0;i<nums.length;i++){
			if(map.containsKey(i))
				result[i] = map.get(i);
		}

		while(!stack.isEmpty()){
			int top = stack.pop();

			result[top] = getGreater(searchList,nums,top);
		}


		return result;





	}
	private int getGreater(List<Integer> searchList,int[] nums,int topIndex) {
		int greater = -1;
		int l = 0;
		int h = searchList.size()-1;
		while(l<=h){
			int mid = (l+h)/2;
			int possibleGreater = searchList.get(mid);
			if(possibleGreater>nums[topIndex]){
				greater = possibleGreater;
				h = mid-1;
			}else{
				l = mid+1;
			}
		}
		return greater;
	}
}
