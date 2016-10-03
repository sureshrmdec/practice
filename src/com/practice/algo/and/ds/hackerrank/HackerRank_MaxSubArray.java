package com.practice.algo.and.ds.hackerrank;

import java.util.Scanner;

public class HackerRank_MaxSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] array;
		for(int i =0;i<t;i++){
			int s = sc.nextInt();
			 array = new int[s];
			for(int j=0;j<s;j++){
				array[j] = sc.nextInt();
			}
			maxSum(array);
		}
	}

	private static void maxSum(int[] a) {
		// TODO Auto-generated method stub
		
		 int currNonContigous = a[0];
		int max_so_far = a[0], i;
		  int curr_max = a[0];
		  
		  for(i=1;i<a.length;i++){
			  
			  curr_max = Math.max(a[i], curr_max+a[i]);
			  max_so_far = Math.max(curr_max, max_so_far);
			  
			  currNonContigous = Math.max(currNonContigous, Math.max(a[i]+currNonContigous,a[i]));
			  
		  }
		 System.out.println(max_so_far+" "+currNonContigous);
		 
	}

}
