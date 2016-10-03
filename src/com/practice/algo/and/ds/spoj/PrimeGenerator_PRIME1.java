package com.practice.algo.and.ds.spoj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PrimeGenerator_PRIME1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=0;i<tc;i++){
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			for(int j=n1;j<=n2;j++){
				if(isPrime(j))
					System.out.println(j);
			}
			
		}
		
	}
	public ArrayList<Integer> sieve(int A) {
		ArrayList<Integer> a = new ArrayList<Integer>();
	    for(int i=2;i<=A;i++){
	        if(isPrime(i)){
	        	a.add(i);
	        }
	    }
	    Collections.sort(a);
	    return a;
	    
	}
	public static boolean isPrime(long n) {
	    if (n <= 3) {
	        return n > 1;
	    } else if (n % 2 == 0 || n % 3 == 0) {
	        return false;
	    } else {
	        double sqrtN = Math.floor(Math.sqrt(n));
	        for (int i = 5; i <= sqrtN; i += 6) {
	            if (n % i == 0 || n % (i + 2) == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	}
}
