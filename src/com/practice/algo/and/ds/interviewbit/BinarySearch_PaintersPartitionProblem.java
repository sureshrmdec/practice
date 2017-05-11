package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch_PaintersPartitionProblem {

	public static void main(String[] args) {
		BinarySearch_PaintersPartitionProblem  p = new BinarySearch_PaintersPartitionProblem ();
		int a= 2;
		int b= 1;
		Integer[] c = {1,2,3,4};
		ArrayList<Integer> cc = new ArrayList<>(Arrays.asList(c));
		System.out.println(p.paint(a, b, cc));

	}
	public int paint(int a, int b, ArrayList<Integer> c) {
		int l = 1;
		int h = 0;
		for(int i=0;i<c.size();i++){
			h+=c.get(i);
		}
		BigInteger result=BigInteger.ZERO;
		while(l<=h){
			int mid = (l+h)/2;
			
			if(isPossible(mid,a,b,c)){
				h = mid-1;
				result = BigInteger.valueOf(mid);
			}else{
				l=mid+1;
			}
			
		}
		result = result.multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(10000003));
		return (result.intValue());
		
	}
	boolean isPossible(int t,int a, int b, ArrayList<Integer> c){
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
