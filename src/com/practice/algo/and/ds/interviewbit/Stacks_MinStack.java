package com.practice.algo.and.ds.interviewbit;

import java.util.Stack;

public class Stacks_MinStack {


	/** initialize your data structure here. */
	Stack<Integer> mainStack ;
	Stack<Integer> minStack ;

	public Stacks_MinStack(){
		mainStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	public void push(int x) {
		mainStack.push(x);
		if(minStack.isEmpty() || minStack.peek()>x){
			minStack.push(x);
		}else{
			minStack.push(minStack.peek());
		}
	}

	public void pop() {
		if(mainStack.isEmpty())
			return ;
		mainStack.pop();
		minStack.pop();
	}

	public int top() {
		if(mainStack.isEmpty())
			return -1;
		return mainStack.peek();
	}

	public int getMin() {
		if(mainStack.isEmpty())
			return -1;
		return minStack.peek();
	}
}
