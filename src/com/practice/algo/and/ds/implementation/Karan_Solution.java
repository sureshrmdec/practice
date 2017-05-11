package com.practice.algo.and.ds.implementation;

public class Karan_Solution {

	public static void main(String[] args) {
		Integer n = 100;
		String a = Integer.toBinaryString(n);
		System.out.println(a);
		
		int result = 0;
		int j=0;
		System.out.println(~n^n);
		for(int i=a.length()-1;i>=0;i--){
			if(a.charAt(i)=='0')
				result += Math.pow(2, j);
			j++;
		}
	System.out.println(result);
	}

}
