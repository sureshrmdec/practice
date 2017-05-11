package com.practice.algo.and.ds.implementation;

import java.util.Scanner;

public class EducationalCF10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int h1 = sc.nextInt();
		int h2 = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(b>a){
			System.out.println("-1");
		}else{
		boolean day=true;
		h1+=(8*a);
		day = false;
		int res=0;
		while(h1<h2){
			if(day){
				h1+=(8*a);
				day=false;
			}else{
				h1-=(12*b);
				res++;
				day=true;
			}
		}
		System.out.println(res);
	}
	}
}
