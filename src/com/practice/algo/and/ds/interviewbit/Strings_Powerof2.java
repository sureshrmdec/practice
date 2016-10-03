package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;

public class Strings_Powerof2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_Powerof2 o = new Strings_Powerof2();
		System.out.println(o.power("1"));
	}
	public int power(String a) {
		if(a.equals("1")){
			return 0;
		}
		BigInteger b = new BigInteger(a);
		while((b.and(BigInteger.ONE).compareTo(BigInteger.ZERO)==0 && b.compareTo(BigInteger.ONE)>0)){
			b=b.shiftRight(1);
		}
		if(b.compareTo(BigInteger.ONE)==0){
			return 1;
		}
		else{
			return 0;
		}
	}
}
