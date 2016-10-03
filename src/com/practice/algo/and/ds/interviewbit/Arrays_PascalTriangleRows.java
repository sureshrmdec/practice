package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;

public class Arrays_PascalTriangleRows {

	public static void main(String[] args) {
		Arrays_PascalTriangleRows a = new Arrays_PascalTriangleRows();
		System.out.println(a.generate(4));

	}
	public ArrayList<ArrayList<Integer>> generate(int a) {
		
		if(a==0){
			return new ArrayList<ArrayList<Integer>>();
		}
	    
	    ArrayList<ArrayList<Integer>> resO = new ArrayList<>();
	    ArrayList<Integer> o = new ArrayList<Integer>();
	    o.add(1);
	    resO.add(o);
	    
	    	ArrayList<Integer> res = new ArrayList<>();
	    	res.add(1);
		    
		    for (int k = 0; k < a-1; k++) {
		        int val;
		        int last = 0;
		        for (int i = 0; i < k + 1; i++) {
		            val = res.get(i);
		            if (i - 1 >= 0)
		               val += last;
		            last = res.get(i);
		            res.set(i, val);
		        }
		        
		        res.add(res.get(0));
		        
		        resO.add(new ArrayList<>(res));
		    }
		    
		    
	    
	    return resO;
	    
	
	}

}
