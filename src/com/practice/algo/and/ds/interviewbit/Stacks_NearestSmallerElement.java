package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Stacks_NearestSmallerElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] ar = {3, 2, 1};
		//Integer[] ar = {4,7,6,10,5};
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(ar)); 
		Stacks_NearestSmallerElement o = new Stacks_NearestSmallerElement();
		System.out.println(o.getSmallestNearest(a));
	}

	public ArrayList<Integer> getSmallestNearest(ArrayList<Integer> a){
		ArrayList<Integer> result = new ArrayList<>();
		result.add(-1);
		Stack<Integer> stack = new Stack<>();
		stack.push(a.get(0));
		for(int i=1;i<a.size();i++){
			while(true){
				Integer top = stack.peek();
				if(top<a.get(i)){
					result.add(top);
					break;
				}else{
					stack.pop();
					if(stack.isEmpty()){
						result.add(-1);
						break;
					}
				}
			}
			stack.push(a.get(i));
		}
		return result;
	}
}
