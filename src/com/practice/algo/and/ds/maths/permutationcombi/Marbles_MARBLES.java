package com.practice.algo.and.ds.maths.permutationcombi;

import java.math.BigInteger;
import java.util.Scanner;

public class Marbles_MARBLES {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int n = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(calculateCombination(n-1, k-1));
		}

	}
	public static BigInteger calculateCombination(int n,int k){
		
		if(k>n/2){
			k = n-k;
		}
		    BigInteger ret = BigInteger.ONE;
		    for (int i = 0; i < k; i++) {
		        ret = ret.multiply(BigInteger.valueOf(n-i))
		                 .divide(BigInteger.valueOf(i+1));
		    }
		    return ret;
		
	}
}
