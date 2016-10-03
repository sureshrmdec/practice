package com.practice.algo.and.ds.general;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NextGreaterElement nge = new NextGreaterElement();
		int[] a = {4, 5, 2, 25, 20, 11, 13, 21, 3};
		nge.makeNGE(a);
	}

	private int[] makeNGE(int[] a) {
		int[] result = new int[a.length];
		Arrays.fill(result,-1);
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		for(int i =1;i<a.length;i++){
		
			while(!stack.isEmpty() && a[i]>a[stack.peek()]){
				int index = stack.pop();
				result[index] = a[i]; 
			}
				stack.push(i);
			}
		
		return result;
	}

}
