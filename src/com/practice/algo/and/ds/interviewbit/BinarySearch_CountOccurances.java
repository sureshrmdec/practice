package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch_CountOccurances {

	public static void main(String[] args) {
		BinarySearch_CountOccurances o = new BinarySearch_CountOccurances();
		Integer[] in = {3,5,6,8,8,8,9};
		List<Integer> a = new ArrayList<Integer>(Arrays.asList(in));
		System.out.println(o.findCount(a, 8));

	}
	public int findCount(final List<Integer> a, int b) {
		int c= 0;
		int l = 0;
		int h = a.size()-1;
		while(a.get(l)!=b && a.get(h)!=b){
			int mid = (l+h)/2;
			if(a.get(mid) < b){
				l=mid+1;
				continue;
			}else if(a.get(mid) > b){
				h = mid-1;
			}
					
		}
		return h-l;
	}
}
