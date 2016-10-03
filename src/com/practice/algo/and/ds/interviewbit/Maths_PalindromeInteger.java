package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;

public class Maths_PalindromeInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maths_PalindromeInteger m = new Maths_PalindromeInteger();
		System.out.println(m.isPalindrome(2147447412));
	}

	public boolean isPalindrome(int a) {
		if(a<0)
			return false;
		BigInteger m =BigInteger.ONE;
		int d=0;
		while(m.compareTo(BigInteger.valueOf(a))<0){
				m = m.multiply(BigInteger.TEN);
				d++;
		}
		m = m.divide(BigInteger.TEN);
		int i=0;
		int k = 10;
		int div =1;
		while(i!=d/2){
			i++;
			int p1 = a%k;
			p1 = p1/div;
			k*=10;
			div*=10;
			
			int p2 = a/m.intValue();
			p2 = p2%10;
			m = m.divide(BigInteger.TEN);
			if(p1!=p2)
				return false;
		}
		
		return true;
	}
}
