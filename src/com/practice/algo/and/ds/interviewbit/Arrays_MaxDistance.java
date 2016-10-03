package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Arrays_MaxDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[] aa = {5,1 ,6 ,8, 19, 3 };
		//Integer[] aa = {12,13,14,20,30,40,1,2,3,4,5,6,7,8,9,10};
		Integer[] aa = {41,5,43,4,3,46,47,48,49,50,12,13,14,20,30,40};
		ArrayList<Integer> in = new ArrayList<>(Arrays.asList(aa));
		Arrays_MaxDistance o = new Arrays_MaxDistance();
		System.out.println(o.maximumGap(in));
	}
	
	public int maximumGap(final List<Integer> A) {
	    int n = A.size();
	    int minLeft[] = new int[n];
	    int maxRight[] = new int[n];
	    
	    minLeft[0] = A.get(0);
	    for (int i = 1; i < n; i++) {
	        minLeft[i] = Math.min(minLeft[i - 1], A.get(i));
	    }
	    
	    maxRight[n - 1] = A.get(n - 1);
	    for (int i = n - 2; i >= 0; i--) {
	        maxRight[i] = Math.max(maxRight[i + 1], A.get(i));
	    }
	    
	    int i = 0, j = n - 1;
        int max = -1;
        
	    for (j = n - 1; j >= 0; j--) {
	        int num = maxRight[j];
	        i = minIndex(minLeft, num);
	        max = Math.max(j - i, max);
	    }
	    
	    
	    return max;
	}
	
	
	public int minIndex(int [] minLeft, int num) {
	    
	    int lo, hi, mid;
	    int index = -1;
	    
	    lo = 0;
	    hi = minLeft.length;
	    
	    while (lo <= hi) {
	        mid = lo + ((hi - lo) >> 1);
	        
	        int minNum = minLeft[mid];
	        
	        if (num < minNum) {
	            lo = mid + 1;
	        } else {
	            index = mid;
	            hi = mid - 1;
	        }
	    }
	    
	    return index;
	    
	}
}
