package com.practice.algo.and.ds.maths;

public class IsPrime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static boolean isPrime(int n){
		
		for (int i = 3; i*i <= n; i += 2) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
		
	}
}
