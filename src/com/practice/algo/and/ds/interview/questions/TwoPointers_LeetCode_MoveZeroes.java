package com.practice.algo.and.ds.interview.questions;

public class TwoPointers_LeetCode_MoveZeroes {

	public static void main(String[] args) {
		int[] nums = {11,1,0,1,1};
		TwoPointers_LeetCode_MoveZeroes o = new TwoPointers_LeetCode_MoveZeroes();
		System.out.println(o.moveZeroes(nums));

	}
	
    public int[] moveZeroes(int[] nums) {
    	int back = -1;
    	int front = 0;
        for(int n:nums){
        	if(n!=0){
        		back = back + 1;
        		swap(back,front,nums);
        	}
        	front++;
        }
        return nums;
    }

	private void swap(int back, int front, int[] nums) {
		int i = nums[back];
		nums[back] = nums[front];
		nums[front] = i;
		
	}

}
