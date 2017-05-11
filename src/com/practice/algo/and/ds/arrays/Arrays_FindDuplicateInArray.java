package com.practice.algo.and.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Arrays_FindDuplicateInArray {

	public static void main(String[] args) {
		Integer[] aa = {3 ,4, 1 ,4, 1};
		List<Integer> in = new ArrayList<>(Arrays.asList(aa));
		Arrays_FindDuplicateInArray g = new Arrays_FindDuplicateInArray();
		System.out.println(g.repeatedNumber(in));

	}
	public int repeatedNumber(final List<Integer> a) {
	
		Set<Integer> s = new HashSet<>();
		int ii=0;
		for(Integer i:a){
			if(s.add(i)==false){
				break;
			}
			ii++;
		}
		return a.get(ii);
	}

}
