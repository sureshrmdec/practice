package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;

public class Maths_ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maths_ReverseInteger m = new Maths_ReverseInteger();
		System.out.println(m.reverse(-1146467285));//-1146467285
	}
	public int reverse(int a) {
		if(a>=0 && a<=9){
			return a;
		}
		BigInteger m =BigInteger.ONE;
		boolean isNeg = false;
		if(a<0){
			isNeg = true;
		}
		a = Math.abs(a);
		while(m.compareTo(BigInteger.valueOf(a))!=1){
			m = m.multiply(BigInteger.TEN);

	}
		m = m.divide(BigInteger.TEN);
		
		//m = m.divide(BigInteger.TEN);
		BigInteger mul = BigInteger.ONE;
		int res = 0;
		boolean overflow = false;
		while(a!=0){
			int b=a/m.intValue();
			res+=b*mul.intValue();
			a= a%m.intValue();
			m = m.divide(BigInteger.TEN);
			mul = mul.multiply(BigInteger.TEN);
		}
		if(overflow)
			return 0;
		if(isNeg){
			return 0-res;
		}
		return res;
	}
}
