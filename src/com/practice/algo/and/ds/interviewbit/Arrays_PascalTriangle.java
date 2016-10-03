package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;
import java.util.ArrayList;

public class Arrays_PascalTriangle {
	//0 1
	//1 2
	//2 4
	//3 8
	//4 16
	//5 32
	public static void main(String[] args) {
		Arrays_PascalTriangle a = new Arrays_PascalTriangle();
		System.out.println(a.getRow(6));
	}
public ArrayList<Integer> getRow(int A) {
	    
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    res.add(1);
	    
	    for(int k=0;k<A;k++){
	    	int val ;
	    	int last =0;
	    	 for (int i = 0; i < k + 1; i++) {
	    		 val = res.get(i);
	    		 if(i-1>=0){
	    			 val+=last;
	    		 }
		            last = res.get(i);
		            res.set(i, val);
	    	 }
	    	 res.add(res.get(0));
	    }
	    
	    return res;
	    
	}

}
