package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BInarySearch_RotatedSortedArraySearch {

	public static void main(String[] args) {
		Integer[] n = {6,7,0,1,2,3,4,5};
		List<Integer> nL = new ArrayList<Integer>(Arrays.asList(n));
		BInarySearch_RotatedSortedArraySearch o = new BInarySearch_RotatedSortedArraySearch();
		System.out.println(o.search(nL, 2));

	}
	public int search(final List<Integer> n, int a) {
		int l =0;
		int h = n.size()-1;
		while(l<=h){
			int mid = (l+h)/2;
			int val = n.get(mid);

			if(a==val){
				return mid;
			}

			if(val>=n.get(l)){  //first half sorted
				if(a<n.get(l) || a>val){ // a lies outside of the sorted array i.e. first half
					l = mid+1;
				}else 
					h = mid -1;
			}
			else { //Second half sorted
				if(a<val || a>n.get(h)){ // a lies outside of the sorted array i.e. second half
					h = mid-1;
				}else{
					l = mid +1;
				}
			}
		}
		return 0;
	}
}
