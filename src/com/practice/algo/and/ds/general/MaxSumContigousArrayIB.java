package com.practice.algo.and.ds.general;

import java.math.BigInteger;
import java.util.ArrayList;

public class MaxSumContigousArrayIB {

	/**
	 * @param args
	 */
	
	/*Find out the subset of an array of continuous non negative numbers from a larger array 
	whose sum of of the elements is larger in comparison to other subset.*/
	
	/*{1, 2, 5, -7, 2, 3} .
	The two sub-arrays are {1, 2, 5} {2, 3} and the ans is {1, 2, 5} as its sum is larger than {2,3}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		MaxSumContigousArrayIB w = new MaxSumContigousArrayIB();
		int[] aa = {336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421 };
		ArrayList<Integer> A = new ArrayList<Integer>();
		for(int i=0;i<aa.length;i++){
			A.add(Integer.valueOf(aa[i]));
		}
		w.maxset(A);
	}
	BigInteger sum = BigInteger.valueOf((Integer.MIN_VALUE));
	BigInteger local =BigInteger.ZERO;
	ArrayList<Integer> opo = new ArrayList<Integer>();

	
	public ArrayList<Integer> maxset(ArrayList<Integer> A) {
		Integer[] a= A.toArray(new Integer[A.size()]);
		ArrayList<Integer> op = new ArrayList<Integer>();
		
		for(int i=0;i<a.length;i++){
			if(a[i]<0){
				if(local.compareTo(sum)>=0){
					if(local==sum && opo.size() > op.size()){
						
					}else{
						opo.clear();
						opo.addAll(op);
					}
					
					sum = local;
					
				}
				op.clear();
				
				local = BigInteger.ZERO;
			}else{
				op.add((a[i]));
				local = local.add(BigInteger.valueOf(a[i]));
			}
		}
		if(local.compareTo(sum)>=0){
			if(opo.size() > op.size()){
				
			}else{
				opo.clear();
				opo.addAll(op);
			}
		}

	return opo;
	}
}
