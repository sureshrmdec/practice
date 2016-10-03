package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Bucket Sort
public class Arrays_MaximumConsectiveGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[] aa = {50,60,70,80,90,100};
		Integer[] aa = {1,9,7,20,6,21};
		List<Integer> in = new ArrayList<>(Arrays.asList(aa));
		Arrays_MaximumConsectiveGap g = new Arrays_MaximumConsectiveGap();
		g.maximumGap(aa);
		
		

	}
	class Bucket{
	    int low;
	    int high;
	    public Bucket(){
	        low = -1;
	        high = -1; 
	    }
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
	    System.out.println(interval);
	    //distribute every number to a bucket array
	    for(int i=0; i<num.length; i++){
	    	double d = (num[i] - min) * interval;
	    	System.out.println(d);
	        int index = (int) ((num[i] - min) * interval);
	        System.out.println(index);
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
