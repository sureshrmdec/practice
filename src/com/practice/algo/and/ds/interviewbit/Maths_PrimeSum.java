package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;

public class Maths_PrimeSum {

	public static void main(String[] args) {
		
		Maths_PrimeSum o = new Maths_PrimeSum();
		System.out.println(o.primesum(10));

	}
	public ArrayList<Integer> primesum(int a) {
		ArrayList<Integer> r = new ArrayList<>();
		for(int i= 2;i<a;i++){
			if(isPrime(i) && isPrime(a-i)){
				r.add(i);
				r.add(a-i);
				break;
			}
		}
		return r;
    }
	private boolean isPrime(int A) {
		// TODO Auto-generated method stub
		
		int upperLimitA = (int)(Math.sqrt(A));
		for (int i = 2; i <= upperLimitA; i++) {
			if (i < A && A % i == 0) 
			    return false;
		}
		return true;
	}
}
