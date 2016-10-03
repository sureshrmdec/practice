package com.practice.algo.and.ds.heap;


public class ActualPQElement<E>  implements Comparable<ActualPQElement<E>>{

	/**
	 * 
	 */
	
	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	E element;
	long timestamp;
	
	public ActualPQElement(E element){
		this.element = element;
		this.timestamp = System.nanoTime();
	}

	@Override
	public int compareTo(ActualPQElement<E> o) {
		if(o.getTimestamp() < this.getTimestamp()){
			return 1;
		}else if(o.getTimestamp() > this.getTimestamp()){
			return -1;
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println(obj);
		ActualPQElement<E> oa = (ActualPQElement<E>)obj;
		return this.getElement().equals(oa.getElement());
	}
	
}
