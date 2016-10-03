package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP_MaxProductSubArray {

	public static void main(String[] args) {

		DP_MaxProductSubArray o = new DP_MaxProductSubArray();
		Integer[] a = {2,0,-3,3,3};
		Integer[] a2 = {2, 3,-2,4,-5};
		
		//System.out.println(o.getMaxProduct(a));
		//ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(a));
		System.out.println(o.maxProduct(a));
	}

	public int maxProduct(Integer[] nums) {
	    int[] max = new int[nums.length];
	    int[] min = new int[nums.length];
	 
	    max[0] = min[0] = nums[0];
	    int result = nums[0];
	 
	    for(int i=1; i<nums.length; i++){
	        if(nums[i]>0){
	            max[i]=Math.max(nums[i], max[i-1]*nums[i]);
	            min[i]=Math.min(nums[i], min[i-1]*nums[i]);
	        }else{
	            max[i]=Math.max(nums[i], min[i-1]*nums[i]);
	            min[i]=Math.min(nums[i], max[i-1]*nums[i]);
	        }
	 
	        result = Math.max(result, max[i]);
	    }
	 
	    return result;
	}
	
	public int maxProduct(final List<Integer> nums) {
	    int[] max = new int[nums.size()];
	    int[] min = new int[nums.size()];
	 
	    max[0] = min[0] = nums.get(0);
	    int result = nums.get(0);
	 
	    for(int i=1; i<nums.size(); i++){
	        if(nums.get(i)>0){
	            max[i]=Math.max(nums.get(i), max[i-1]*nums.get(i));
	            min[i]=Math.min(nums.get(i), min[i-1]*nums.get(i));
	        }else{
	            max[i]=Math.max(nums.get(i), min[i-1]*nums.get(i));
	            min[i]=Math.min(nums.get(i), max[i-1]*nums.get(i));
	        }
	 
	        result = Math.max(result, max[i]);
	    }
	 
	    return result;
	}

}
