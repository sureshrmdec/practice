package com.practice.algo.and.ds.String;

import java.util.Stack;

public class StacksStrings_Facebook_EvaluateExpression {

	 public static void main(String[] args)
	    {
	      //  System.out.println(evaluate("10 + 2 * 6"));
	      //  System.out.println(evaluate("100 * 2 + 12"));
	      //  System.out.println(evaluate("100 * ( 2 + 12 )"));
	     //   System.out.println(evaluate("100 * ( 2 + 12 ) / 14"));
		 System.out.println(evaluate("10*2+4/2"));
		 System.out.println(evaluate("10*2+3"));
		 System.out.println(evaluate("10+2*3"));
	    }

	 public static int evaluate(String s) {
		    int len;
		    if(s==null || (len = s.length())==0) return 0;
		    Stack<Integer> stack = new Stack<Integer>();
		    int num = 0;
		    char sign = '+';
		    for(int i=0;i<len;i++){
		        if(Character.isDigit(s.charAt(i))){
		            num = num*10+s.charAt(i)-'0';
		        }
		        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
		            if(sign=='-'){
		                stack.push(-num);
		            }
		            if(sign=='+'){
		                stack.push(num);
		            }
		            if(sign=='*'){
		                stack.push(stack.pop()*num);
		            }
		            if(sign=='/'){
		                stack.push(stack.pop()/num);
		            }
		            sign = s.charAt(i);
		            num = 0;
		        }
		    }

		    int re = 0;
		    for(int i:stack){
		        re += i;
		    }
		    return re;
		}


}
