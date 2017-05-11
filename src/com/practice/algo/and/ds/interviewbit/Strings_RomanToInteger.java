package com.practice.algo.and.ds.interviewbit;

import java.util.HashMap;

public class Strings_RomanToInteger {

/*	I	1
	V	5
	X	10
	L	50
	C	100
	D	500
	M	1,000
	
	1954 as MCMLIV
	1990 as MCMXC
	2014 as MMXIV*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_RomanToInteger o = new Strings_RomanToInteger();
		System.out.println(o.romanToInt("MMMCMXCIX"));
	}
	static HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	public int romanToInt(String a) {
		int r =0;
	
		
		int prev = map.get(a.charAt(0));
		r+=prev;
		for(int i=1;i<a.length();i++){
			int curr = map.get(a.charAt(i));
			
			if(prev < curr){
				r = (r - prev) + (curr - prev);
			}else{
				r+=curr;
			}
			prev = curr;
		}
		return r;
	}
	static {
		
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
	}
}
