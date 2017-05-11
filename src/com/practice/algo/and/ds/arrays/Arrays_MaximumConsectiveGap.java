package com.practice.algo.and.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Bucket Sort
public class Arrays_MaximumConsectiveGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[] aa = {50,60,70,80,90,100};
		//Integer[] aa = {1,9,7,20,6,21};
		Integer[] aa = {1,3,10};
		List<Integer> in = new ArrayList<>(Arrays.asList(aa));
		Arrays_MaximumConsectiveGap g = new Arrays_MaximumConsectiveGap();
		System.out.println(g.maximumGapLeet(aa));
		System.out.println(g.maximumGap(aa));
		
		

	}
	class Bucket{
	    int low;
	    int high;
	    public Bucket(){
	        low = -1;
	        high = -1; 
	    }
	}
	 
	public int maximumGapLeet(Integer[] nums) {
	    int n = nums.length;
	    if(n < 2) return 0;
	    int min = nums[0];
	    int max = nums[0];
	    for(int i = 1;i < n;i++){
	        if(min > nums[i]) min = nums[i];
	        if(max < nums[i]) max = nums[i];
	    }
	    
	    int gap = (max-min)/(n-1);
	    if(gap == 0) gap++;
	    int len = (max-min)/gap+1;
	    int [] tmax = new int [len];
	    int [] tmin = new int [len];
	    
	    for(int i = 0;i < n;i++){
	        int index = (nums[i]-min)/gap;
	        if(nums[i] > tmax[index]) 
	        	tmax[index] = nums[i];
	        if(tmin[index] == 0 || nums[i] < tmin[index]) 
	        	tmin[index] = nums[i];
	    }
	    int myMax = 0;
	    for(int i = 0;i < len;i++){
	        if(myMax < tmin[i]-min) 
	        	myMax = tmin[i]-min;
	        if(tmax[i] != 0) 
	        	min = tmax[i];
	    }
	    return myMax;
	}
	
	public int maximumGap(Integer[] num) {
	    if(num == null || num.length < 2){
	        return 0;
	    }
	 
	    int max = num[0];
	    int min = num[0];
	    for(int i=1; i<num.length; i++){
	        max = Math.max(max, num[i]);
	        min = Math.min(min, num[i]);
	    }
	 
	    // initialize an array of buckets
	    Bucket[] buckets = new Bucket[num.length+1]; //project to (0 - n)
	    for(int i=0; i<buckets.length; i++){
	        buckets[i] = new Bucket();
	    }
	 
	    double interval = (double) num.length / (max - min);
	   // System.out.println(interval);
	    //distribute every number to a bucket array
	    for(int i=0; i<num.length; i++){
	    	double d = (num[i] - min) * interval;
	  //  	System.out.println(d);
	        int index = (int) ((num[i] - min) * interval);
	  //      System.out.println(index);
	        if(buckets[index].low == -1){
	            buckets[index].low = num[i];
	            buckets[index].high = num[i];
	        }else{
	            buckets[index].low = Math.min(buckets[index].low, num[i]);
	            buckets[index].high = Math.max(buckets[index].high, num[i]);
	        }
	    }
	 
	    //scan buckets to find maximum gap
	    int result = 0;
	    int prev = buckets[0].high;
	    for(int i=1; i<buckets.length; i++){
	        if(buckets[i].low != -1){
	            result = Math.max(result, buckets[i].low-prev);
	            prev = buckets[i].high;
	        }
	 
	    }
	 
	    return result;
	}
}
