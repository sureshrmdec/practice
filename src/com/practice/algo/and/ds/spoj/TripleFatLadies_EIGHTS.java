package com.practice.algo.and.ds.spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class TripleFatLadies_EIGHTS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] a = {192,442,692,942};
		
		int y = sc.nextInt();
		for(int i=0;i<y;i++){
			BigInteger s = sc.nextBigInteger();
			BigInteger rem = s.subtract(BigInteger.ONE).remainder(BigInteger.valueOf(4));
			BigInteger d = s.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4));
			if(d.compareTo(BigInteger.ZERO)>0){
				System.out.println(d.toString().concat(Integer.toString(a[rem.intValue()])));	
			}else{
				System.out.println((Integer.toString(a[rem.intValue()])));
			}
			
		}

	}

}
