package com.practice.algo.and.ds.stacksqueues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Stacks_LargestRectangleHistogram {

	public static void main(String[] args) {
		int[] heights = {5,4,3,1,2,1,3};
		//int[] heights = {6,2,5,4,5,1,6};
		Stacks_LargestRectangleHistogram o = new Stacks_LargestRectangleHistogram();
		System.out.println(o.largestRectangleAreaPC(heights));

	}
	public int largestRectangleArea(int[] heights) {
		if(heights==null || heights.length==0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int max = Integer.MIN_VALUE;
		int i=0;
		while(i<heights.length){
			//If stack is empty and current height is less than top height of the stack
			if(stack.isEmpty() ||heights[i]<stack.peek()){
				stack.push(heights[i]);
				i++;

				int min = stack.peek();

				int count =0;
				ArrayList<Integer> al = new ArrayList<>();
				while(!stack.isEmpty() && stack.peek()>=min){    				
					al.add(0,stack.pop());
					count++;
				}
				stack.addAll(al);
				max = Math.max(Math.max(max, count*min),stack.peek());

			}else{
				//get minimum height, this will make common rectangle
				int min = stack.peek();
				//Now push the current element
				stack.push(heights[i]);
				i++;
				int count =0;
				ArrayList<Integer> al = new ArrayList<>();
				while(!stack.isEmpty() && stack.peek()>=min){    				
					al.add(0,stack.pop());
					count++;
				}
				stack.addAll(al);
				max = Math.max(Math.max(max, count*min),stack.peek());
			}
		}

		return max;

	}
	//http://www.programcreek.com/2014/05/leetcode-largest-rectangle-in-histogram-java/
	//Keep track of left and right indexes and calculate the area of inside
	//int[] heights = {5,4,3,1,2,1,3};
	public int largestRectangleAreaPC(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();

		int max = 0;
		int i = 0;

		while (i < height.length) {
			//push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				//calculate max value when the current height is less than the previous one
				// If this bar is lower than top of stack, then calculate area of rectangle 
				// with stack top as the smallest (or minimum height) bar. 'i' is 
				// 'right index' for the top and element before top in stack is 'left index'

				// i is the right index
				// top of the stack is min height/bar...
				// element before the top in stack is left index
				// we have to calculate the area of rectangle between left and right index with min height...
				//	left and right index are used to calculate width w

				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}

		}
		// i is the right index
		// top of the stack is min height/bar...
		// element before the top in stack is left index
		// we have to calculate the area of rectangle between left and right index with min height...
		//	left and right index are used to calculate width w
		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}

		return max;
	}
}
