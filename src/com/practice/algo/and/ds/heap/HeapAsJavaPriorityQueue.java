package com.practice.algo.and.ds.heap;

import java.util.PriorityQueue;

public class HeapAsJavaPriorityQueue {

	private static PriorityQueue<Integer> heap = new PriorityQueue<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		heap.add(40);
		heap.add(34);
		heap.add(6);
		heap.add(16);
		heap.add(26);
		heap.add(44);
		System.out.println(heap.peek());	
	}

}
