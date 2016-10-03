package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch_SearchforaRange {

	public static void main(String[] args) {
		Integer[] in3 = {20,22,22,22,23,24,25};
		ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(in3));
		BinarySearch_SearchforaRange p = new BinarySearch_SearchforaRange();
		System.out.println(p.searchRange(a3, 21));

	}
	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
	int l = searchLow(a, b);
	int h=-1;
	if(l!=-1){
		h = searchHigh(a, b);
	}
	
	ArrayList<Integer> res = new ArrayList<>();
	res.add(l);
	res.add(h);
	return res;
	}
	private int searchLow(final List<Integer> a, int b){
		int low = 0;
	    int high = a.size()-1;
	   int r=-1;
	    int mid;
	   
	    int val;
	    
	    while (low<=high) {
	        
	        mid = (low + high) / 2;
	        val = a.get(mid);
	        
	        if (b < val) {
	            high = mid - 1;
	        } else if (b > val) {
	            low = mid + 1;
	        } else {
	            //low = mid;
	            high = mid - 1;
	            r=mid;
	        }

	    }
	    
	  
	    
	
		return r;
	}
	
	private int searchHigh(final List<Integer> a, int b){
		int low = 0;
	    int high = a.size()-1;
	   int r=-1;
	    int mid;
	   
	    int val;
	    
	    while (low<=high) {
	        
	        mid = (low + high) / 2;
	        val = a.get(mid);
	        
	        if (b < val) {
	            high = mid - 1;
	        } else if (b > val) {
	            low = mid + 1;
	        } else {
	            //low = mid;
	            low = mid + 1;
	            r=mid;
	        }

	    }
	    
	  
	    
	
		return r;
	}
}
