package com.practice.algo.and.ds.dp;

import java.util.Arrays;
import java.util.Scanner;

public class HackerRank_TheCoinChange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int M = sc.nextInt();
		int[] S = new int[M];
		for (int i=0; i<M; i++)
	        	S[i] = sc.nextInt();
	 
		int[][] table = new  int[n+1][S.length];
	    
	    // Fill the enteries for 0 value case (n = 0)
	    for (int i=0; i<M; i++)
	        table[0][i] = 1;
	 
	    // Fill rest of the table enteries in bottom up manner  
	    for (int i = 1; i < n+1; i++)
	    {
	        for (int j = 0; j < M; j++)
	        {
	            // Count of solutions including S[j]
	            int x = (i-S[j] >= 0)? table[i - S[j]][j]: 0;
	 
	            // Count of solutions excluding S[j]
	            int y = (j >= 1)? table[i][j-1]: 0;
	 
	            // total count
	            table[i][j] = x + y;
	        }
	    }
	 	
		System.out.println();
		
	}

	private static int rec(int n, int[] values) {
		if(n<0){
			return 0;
		}
		int result =0;
		if(n==0)
			return 1;
		/*for(int i=0;i<values.length;i++){
			if(values[i]==n){
				return 1;
			}
		}*/
		for(int i =0;i<values.length;i++){
			result+=rec(n-values[i],values);
		}
		return result;
	}

}
