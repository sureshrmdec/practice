package com.practice.algo.and.ds.spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class Williteverstop_WILLITST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		BigInteger x = sc.nextBigInteger();
		
		while (((x.and(BigInteger.ONE)).compareTo(BigInteger.ZERO) == 0) && x.compareTo(BigInteger.ONE) > 0) /* While x is even and > 1 */
			    x = x.shiftRight(1);
			   
		if(x.compareTo(BigInteger.ONE)==0){
			System.out.println("TAK");
		}else{
			System.out.println("NIE");
		}
	}

}
