package com.practice.algo.and.ds.spoj;


import java.util.Scanner;
import java.util.Stack;

public class TransformtheExpression_ONP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i =0;i<t;i++){
			char[] n = sc.next().toCharArray();
			Stack<String> stack = new Stack<String>();
			for(int j=0;j<n.length;j++){
				if(n[j]!=')'){
					stack.push(Character.toString(n[j]));
				}else if(n[j]==')'){
					//stack.push(Character.toString(n[j]));
					
						String operand2 = stack.pop();
						String operator = stack.pop();
						String operand1 = stack.pop();
						operand1 = operand1+operand2+operator;
						stack.pop();
						stack.push(operand1);
					
				}
			}
			System.out.println(stack.pop());
			
		}

	}

}
