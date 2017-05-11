package com.practice.algo.and.ds.interviewbit;

import java.util.Arrays;
import java.util.List;

public class Arrays_MaxSumContigousSubArrayRevisited {

public static void main(String[] args) {
		
		
	Arrays_MaxSumContigousSubArrayRevisited s = new Arrays_MaxSumContigousSubArrayRevisited();
		//Integer aa[] = {-1,-2};
		Integer aa[] ={-2,1,-3,4,-1,2,1,-5,4};
		//0111000100010 
		List<Integer> a = Arrays.asList(aa);
		System.out.println(s.maxSubArray(a));
		
	}
	public int maxSubArray(final List<Integer> a) {
		int maxSum = 0;
		int sum = 0;
		for(int i:a){
			
			sum+=i;
			if(sum>maxSum)
				maxSum = sum;
			
			if(sum<0){
				sum=0;
			}
			
		}
		
		
		return maxSum;
	}
	

}
