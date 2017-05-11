package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointers_MergeTwoSortedListsII {

	public static void main(String[] args) {
		Integer[] A = {1, 2};
		Integer[] B = {-1,2};
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(A));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(B));
		TwoPointers_MergeTwoSortedListsII o = new TwoPointers_MergeTwoSortedListsII();
		o.merge(a, b);
		System.out.println(a);
	}
	
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
	    int m = a.size(); //2
	    int n = b.size(); //2
	    int length = m+n; //4
	    for(int i=0;i<n;i++){
	    	a.add(-1);
	    }
         while(n > 0) {
             if((m-1)>=0 && a.get(m-1) < b.get(n-1) || (m-1<0 && n-1>=0)){ // if element in n is greater than in m. OR m is reached to the end but still n is greater than zero 
                 a.set(length-1,b.get(n-1));
                 n--;
             }else{
                 a.set(length-1,a.get(m-1));
                 m--;
             }
             length--;
         }
	
	}
}
