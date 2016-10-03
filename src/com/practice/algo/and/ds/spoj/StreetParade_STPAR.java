package com.practice.algo.and.ds.spoj;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StreetParade_STPAR {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0){
				System.exit(0);
			}
			int[] a = new int[n];
			for(int i=0;i<n;i++){
				a[i] = sc.nextInt();
			}
			Stack<Integer> stack = new Stack<Integer>();
			Deque<Integer> queue = new LinkedList<Integer>();
			stack.push(a[0]);
			boolean nb = false;
			for(int i=1;i<n && !nb;i++){
				if(a[i] < stack.peek()){
					stack.push(a[i]);
				}else if(a[i] > stack.peek()){
					while(!stack.isEmpty() && a[i]>stack.peek()){
						if(!queue.isEmpty() && (stack.peek() < queue.peekLast())){
							nb = true;
							break;
						}
						queue.add(stack.pop());
					}
					stack.add(a[i]);
				}
			}
			
			while(!stack.isEmpty() && !nb){
				if(stack.peek()>queue.peekLast()){
					queue.add(stack.pop());
				}else{
					nb = true;
					break;
				}
			}
			if(!nb)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}

}
