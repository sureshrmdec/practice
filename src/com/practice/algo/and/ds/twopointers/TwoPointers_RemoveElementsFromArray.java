package com.practice.algo.and.ds.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointers_RemoveElementsFromArray {

	public static void main(String[] args) {
		Integer[] c = {4,1,1,2,1,3};
		ArrayList<Integer> in = new ArrayList<>(Arrays.asList(c));
		TwoPointers_RemoveElementsFromArray o = new TwoPointers_RemoveElementsFromArray();
		System.out.println(o.remove(in,1));
	}

	private int remove(ArrayList<Integer> in, int val) {
		// TODO Auto-generated method stub
		int i=0;
		int j=0;
		while(i<in.size()){
			if(in.get(i).equals(val)){
				i++;
			}else{
				in.set(j,in.get(i));
				i++;
				j++;
			}
		}
		return j;
	}

}
