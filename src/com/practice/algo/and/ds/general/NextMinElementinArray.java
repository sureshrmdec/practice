package com.practice.algo.and.ds.general;

import java.util.Arrays;
import java.util.Stack;

public class NextMinElementinArray {

	/**
	 * @param args
	 */
	


	/*2) Find the next smallest element for all the elements in a given array.
	*/
	
/*	Given an array find the next smaller element in array for each element without changing the original order of the elements.

	For example, suppose the given array is 4,2,1,5,3.

	The resultant array would be 2,1,-1,3,-1.
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextMinElementinArray n = new NextMinElementinArray();
		int[] s = {1,3,5,4,2};
		n.find_next_smaller_elements(s);
	}

	private int[] find_next_smaller_elements(int[] s){
		int[] ys = new int[s.length];
		Arrays.fill(ys,-1);
		Stack<Integer> stack= new Stack<Integer>();
	    for (int i=0;i<s.length;i++){
	        while (!stack.isEmpty() && s[i]<s[stack.peek()]){
	        	ys[stack.pop()]=s[i];
		       }
	           stack.push(i);
	    }
	    return ys;
	}
}
