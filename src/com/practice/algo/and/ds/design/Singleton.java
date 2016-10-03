package com.practice.algo.and.ds.design;

public class Singleton {
	/*private static final Singleton INSTANCE = 
		new Singleton();*/

	private volatile static Singleton INSTANCE ;

	private String str;
	private int i;

	private Singleton() {

		this.str = "saurabh";
		this.i = 5;
	}

	public static synchronized final Singleton getInstance() {


		if(INSTANCE == null){
			synchronized (Singleton.class){
				if(INSTANCE == null){
					INSTANCE = new Singleton();
				}
			}
		}
		return INSTANCE;
	}
}
