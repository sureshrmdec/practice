package com.practice.algo.and.ds.spoj;

import java.util.Scanner;

public class Feynman_SAMER08F {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 0;
		while((x=sc.nextInt())!=0){
			//int x = ;
			int c = 0;
			for(int i=x;i>=1;i--){
				c+=(i*i);
			}
			System.out.println(c);	
		}
		
	}

}
