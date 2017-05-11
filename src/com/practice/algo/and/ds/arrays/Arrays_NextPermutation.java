package com.practice.algo.and.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Arrays_NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Integer[] in = { 251, 844, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 891, 991};
		Integer[] in = {2,3,1};
		Arrays_NextPermutation j = new Arrays_NextPermutation();
		j.nextPermutation(new ArrayList<Integer>(Arrays.asList(in)));
	}

	public void nextPermutation(ArrayList<Integer> a) {
		
		Integer[] ar = new Integer[a.size()];
		ArrayList<Integer> ab = new ArrayList<>();
		ab.addAll(a);
		Collections.sort(ab);
		int k=0;
		 Integer[] r = printPermutation(ab,0,a);
		 System.out.println(r);
		
		
	
	}
	boolean found = false;
	private Integer[] printPermutation(ArrayList<Integer> a,Integer k,ArrayList<Integer> aa){
		 for(int i = k; i < a.size(); i++){
	            java.util.Collections.swap(a, i, k);
	            Integer[] res = printPermutation(a, k+1,aa);
	            if(res!=null){
	            	return res;
	            }
	            java.util.Collections.swap(a, k, i);
	        }
	        if (k == a.size() -1){
	            System.out.println(java.util.Arrays.toString(a.toArray()));
	            Integer[] ara = new Integer[a.size()];
	            a.toArray(ara);
	            Integer[] aaa = new Integer[aa.size()];
	            aa.toArray(aaa);
	            if(found){
	            	return aaa;
	            }
	            if(Arrays.equals(ara, aaa)){
	            	found = true;
	            }
	            
	        }
	        return null;
	}
}
