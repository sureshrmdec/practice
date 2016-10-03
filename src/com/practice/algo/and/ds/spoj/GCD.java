package com.practice.algo.and.ds.spoj;

import java.util.Scanner;

public class GCD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(6%18);
		System.out.println(6%10);
		System.out.println(gcd(n,m));
	}

	private static int gcd(int n, int m) {
		// TODO Auto-generated method stub
		
		if(n>m){
			if((n % m)==0){
				return m;
			}else{
				n-=m;
				gcd(n,m);
			}
		}else{
			if((m % n)==0){
				return n;
			}else{
				m-=n;
				gcd(n,m);
			}
		}
		return 0;
	}

}
