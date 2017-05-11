package com.practice.algo.and.ds.threading;

public class Jointhread {

	public static void main(String[] args) throws InterruptedException {
		Runnable rc = new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println(Thread.currentThread().getName() +" Starting" );
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " Finishing");
			}
		};
		Runnable rb = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " Starting");
				Thread t3 = new Thread(rc,"C");
				t3.start();
				try {
					t3.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + " Finishing");
				
			}
		};
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " Starting");
				Thread t2 = new Thread(rb,"B");
				t2.start();
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " Finishing");
				
			}
		};
		
		
		System.out.println(Thread.currentThread().getName() + " Starting");
		Thread t1 = new Thread(r,"A");
		t1.start();
		t1.join();
		System.out.println(Thread.currentThread().getName() + " Finishing");
		
		

	}

}
