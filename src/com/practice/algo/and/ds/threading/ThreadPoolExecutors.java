package com.practice.algo.and.ds.threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExecutors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
		
		Future<Integer> f1 = threadPool.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Integer consumed = null;
				while(true){
					consumed = queue.take();
					System.out.println("Consumed "+consumed+" by "+Thread.currentThread().getName());
				}
			}
		});
		
		Future<Integer> f2 = threadPool.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Integer consumed = null;
				while(true){
					consumed = queue.take();
					System.out.println("Consumed "+consumed+" by "+Thread.currentThread().getName());
				}
			}
		});
		
		threadPool.submit(new Runnable() {
			
			@Override
			public void run() {
				int i =0;
				while(true){
					try {
						//This method takes lock on a queue and immidiately release it after enqueueing
						//OR release the lock immidiately if queue in full and goes to waiting state calling await()..
						queue.put(i);
						System.out.println("Produced"+i);
						i++;
						System.out.println(Thread.currentThread().getName());
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		Future<Integer> f24 = threadPool.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Integer consumed = null;
				while(true){
					consumed = queue.take();
					System.out.println("Consumed "+consumed+" by "+Thread.currentThread().getName());
				}
			}
		});
	
		try {
			System.out.println(f1.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(f2.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(f24.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
