package com.practice.algo.and.ds.spoj;

import java.util.Scanner;

public class AmbiguousPermutations_PERMUT2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			boolean am = true;
			if(n==0){
				System.exit(0);
			}
			int[] a = new int[n+1];
			for(int i=1;i<a.length;i++){
				int c = sc.nextInt();
				a[i] = c;
			}
			for(int i=1;i<a.length;i++){
				if(i != a[a[i]]){
					am=false;
				}
			}
			if(am)
				System.out.println("ambiguous");
			else
				System.out.println("not ambiguous");
		}
		
	}

}
