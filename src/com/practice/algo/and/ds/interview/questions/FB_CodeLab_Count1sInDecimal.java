package com.practice.algo.and.ds.interview.questions;

public class FB_CodeLab_Count1sInDecimal {

	public static void main(String[] args) {
		FB_CodeLab_Count1sInDecimal o = new FB_CodeLab_Count1sInDecimal();
		o.numSetBits(11);

	}
	public int numSetBits(long a) {
	    int count = 0;
	    while(a>0){
	        if((a&1)==1){
	            count++;
	        }
	        a = a >> 1;
	    }
	    return count;
	}
}
