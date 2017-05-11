package com.practice.algo.and.ds.interview.questions;

//http://www.programcreek.com/2014/05/leetcode-missing-number-java/


//https://leetcode.com/problems/missing-number/
public class LeetCode_MissingNumber {

	public static void main(String[] args) {
		LeetCode_MissingNumber o = new LeetCode_MissingNumber();
		int[] nums = {3,2,1};
		System.out.println(o.missingNumber2(nums));

	}
	
	//Again Awesome use of XOR...when you XORed a number with itself, it becomes nullified
	public int missingNumber2(int[] nums) {
		//initialize miss as 0...check if all the numbers greater than 0 are present, then try to XOR (nullify) them with the indexes..notice i+1 to make number greater than 0. 
	    int miss=0;
	    for(int i=0; i<nums.length; i++){
	        miss ^= (i+1) ^nums[i];
	    }
	 
	    return miss;
	}
	
	// You can use this one too but above one is just awesome!!
	
    public int missingNumber(int[] nums) {
        boolean gotHighest = false;
        for(int i=0;i<nums.length;i++){
            int n  = Math.abs(nums[i]);
            if(n==Integer.MIN_VALUE){
            	int nn = nums[0];
            	nums[0] = -nn;
            }
            else
            if(n==nums.length){
                gotHighest = true;
            }else{
                int nn = nums[n];
                if(nn==0)
                	nums[n] = Integer.MIN_VALUE;
                else
                	nums[n] = -nn;
            }
        }
        if(!gotHighest){
            return nums.length;
        }else{
            for(int i=0;i<nums.length;i++){
                if(nums[i]>=0)
                    return i;
            }
        }
        return -1;
    }
    
    
    //Using Math
    public int missingNumber3(int[] nums) {
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
     
        int n=nums.length;
        return n*(n+1)/2-sum;
    }
}
