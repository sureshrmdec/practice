package com.practice.algo.and.ds.maths.permutationcombi;

public class PrintPermutationsOfString {


	 private static void permutation(String prefix, String str){
	        int n = str.length();
	        if (n == 0) 
	            System.out.println(prefix);
	        else {
	            for (int i = 0; i < n; i++){
	            	//System.out.println("preffix : "+prefix + str.charAt(i)+"string: "+str.substring(0, i) + str.substring(i+1));
	                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1));
	            }
	        }
	    }
	    public static void main(String[] args) {
	        permutation("", "ABCD");
	    }
}
