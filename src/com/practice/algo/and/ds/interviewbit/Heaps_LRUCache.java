package com.practice.algo.and.ds.interviewbit;

import java.util.HashMap;
import java.util.LinkedList;

public class Heaps_LRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//5 1 S 2 1 G 2 S 3 2 G 2 G 3
		Heaps_LRUCache o = new Heaps_LRUCache(5);
		o.set(2, 1);
		o.get(2);
		o.set(3, 2);
		o.get(2);
		o.get(3);
		o.set(8, 13);
		o.set(2, 8); 
		
		o.set(14, 7);
		o.set(12, 9);
		o.set(7, 10);
		
		o.set(9, 3);
		o.set(14, 15);
		o.get(7);
		o.set(4, 13);
		
		o.set(13, 7);
		

	}

    int capacity;
        
    
	private LinkedList<Integer> heap = new LinkedList<>();
	private HashMap<Integer,Integer> heapMap = new HashMap<>();
	private HashMap<Integer, Integer> cache = new HashMap<>();
    public Heaps_LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
       	if (cache.containsKey(key)) {
       	    Integer eleToUpdate = heapMap.get(key);
       	    heap.remove(eleToUpdate);
       	    heap.addFirst(eleToUpdate);
			return cache.get(key);
		}
		return -1; 
    }
    
    public void set(int key, int value) {
        
		Integer ele = new Integer(key);
		if(cache.containsKey(key)){
			Integer eleToUpdate = heapMap.get(key);
			heap.remove(eleToUpdate);
			heap.addFirst(ele);
			cache.put(key, value); //just update the value;
		}
		else if (cache.size() == capacity) {
				Integer eleToRemove = heap.removeLast();
				heapMap.remove(eleToRemove);				
				cache.remove(eleToRemove);
				cache.put(key, value);
				heap.addFirst(ele);
				heapMap.put(key, ele);
		} else {
			heap.addFirst(ele);
			heapMap.put(key,ele);
			cache.put(key, value);
		}
    }


}
