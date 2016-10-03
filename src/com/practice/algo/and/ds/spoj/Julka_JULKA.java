package com.practice.algo.and.ds.spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class Julka_JULKA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		for(int i=0;i<10;i++){
			BigInteger total = s.nextBigInteger();
			BigInteger more = s.nextBigInteger();
			BigInteger ss = (total).subtract((more)); 
			BigInteger res = (ss).divide(BigInteger.valueOf(2));
			System.out.println(res.add((more)));
			
			System.out.println(res);
			ss=null;
			res=null;
			
		}
	}

}
