package com.practice.algo.and.ds.stacksqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
//http://www.programcreek.com/2014/05/leetcode-sliding-window-maximum-java/

public class Stacks_SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] ar = {1, 3, -1, -3, 5, 3, 6, 7};
		//Integer[] ar = {3,2,1,0,5,3,6,7};
		//Integer[] ar = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(ar));
		Stacks_SlidingWindowMaximum o = new Stacks_SlidingWindowMaximum();
		System.out.println(o.maxSlidingWindowDequeue(a, 3));

	}
	public ArrayList<Integer> maxSlidingWindowDequeue(ArrayList<Integer> nums, int k) {

		if(nums==null||nums.size()==0)
			return new ArrayList<Integer>();

		ArrayList<Integer> result = new ArrayList<Integer>();

		LinkedList<Integer> deque = new LinkedList<Integer>();
		for(int i=0; i<nums.size(); i++){
			if(!deque.isEmpty()&&deque.peekFirst()==i-k) 
				deque.poll();

			while(!deque.isEmpty()&&nums.get(deque.peekLast())<nums.get(i)){
				deque.removeLast();
			}    

			deque.offer(i);

			if(i+1>=k)
				result.add(nums.get(deque.peek()));
		}

		return result;
	}
	//My Implementation---not so correct...got accepted in LeetCOde but not on InterviewBit
	//removing the element from the heap O(logn) is the culprit.
	//In below implemntation maxSlidingWindowDequeue, dequeue give O(1) removal and insertion time...
	public ArrayList<Integer> maxSlidingWindow(ArrayList<Integer> nums, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2){
					return -1;
				}else if(o1<o2){
					return 1;
				}
				return 0;
			}
		});

		for(int i =0;i<k;i++){
			queue.add(nums.get(i));
		}

		for(int i =k;i<nums.size();i++){
			result.add(queue.peek());
			int a = nums.get(i-k);
			queue.remove(a);
			queue.add(nums.get(i));
		}
		result.add(queue.peek());
		return result;

	}

	
}
