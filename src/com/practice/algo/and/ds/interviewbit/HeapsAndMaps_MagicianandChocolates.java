package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapsAndMaps_MagicianandChocolates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {2147483647, 2000000014, 2147483647};
		//Integer[] a = {6,5};
		int b = 10;
		ArrayList<Integer> bags = new ArrayList<>(Arrays.asList(a));
		HeapsAndMaps_MagicianandChocolates o = new HeapsAndMaps_MagicianandChocolates();
		System.out.println(o.maxChoclates(10,bags));
	}

	public int maxChoclates(int K, ArrayList<Integer> bags){
		BigInteger result = BigInteger.ZERO;
		//double mod = Math.pow(10, 9)+7;
		Integer mod = 1000000007;

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2){
					return -1;
				}else if(o1<o2){
					return 1;
				}
				return 0;
			}
		});
		//284628164
		for(int i=0;i<bags.size();i++){
			pq.add(bags.get(i));
		}
		for(int i=0;i<K;i++){
			Integer top = (pq.poll()); 
			result = result.add(BigInteger.valueOf(top));
			result = (result.mod(BigInteger.valueOf(mod)));
			pq.add((top/2));
		}

		return result.intValue();
	}
}


