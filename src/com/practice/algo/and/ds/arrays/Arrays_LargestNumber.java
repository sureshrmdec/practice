package com.practice.algo.and.ds.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Arrays_LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays_LargestNumber l = new Arrays_LargestNumber();
		Integer[] rr = {3, 30, 34, 5, 9};
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(rr));
		System.out.println(l.largestNumber(list));
		
	}

	public String largestNumber(final List<Integer> a) {
			Collections.sort(a, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Integer.parseInt(Integer.toString(o1).concat(Integer.toString(o2))) > Integer.parseInt(Integer.toString(o2).concat(Integer.toString(o1)))){
					return -1; //Dont change the order of o1 and o2
				}else{
					return 1;
				}
				//return 0;
			}
		});
		StringBuilder s =new StringBuilder();
		boolean isZero = true;
		for(int i=0;i<a.size();i++){
		if(a.get(i)>0){
			isZero=false;
			break;
		}
		}
		if(isZero)
			return "0";
		
		if(!isZero){
		for(int i=0;i<a.size();i++){
			s.append(a.get(i));
		}
		}
		return s.toString();
	}
	
	
	
}
