package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Stacks_EvaluateExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] t = {"0","3","/"};
		String[] t = {"4", "13", "5", "/", "+"};
		ArrayList<String> tokens = new ArrayList<>(Arrays.asList(t));
		Stacks_EvaluateExpression o = new Stacks_EvaluateExpression();
		System.out.println(o.evalRPN(tokens));
		System.out.println(o.evalRPN(t));

	}
    public int evalRPN(ArrayList<String> tokens) {
        if(tokens.size()==1){
    		return Integer.parseInt(tokens.get(0));
    	}
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.size();i++){
        	String c = tokens.get(i);
        	if(c.equals("+") || c.equals("*") || c.equals("/") || c.equals("-")){
        		int op2 = stack.pop();
        		int op1 = stack.pop();
        		int r = 0;
        		switch (c) {
        		case "+":r = op1+op2;
        				 break;

        		case "-":r = op1-op2;
						 break;       		
        		
        		case "*":r = op1*op2;
						 break;        		
        		
        		case "/":r = op1/op2;
						 break;        		
        		}
        			stack.push(r);
        	}else{
        		stack.push(Integer.parseInt(c));
        	}
        }
        return stack.peek();
    }
    public int evalRPN(String[] tokens) {
        if(tokens.length==1){
    		return Integer.parseInt(tokens[0]);
    	}
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
        	String c = tokens[i];
        	if(c.equals("+") || c.equals("*") || c.equals("/") || c.equals("-")){
        		int op2 = stack.pop();
        		int op1 = stack.pop();
        		int r = 0;
        		switch (c) {
        		case "+":r = op1+op2;
        				 break;

        		case "-":r = op1-op2;
						 break;       		
        		
        		case "*":r = op1*op2;
						 break;        		
        		
        		case "/":r = op1/op2;
						 break;        		
        		}
        			stack.push(r);
        	}else{
        		stack.push(Integer.parseInt(c));
        	}
        	
        }
        
        return stack.peek();
    
        
    }
}
