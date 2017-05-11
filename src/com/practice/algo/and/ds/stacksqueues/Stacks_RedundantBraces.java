package com.practice.algo.and.ds.stacksqueues;

import java.util.Stack;

public class Stacks_RedundantBraces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stacks_RedundantBraces o = new Stacks_RedundantBraces();
		System.out.println(o.braces("(a + (a + b))"));

	}
	public int braces(String a) {
		
		Stack<Character> stack = new Stack<Character>();
		for(int i =0;i<a.length();i++){
			if(a.charAt(i)!=')'){
				stack.push(a.charAt(i));
			}else if(a.charAt(i)==')'){
				if(stack.peek()=='(')
					return 1;
				int operands=0;
				while(true){
					char c = stack.pop();
					if(c=='(')
						break;
					else{
						operands++;
					}
				}
				if(operands==1)
					return 1;
				}
			}
		return 0;
	}
}
