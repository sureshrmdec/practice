package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackTracking_KthPermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BackTracking_KthPermutationSequence o = new BackTracking_KthPermutationSequence();
		System.out.println(o.getPermutation(4 ,14));
	}
	 

	static Map<Integer, BigInteger> factorial = new HashMap<>();
	
	public String getPermutation(int n, int k) {
		BigInteger kk = BigInteger.valueOf(k);
		populateMap(n);	
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++){
			list.add(i+1);
		}
		String str = "";
		int nn = n;
		for(int i=0;i<n;i++){
			BigInteger f = factorial.get(nn);
			BigInteger singleSize= f.divide(BigInteger.valueOf(list.size())); //singleSize is how many permutations get started for each number as a start
			int index = getNext(kk,list,singleSize);
			str+=list.get(index);
			list.remove(index);
			kk = kk.subtract(singleSize.multiply(BigInteger.valueOf(index))); //subtract how many we can eliminate
			if(k==1){
				for(Integer s:list){
					str+=s;
				}
				return str;
			}
			nn--;
		}
		return str;
	}

	private int getNext(BigInteger k, List<Integer> list,BigInteger minSize) {
		// TODO Auto-generated method stub
		int index = 0;
		BigInteger s = BigInteger.ZERO;
		while(s.compareTo(k)<0){
			//s+=minSize;
			s = s.add(minSize);
			index++;
		}
	
		return index-1;
	}
	public static void populateMap(int n){
        Integer i = 1;
        factorial.put(0,BigInteger.ONE);
        while(i <= n){
        	factorial.put(i, (factorial.get(i-1).multiply(BigInteger.valueOf(i))));
            i++;
        }
    }

}
