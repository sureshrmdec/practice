package com.practice.algo.and.ds.binarysearch;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch_PaintersPartitionProblem {

	public static void main(String[] args) {
		BinarySearch_PaintersPartitionProblem  p = new BinarySearch_PaintersPartitionProblem ();
		int a= 5;
		int b= 10;
		//Integer[] c = {1,2,3,4};
		Integer[] c = {658, 786, 531, 47, 169, 397, 914};
		ArrayList<Integer> cc = new ArrayList<>(Arrays.asList(c));
		System.out.println(p.paint(a, b, cc));

	}
	public int paint(int a, int b, ArrayList<Integer> c) {
		int l = Integer.MIN_VALUE;
		int h = 0;
		for(int i=0;i<c.size();i++){
			int curr = c.get(i);
			l = Math.max(l, curr);
			h+=curr;
		}
		BigInteger result=BigInteger.ZERO;
		while(l<=h){
			int mid = (l+h)/2;
			
			if(isPossible2(mid,a,c)){
				h = mid-1;
				result = BigInteger.valueOf(mid);
			}else{
				l=mid+1;
			}
			
		}
		result = result.multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(10000003));
		return (result.intValue());
		
	}
	

	boolean isPossible2(int t,int a, ArrayList<Integer> c){
		int currentSum = 0;
		int partitonsUsedSoFar = 1;
		for(int i=0;i<c.size();i++){
			currentSum+=c.get(i);
			if(currentSum>t){
				currentSum = c.get(i);
				partitonsUsedSoFar++;	
			}
			if(partitonsUsedSoFar>a){
				return false;
			}
		}
		return true;
	}

	boolean isPossible(int t,int a, ArrayList<Integer> c){
		int currentSum = 0;
		for(int i=c.size()-1;i>=0;i--){
			if(c.get(i)>t){
				return false;
			}
			currentSum+=c.get(i);
			if(currentSum>t && a>0){
				currentSum = c.get(i);
				a--;
			}
			//If no painter (a==0) and still some boards are left (i>=0)
			if(a==0 && i>=0){
				return false;
			}
		}
		
		return true;
	}
}
