package com.practice.algo.and.ds.interviewbit;

//To check if number is prime or not
public class TimeComplexityPrimeNumberCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPrime(1));
		int n = 1;
		if(n==1){
			System.out.println("not a prime");
			return;
		}
		double s = Math.sqrt(n);
		boolean prime = true;
		for(int i=2;i<=s;i++){
			if(n%i==0){
				prime = false;
				break;
			}
		}
		if(prime){
			System.out.println("its a prime");
			
		}else{
			System.out.println("not a prime");
			
		}
	}
	public static int isPrime(int A) {
		if(A==1){
			return 0;
		}
		int upperLimit = (int)(Math.sqrt(A));
		for (int i = 2; i <= upperLimit; i++) {
			if (i < A && A % i == 0) 
			    return 0;
		}
		return 1;
	}
}
