package com.practice.algo.and.ds.hashing;

import java.util.HashSet;
import java.util.List;

public class Hashing_DiffkIi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int diffPossible(final List<Integer> input, int k) {
		HashSet<Integer> set = new HashSet<>();
		for(Integer i:input){
			if(set.contains(i)){
				return 1;
			}
			if(i<k){
				set.add(i+k);
			}else{
				set.add(i-k);
			}
		}
		return 0;
	}
}
