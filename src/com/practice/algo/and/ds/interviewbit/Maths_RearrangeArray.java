package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class Maths_RearrangeArray {

	/* Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
	 * 
	 * Lets say N = size of the array. Then, following holds true :
		*  All elements in the array are in the range [0, N-1]
		*  N * N does not overflow for a signed integer
		*  						0,1,2,3
		*  Input :  [1, 0]      2,3,1,0
		   Return : [0, 1]      1,0,3,2
		*  0 2 1 3 0
		*  
		*  */
	  
	public static void main(String[] args) {
		Maths_RearrangeArray m = new Maths_RearrangeArray();
		Integer[] in = {2,3,1,0};
		
		m.arrange(new ArrayList<Integer>(Arrays.asList(in)));

	}
	public void arrange(ArrayList<Integer> a) {
	
		for(int i=0;i<a.size();i++){
			int oldU = a.get(i);
			int newU = a.get(oldU);
			int index = oldU;
			int value = oldU;
			
			while(true){
				value = a.get(index);
				if(i==value)
					break;
				index = value;
			}
			a.set(i, newU);
			a.set(index, oldU);
			//a.set(old, old);
		}
	}
}
