package com.practice.algo.and.ds.interview.questions;

//Encountered this question in Amazon Coding
//http://stackoverflow.com/questions/2553522/interview-question-check-if-one-string-is-a-rotation-of-other-string

public class Amazon_CheckIfStringIsRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Amazon_CheckIfStringIsRotation o = new Amazon_CheckIfStringIsRotation();
		o.isRotation("","");
	}
/*	If s1 = "stackoverflow" then the following are some of its rotated versions:

		"tackoverflows"
		"ackoverflowst"
		"overflowstack"*/
	boolean isRotation(String s1,String s2) {
				
	    return (s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);
	}
	
	
	
	
}
