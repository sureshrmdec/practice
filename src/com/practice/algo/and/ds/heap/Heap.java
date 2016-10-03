package com.practice.algo.and.ds.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Heap {

	PriorityQueue<Entry> heap = new PriorityQueue<Entry>();
	
	int[] input = {1,1,1,1,1,3,3,3,3,45,5,2,3,42,342,345,5,64,56,4,3,3,3,3,21,2,1,1,11,1,33,2,2,2,2,2,2,2,2,2,7,7,7,7,7,7,7,7};
	int[] freqCoun = new int[50000];
	public static void main(String[] args) {
		Heap h = new Heap();
		
		h.getTopFive();
		System.out.println();
		
	}
	
	
	private void getTopFive() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<input.length;i++){
			Entry e = new Entry(input[i]);
			if(heap.contains(e)){
				heap.remove(e);
				heap.add(new Entry(input[i],freqCoun[input[i]]+1));
				freqCoun[input[i]] += 1;
			}else{
				heap.add(new Entry(input[i],1));
				freqCoun[input[i]] = 1;
			}
		}
		for(int i=0;i<10;i++){
			Entry e = heap.poll();
			System.out.println(e.key + "--" +e.freq );
		}
	}


	class Entry implements Comparable<Entry>{
		int key;
		int freq;
		Entry(int key){
			this.key=key;
		}
		Entry(int key,int freq){
			this.key=key;
			this.freq = freq;
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Entry e = (Entry)obj;
			if(e.key==this.key){
				return true;
			}
			else{
				return false;
			}
			
		}

		public int compareTo(Entry o) {
			// TODO Auto-generated method stub
			
			if(this.freq < o.freq){
				return 1;
			}else{
				return -1;
			}
			
		}


		public int getFreq() {
			return freq;
		}


		public void setFreq(int freq) {
			this.freq = freq;
		}
		
		
	}
}
