package com.practice.algo.and.ds.spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class Smallfactorials_FCTRL2 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i =0;i<t;i++){
			Integer n = sc.nextInt();
			System.out.println(factorial(BigInteger.valueOf(n)));
			
		}
	}

	
	private static BigInteger factorial(BigInteger n) {
		
		// TODO Auto-generated method stub
		BigInteger res=BigInteger.ONE;
		while(n.compareTo(BigInteger.ONE) > 0){
			res = res.multiply(n);
			n= n.subtract(BigInteger.ONE);
		}
		return res;
	}

}
