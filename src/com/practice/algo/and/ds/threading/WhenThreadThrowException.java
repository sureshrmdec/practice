package com.practice.algo.and.ds.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WhenThreadThrowException {

	public static void main(String[] args) {
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				throw new RuntimeException();
			}
		};
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println();
			}
		};
		
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.submit(r1);
		pool.submit(r2);
		System.out.println("");

	}

	
	
}
