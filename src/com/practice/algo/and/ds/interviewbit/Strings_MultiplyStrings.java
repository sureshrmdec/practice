package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;

public class Strings_MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_MultiplyStrings o = new Strings_MultiplyStrings();
		System.out.println(o.multiply("31243242535342", "0"));
	}
	public String multiply(String a, String b) {
		StringBuilder res = new StringBuilder();
		int la = a.length();
		BigInteger ia = BigInteger.ZERO;
		BigInteger ten = BigInteger.TEN;
		int i,j;
		for(i=a.length()-1,j=0;i>=0 && j<a.length();i--,j++){
			int ch = a.charAt(j)-'0';
			ia = ia.add(BigInteger.valueOf(ch).multiply( (ten.pow(i))));
		}
		i=0;j=0;
		BigInteger ib = BigInteger.ZERO;
		for(i=b.length()-1,j=0;i>=0 && j<b.length();i--,j++){
			int ch = b.charAt(j)-'0';
			ib = ib.add(BigInteger.valueOf(ch).multiply( (ten.pow(i))));
		}
		BigInteger r = ia.multiply(ib);
		BigInteger s = BigInteger.ONE;
		int rem=0;
		while(r.compareTo(BigInteger.ONE)>=0){
		BigInteger d =	r.divide(BigInteger.TEN);
		rem =	r.remainder(BigInteger.TEN).divide(s).intValue();
		
		
		res = res.append(rem);
		s.multiply(BigInteger.TEN);
		r = d;
			
		}
		res.reverse();
		return res.length()>0?res.toString():"0";
	}
}
