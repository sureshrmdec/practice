package com.practice.algo.and.ds.maths.permutationcombi;

import java.util.Scanner;

public class Class309D_KyoyaandPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

	    int N = in.nextInt();
	    long K = in.nextLong();
		
		long[] fib = new long[N+1];
	    fib[0] = fib[1] = 1;
	    for (int i = 2; i <= N; i++) fib[i] = fib[i-1]+fib[i-2];
	    
	    int idx = 0;
	    int[] res = new int[N];
	    while (idx < N) {
	      if (K <= fib[N-idx-1]) {
	        res[idx] = idx+1;
	        idx++;
	      } else {
	        K -= fib[N-idx-1];
	        res[idx] = idx+2;
	        res[idx+1] = idx+1;
	        idx += 2;
	      }
	    }
	    
	}

}
