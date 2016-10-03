package com.practice.algo.and.ds.spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class CandyIII_CANDY3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int n = sc.nextInt();
			BigInteger c = BigInteger.ZERO;
			for(int j=0;j<n;j++){
				c = c.add(sc.nextBigInteger());
			}
			if(c.remainder(BigInteger.valueOf(n))==BigInteger.ZERO){
				System.out.println("YES");
			}else
				System.out.println("NO");
		}

	}

}
