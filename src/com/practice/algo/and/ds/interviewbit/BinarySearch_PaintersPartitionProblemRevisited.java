package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch_PaintersPartitionProblemRevisited {

	public static void main(String[] args) {
		BinarySearch_PaintersPartitionProblemRevisited  p = new BinarySearch_PaintersPartitionProblemRevisited ();
		int a= 2;
		int b= 5;
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
		return result.intValue();
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
	
	// Not to be used...i tried
	private boolean isPossible(int mid, int a, ArrayList<Integer> c) {
		// TODO Auto-generated method stub
		ArrayList<Integer> cc = new ArrayList<>();
		cc.addAll(c);
		int t = mid;
		while(t>0){
			for(int l=0;l<cc.size();l++){
				if(cc.get(l)==0 && mid-t==c.get(l))
					a = a+1;
			}
			for(int i=0;i<cc.size();i++){
				if((cc.get(i)!=0 )){
					if(a>0 && c.get(i)==cc.get(i)){
						cc.set(i,cc.get(i)-1);
						a--;
					}else if(c.get(i)>cc.get(i)){
						cc.set(i,cc.get(i)-1);	
					}
				}

			
			}
			t--;
			
		}
		return false;
	}

}
