package com.practice.algo.and.ds.threading;

public class InterruptThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Status Interrupted "+Thread.interrupted());
				while(!Thread.currentThread().isInterrupted()){
					System.out.println("I am running");
				}
				System.out.println("Status Interrupted "+Thread.interrupted());
			}
		};
		
		
		Thread it = new Thread(r);
		
		it.start();
		try {
			Thread.sleep(10);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		it.interrupt();
	}

	
	
}
