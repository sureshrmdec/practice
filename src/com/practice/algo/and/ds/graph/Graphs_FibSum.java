package com.practice.algo.and.ds.graph;

import java.util.ArrayList;

public class Graphs_FibSum {
	   int[] fib;
	    public static int fibsum(int n) {
	        if(n <= 2)
	            return 2;
	        int a = 1;
	        int b = 1;
	        int c = 1;
	        
	        ArrayList<Integer> fibNums = new ArrayList<Integer>();
	        fibNums.add(1);
	        fibNums.add(1);
	        while(true){
	            c = a + b;
	            if(c <= n)
	                fibNums.add(c);
	            else
	                break;
	            
	            a = b;
	            b = c;
	        }
	        
	        System.out.println("Fibnums : " + fibNums);
	        int count = 0;
	        int num = n;
	        int index = fibNums.size() - 1;
	        while(num > 0){
	            System.out.printf("For index = %d and num = %d \n ", index, num);
	            int fib = fibNums.get(index);
	            System.out.println("\t fib = " + fib);
	            if(num >= fib){
	                
	                count += (num/fib);
	                System.out.printf("\t count += (num/fib); is %d \n", count);
	                num %= fib;
	                System.out.println("\t num %= fib is " + num);
	                
	            }
	            index--;
	        }
	        return count;
	    }
	    
	    public static void main(String[] args){
	        
	        System.out.println(fibsum(12));
	        
	    }
}
