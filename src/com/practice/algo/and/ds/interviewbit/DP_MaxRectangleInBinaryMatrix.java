package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DP_MaxRectangleInBinaryMatrix {

	public static void main(String[] args) {
		
		
		Integer[] a = {9, 9, 2};
        int g = 3;
        List<Integer> list = new ArrayList<>();
        for (int i = a.length -1 ; i >= 0; i--) {
            g = a[i] + g;
            list.add(0, g % 10);
            g = g / 10;
        }
        //In case the number is greater than array size 
        while ( g >= 10) {
            list.add(0, g % 10);
            g = g / 10;
        }
        list.add(0, g);
        list.toArray(a);
        
		int[] height = {2,1,5,6,4,2,3,15};
		DP_MaxRectangleInBinaryMatrix o = new DP_MaxRectangleInBinaryMatrix();
		System.out.println(o.largestRectangleArea(height));
	}
	public int largestRectangleArea(int[] height) {
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
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}
	 
		}
	 
		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
	 
		return max;
	}

}
