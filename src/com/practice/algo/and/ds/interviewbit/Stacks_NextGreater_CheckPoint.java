package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Stacks_NextGreater_CheckPoint {

	public static void main(String[] args) {
		Integer[] a = {48, 38, 42, 39, 28, 6, 49, 34};
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(a));
		Stacks_NextGreater_CheckPoint o = new Stacks_NextGreater_CheckPoint();
		System.out.println(o.nextGreater(al));

	}
	//35 42 42 -1 28 39 -1 28 -1
	public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> result = new ArrayList<>();
		result.add(-1);
		stack.push(a.get(a.size()-1));

		
		for(int i=a.size()-2;i>=0;i--){
			
			if(stack.peek()>a.get(i)){
				result.add(0,stack.peek());
				stack.push(a.get(i));
			}else{
				while(!stack.isEmpty() && a.get(i)>stack.peek()){
					stack.pop();
				}
				if(!stack.empty()){
					result.add(0,stack.peek());
				}else{
					result.add(0,-1);	
				}
				stack.push(a.get(i));
				
			}
			
		}
		return result;
	}
}
