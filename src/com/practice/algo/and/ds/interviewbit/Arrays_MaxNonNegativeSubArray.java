package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Arrays_MaxNonNegativeSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {756898537, -1973594324, -2038664370, -184803526, 1424268980};
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(a));
		Arrays_MaxNonNegativeSubArray o = new Arrays_MaxNonNegativeSubArray();
		System.out.println(o.maxset(A));
	}

	public ArrayList<Integer> maxset(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<>();
		
		int startIndex = 0;
		int endIndex = -1;
		int rstartIndex = startIndex;
		int rendIndex = endIndex;
		
		BigInteger maxSum = BigInteger.valueOf(-1);
		BigInteger sum = BigInteger.ZERO;
		for(int i=0;i<A.size();i++){
			int num = A.get(i);
			if(num<0){
			    // update maxSum,rstartIndex and rendIndex. Make sum=0 and startIndex = i+1 i.e. next number. 
				endIndex = i-1;
				if(sum.compareTo(maxSum)>0){
					maxSum = sum;
					rstartIndex = startIndex;
					rendIndex = endIndex;
				}
				startIndex = i+1;
				sum=BigInteger.ZERO;
				continue;
			}
			sum = sum.add(BigInteger.valueOf(num));
		}
		// To check if last stretch is making largest sum For eg. 756898537, -1973594324, -2038664370, -184803526, 1424268980
		if(sum.compareTo(maxSum)>0){
			maxSum = sum;
			rstartIndex = startIndex;
			// See below rendIndex =  A.size()-1
			rendIndex = A.size()-1;
		}
		if(rendIndex!=-1)
		for(int i=rstartIndex;i<=rendIndex;i++){
			result.add(A.get(i));
		}
		return result;
	}
}
