package com.practice.algo.and.ds.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch_SortedInsertPosition {

	public static void main(String[] args) {
		Integer[] in3 = {1,3,5,6};
		ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(in3));
		BinarySearch_SortedInsertPosition p = new BinarySearch_SortedInsertPosition();
		System.out.println(p.searchInsert(a3,4));


	}
	public int searchInsert(ArrayList<Integer> a, int b) {

		int l=0;
		int h=a.size()-1;
		while(l<=h){
			int lv = a.get(l);
			int hv = a.get(h);
			if(b < lv && b<hv){
				return l; 
			}
			if(b > lv && b>hv){
				return h+1; 
			}
			int mid = (l+h)/2;
			int val = a.get(mid);
			if(val==b)
				return mid;
			if(val<b){
				l = mid+1;
			}else if(val>b){
				h=mid-1;
			}
		}
		return 0;
	}
}
