package com.practice.algo.and.ds.threading;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerBlockingQueue {

	public static void main(String[] args) {
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
		
		Runnable producer = new Runnable() {
			int i =0;
			@Override
			public void run() {
				while(true){
					try {
						//This method takes lock on a queue and immidiately release it after enqueueing
						//OR release the lock immidiately if queue in full and goes to waiting state calling await()..
						queue.put(i+"");
						System.out.println("Produced"+i);
						i++;
						System.out.println(Thread.currentThread().getName());
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		Runnable consumer = new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						//This method takes lock on a queue and immidiately release it after taking it.
						//OR release the lock immidiately if queue in empty and goes to waiting state calling await().
						String s = queue.take();
						System.out.println("Consumed "+s+" by "+Thread.currentThread().getName());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		};
		
		Thread producerT = new Thread(producer);
		Thread consumerT = new Thread(consumer);
		producerT.start();
		consumerT.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("Threads started");

	}
	

}
