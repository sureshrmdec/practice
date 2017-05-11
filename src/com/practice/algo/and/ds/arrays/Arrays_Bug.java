package com.practice.algo.and.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays_Bug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer aa[] = {1,2,3,4,5,6};
		int B = 1;
		//Integer aa[] ={-2,1,-3,4,-1,2,1,-5,4};
		//0111000100010 
		List<Integer> a = Arrays.asList(aa);
		Arrays_Bug o = new Arrays_Bug();
		System.out.println(o.rotateArray(new ArrayList<Integer>(a), B));

	}
	public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
		ArrayList<Integer> ret = new ArrayList<Integer>(A.size());

		for (int i = 0; i < A.size(); i++) {
			ret.add(A.get((i+B)%A.size()));
		}
		return ret;
	}	
}
