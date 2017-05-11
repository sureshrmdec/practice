package com.practice.algo.and.ds.binarysearch;

import java.math.BigInteger;

public class BinarySeach_ImplementPowerFunction {

	public static void main(String[] args) {
		BinarySeach_ImplementPowerFunction o = new BinarySeach_ImplementPowerFunction();
		System.out.println(o.pow(15,13,700000000));
		//71045970,41535484,64735492

	}
	public int pow(int x, int n, int d) {
	    
	    long a = x;
	    long res = 1L;
	    
	    while (n > 0) {
	        if (n % 2 == 1) {
	            res *= a;
	            res %= d;
	        }
	        a *= a;
	        a %= d;
	        n = n >> 1;
	    }
	    
	    res = (res + d) % d;
	    
	    return (int) res;
	    
	}
}
