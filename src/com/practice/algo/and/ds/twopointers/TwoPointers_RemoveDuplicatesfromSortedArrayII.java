package com.practice.algo.and.ds.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointers_RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {
		TwoPointers_RemoveDuplicatesfromSortedArrayII o = new TwoPointers_RemoveDuplicatesfromSortedArrayII();
		Integer[] a = {1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010};
		
		//
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(a));
		o.removeDuplicates(A);

	}

	public int removeDuplicates(ArrayList<Integer> A) {
		int length = 0;
		
		 if (A.size() < 2)
				return A.size();
		 
			int j = 0;
			int i = 1;
			int count =1;
			while (i < A.size()) {
				if (A.get(i).equals(A.get(j))) {
					
					if(count<2){
						j++;
						A.set(j,A.get(i));
					}
					i++;
					count++;
				} else {
					count=1;
					j++;
					A.set(j,A.get(i));
					i++;
				}
			}
			
			return j+1;
		
	}

}
