package com.practice.algo.and.ds.interview.questions;

import java.util.Stack;

public class Stacks_LeetCode_BasicCalculatorII {
	

	public static void main(String[] args) {
		Stacks_LeetCode_BasicCalculatorII o = new Stacks_LeetCode_BasicCalculatorII();
		 System.out.println(o.calculate("10*2+4/2"));
		 System.out.println(o.calculate("10*2+3"));
		 System.out.println(o.calculate("10+2*3"));

	}
    public int calculate(String s) {
     
    	Stack<Integer> numStack = new Stack<>();
    	Stack<Character> charStack = new Stack<>();
    	char[] tokens = s.toCharArray();
    	for(int i=0;i<tokens.length;i++){
    		char c = tokens[i];
    		if(c>='0' && c<='9'){
    			StringBuilder sb = new StringBuilder();
    			int ii = i;
    			while(ii<tokens.length && tokens[ii]>='0' && tokens[ii]<='9'){
    				sb.append(tokens[ii++]);
    			}
    			numStack.push(Integer.parseInt(sb.toString()));
    			i = ii-1;
    		}
    		 else if (tokens[i] == '+' || tokens[i] == '-' ||
                     tokens[i] == '*' || tokens[i] == '/')
            {
    			 while (!charStack.empty() && hasPrecedence(tokens[i], charStack.peek()))
    				 numStack.push(applyOp(charStack.pop(), numStack.pop(), numStack.pop()));
    		     // Push current token to 'ops'.
    			 charStack.push(tokens[i]);
            }
    		
    	}
    	  while (!charStack.empty())
    		  numStack.push(applyOp(charStack.pop(), numStack.pop(), numStack.pop()));
	 
	        // Top of 'values' contains result, return it
	        return numStack.pop();
    	
    	
    }
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 
    // A utility method to apply an operator 'op' on operands 'a' 
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }
}
