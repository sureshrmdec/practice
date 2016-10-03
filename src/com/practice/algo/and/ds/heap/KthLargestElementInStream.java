package com.practice.algo.and.ds.heap;

import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class KthLargestElementInStream {

	
	static PriorityQueue<Double>  heap = new PriorityQueue<>(5);
	static BlockingQueue<Double> queue = new LinkedBlockingQueue<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread p = new Thread(stream);
		p.start();
		Thread calc = new Thread(calculator);
		calc.start();
	}

	//thread producing numbers in queue (stream) i.e. producer thread
	static Runnable stream = new Runnable(){
		public void run() {
			while(true){
			try {
				queue.put(Math.random());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	};
	
	static double largest = Double.MIN_VALUE;
	
	//thread consuming numbers from queue (stream) and putting the same in heap i.e. consumer thread.
	//heap is min heap.
	static Runnable calculator = new Runnable(){
		public void run() {
		while(true){
			Double d;
			try {
				d = queue.take();
				if(heap.size()<6){
					heap.add(d);
					
				}else{
					if(d > heap.peek() ){
						/*if(heap.size()>=5){
							heap.poll();
						}*/
						heap.poll();
						heap.add(d);
						//largest = d;
					}
				} 
				    
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		}
	};
}
