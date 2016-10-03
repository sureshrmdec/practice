package com.practice.algo.and.ds.spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class CountingTriangles_TRICOUNT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int j=0;j<t;j++){
			int x = sc.nextInt();
			BigInteger xx = BigInteger.ONE.shiftLeft(x+1);
			BigInteger result = (xx).subtract(BigInteger.valueOf(3));
			System.out.println(result);
		}
	}
}
