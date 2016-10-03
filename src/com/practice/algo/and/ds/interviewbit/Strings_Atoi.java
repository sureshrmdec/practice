package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;

public class Strings_Atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_Atoi o = new Strings_Atoi();
		System.out.println(o.atoi(" +7"));
	}
	public int atoi(final String a) {
		String aa = a;
		aa = aa.trim();
		int i=0;
		int j = (aa.charAt(0)=='-' || aa.charAt(0)=='+')?1:0;
		for(i=j;i<aa.length();i++){
			if(!(aa.charAt(i) >= '0' && aa.charAt(i) <= '9')){
				break;
			}
		}
		if(aa.substring(j,i).equals("")){
			return 0;
		}else{
			String s = aa.substring(0,i);
			BigInteger d = new BigInteger(s);
			if(d.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0){
				return Integer.MAX_VALUE;
			}else if(d.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0){
				return Integer.MIN_VALUE;
			}
			return Integer.parseInt(aa.substring(0,i));
		}
	
	}
}
