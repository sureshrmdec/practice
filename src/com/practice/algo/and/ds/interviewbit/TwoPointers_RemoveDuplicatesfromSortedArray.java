package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;

public class TwoPointers_RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int removeDuplicates(ArrayList<Integer> A){
		 if (A.size() < 2)
				return A.size();
		 
			int j = 0;
			int i = 1;
		 
			while (i < A.size()) {
				if (A.get(i).equals(A.get(j))) {
					i++;
				} else {
					j++;
					A.set(j,A.get(i));
					i++;
				}
			}
		 
			return j+1;
			    
			}

}
