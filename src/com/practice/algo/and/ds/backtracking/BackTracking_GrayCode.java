package com.practice.algo.and.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
000
001
011
010
110
111
101
100
 */
public class BackTracking_GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackTracking_GrayCode o = new BackTracking_GrayCode();
		System.out.println(o.grayCode(4));
	}

	public ArrayList<Integer> grayCode(int n) {
	    
		 if(n==0){
			ArrayList<Integer> l = new ArrayList<>();
			 l.add(0);
			 return l;
			 
		 }
		 if(n==1){
			 ArrayList<Integer> l = new ArrayList<>();
			 l.add(0);
			 l.add(1);
			 return l;
		 }
		 ArrayList<Integer> result = new ArrayList<>();
		 
		 ArrayList<Integer> remaining = grayCode(n-1);
		 result.addAll(remaining);
		 for(int i=remaining.size()-1;i>=0;i--){
			 int a = remaining.get(i);
			 int aa = 1 << n-1;
			 result.add(a|aa);
		 }
		 
		 
		 return result;
	    
	}
}
