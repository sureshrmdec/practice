package com.practice.algo.and.ds.interview.questions;

public class PrintAllPermutations {
	
	public static void main(String[] args) {
		PrintAllPermutations o = new PrintAllPermutations();
		permutation("ABC");
	}
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
}