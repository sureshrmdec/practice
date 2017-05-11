package com.practice.algo.and.ds.threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PollingThreadCountDownLatch implements Runnable{

	public static void main(String[] args) {
		PollingThreadCountDownLatch o = new PollingThreadCountDownLatch();
		o.startPolling();

	}

	boolean polling = true;

	ExecutorService threadPool = Executors.newFixedThreadPool(5);
	CountDownLatch cdl = new CountDownLatch(5);

	@Override
	public void run() {
		try {
			cdl.await();
			while(polling){
				System.out.println("Polling from Database");
				Thread.sleep(5000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void startPolling(){
	
			for(int i=0;i<5;i++){
				threadPool.submit(this);
				cdl.countDown();			
		}
	}

}
