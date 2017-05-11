package com.practice.algo.and.ds.backtracking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackTracking_KthPermutationSequenceRevisited {

	public static void main(String[] args) {
		BackTracking_KthPermutationSequenceRevisited o = new BackTracking_KthPermutationSequenceRevisited();
		System.out.println(o.getPermutation(3,4));
	}

	private String getPermutation(int n, int k) {
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++){
			list.add(i+1);
		}
		populateMap(n);
		return getPermutation(n, k, list,"");
		
	}
	private String getPermutation(int n, int k,List<Integer> list,String result) {
		
		if(n==2){
			if(k%2==0){
				result+=list.get(1);
				result+=list.get(0);
				return result;				
			}else{
				result+=list.get(0);
				result+=list.get(1);
				return result;				
			}
		}
		BigInteger totalPossiblePermuation = factorial.get(n);
		BigInteger forOne = totalPossiblePermuation.divide(BigInteger.valueOf(n));
		if(forOne.compareTo(BigInteger.valueOf(k))>0){
			result+=list.get(0);
			list.remove(0);
		}else{
			BigInteger kk = BigInteger.valueOf(k);
			BigInteger nn = BigInteger.valueOf(n);
			while(true){
				if(kk.compareTo(nn)>0)
					kk = kk.divide(forOne);
				else
					break;
			}
			result+=list.get(kk.intValue());
			list.remove(kk.intValue());
		}
		return getPermutation(n-1, k,list,result);
		//return result;
	}
	static Map<Integer, BigInteger> factorial = new HashMap<>();
	public static void populateMap(int n){
		Integer i = 1;
		factorial.put(0,BigInteger.ONE);
		while(i <= n){
			factorial.put(i, (factorial.get(i-1).multiply(BigInteger.valueOf(i))));
			i++;
		}
	}

}
