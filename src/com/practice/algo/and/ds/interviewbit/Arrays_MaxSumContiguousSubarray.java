package com.practice.algo.and.ds.interviewbit;

import java.util.Arrays;
import java.util.List;

/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:

Given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

For this problem, return the maximum sum.*/
		
public class Arrays_MaxSumContiguousSubarray {

	public static void main(String[] args) {
		
		
		Arrays_MaxSumContiguousSubarray s = new Arrays_MaxSumContiguousSubarray();
		Integer aa[] = {-1,-2};
		//Integer aa[] ={-2,1,-3,4,-1,2,1,-5,4};
		//0111000100010 
		List<Integer> a = Arrays.asList(aa);
		System.out.println(s.maxSubArray(a));
		System.out.println(s.maxSubArray2(a));
		System.out.println(s.maxSubArrayKadane(a));
		System.out.println(s.maxSubArrayKadaneIndexes(a));
	}
	public int maxSubArray(final List<Integer> a) {
		int currMaxSum = a.get(0);
		int currSum = currMaxSum;
		for(int i=1;i<a.size();i++){
			int e = a.get(i);
			currSum = Math.max(e, e+currSum);
			currMaxSum = Math.max(currMaxSum, currSum);
		}
		return currMaxSum;
	}
	
	//Kadane's Algorithm
	//Awesome Soln copied from InterviewBit.
	// The point is any sub array having sum as negative can be ingnored. For eg In this case -2,1,-3,4 when pointer moves at 4 i.e. index 3rd 
	// we can ignore the sum as it being negative so last = 0, that means start a new sum or new beginning.
	public int maxSubArray2(final List<Integer> A) {
	    
	    int sum = Integer.MIN_VALUE;
	    int last = 0;
	    
	    for (int num : A) {
	        
	        last += num;
	        sum = Math.max(sum, last);
            if (last < 0)
	            last = 0;
	    }
	    
	    return sum;
	    
	}
	//Kadane's Algorithm (Same as above)
	public int maxSubArrayKadane(final List<Integer> A) {

	    int maxSoFar = 0;
	    int maxEndingHere = 0;

	    for (int num : A) {
	    	maxEndingHere += num;
	    	maxSoFar = Math.max(maxSoFar, maxEndingHere);
            if (maxEndingHere < 0)
            	maxEndingHere = 0;
	    }
	    
	    return maxSoFar;
	    
	}
	
	//Kadane's Algorithm (Same as above)
	//records indexes also
	public int maxSubArrayKadaneIndexes(final List<Integer> A) {
	    Integer[] a = new Integer[A.size()];
	    A.toArray(a);
	   // int maxSoFar = 0;
	   // int maxEndingHere = 0;
	    
	    int max_so_far = 0;
	    int max_ending_here = 0;
	    int max_start_index = 0;
	    int startIndex = 0;
	    int max_end_index = -1;

	    for(int i = 0; i < a.length; i++) {
	      if(max_ending_here +a[i] < 0) {
	        startIndex = i+1;
	        max_ending_here = 0;
	      }
	      else {
	        max_ending_here += a[i];
	      }

	      if(max_ending_here > max_so_far) {
	        max_so_far = max_ending_here;
	        max_start_index = startIndex;
	        max_end_index = i;
	      }
	    }
	    
	    return max_so_far;
	    
	}
}

//Kadane's Algorithm
//Awesome Soln copied from InterviewBit.
/*public class Solution {
	// DO NOT MODFIY THE LIST. 
	public int maxSubArray(final List<Integer> A) {
	    
	    int sum = Integer.MIN_VALUE;
	    int last = 0;
	    
	    for (int num : A) {
	        
	        last += num;
	        sum = Math.max(sum, last);
            if (last < 0)
	            last = 0;
	    }
	    
	    return sum;
	    
	}
}
*/