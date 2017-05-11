package com.practice.algo.and.ds.arrays;

public class LeetCode_ProductAllExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4};
		productExceptSelf(nums);
		for(int i:nums){
			System.out.println(i+" ");
		}
	}
	public static int[] productExceptSelf(int[] nums) {
        int[] front = new int[nums.length];
        front[0] = nums[0];

        
		for(int i=1;i<nums.length;i++){
        	front[i] = nums[i]*front[i-1]; 
        }
		int[] back = new int[nums.length];
		back[nums.length-1] = nums[nums.length-1];
		for(int i=nums.length-2;i>=0;i--){
        	back[i] = nums[i]*back[i+1]; 
        }
		for(int i=0;i<nums.length;i++){
			if(i==0){
				nums[i] = back[i+1];
				continue;
			}else if(i==nums.length-1){
				nums[i] = front[i-1];
				continue;
			}else{
				nums[i] = front[i-1]*back[i+1];	
			}
		}
		return nums;
    }
	//https://discuss.leetcode.com/topic/22301/my-solution-beats-100-java-solutions
	public int[] productExceptSelfLeet(int[] nums) {
	    int leng = nums.length;
	    int[] ret = new int[leng];
	    if(leng == 0)
	        return ret;
	    int runningprefix = 1;
	    for(int i = 0; i < leng; i++){
	        ret[i] = runningprefix;
	        runningprefix*= nums[i];
	    }
	    int runningsufix = 1;
	    for(int i = leng -1; i >= 0; i--){
	        ret[i] *= runningsufix;
	        runningsufix *= nums[i];
	    }
	    return ret;
	    
	}

}
