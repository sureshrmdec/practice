package com.practice.algo.and.ds.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache<E> {

	private PriorityQueue<ActualPQElement<E>> heap = new PriorityQueue<>();
	private HashMap<E, String> cache = new HashMap<>();

	public void put(E s) {
		ActualPQElement<E> ele = new ActualPQElement<E>(s);
		if (cache.size() == 3) {

			if (heap.contains(ele)) {
				heap.remove(ele);
				heap.offer(ele);
				cache.put(s, "");
			} else {
				ActualPQElement<E> eleToRemove = heap.poll();
				E eR = eleToRemove.getElement();
				cache.remove(eR);
				cache.put(s, "");
				heap.offer(ele);
			}
			
		} else {
			heap.offer(ele);
			cache.put(s, "");
		}
		
	}

	public String get(E s) {
		if (cache.containsKey(s)) {
			return cache.get(s);
		}
		return null;
	}

	public static void main(String[] args) {
		LRUCache<String> cache = new LRUCache<>();
		cache.put("Saurabh");
		cache.put("Kakar");
		cache.put("Dev");
		cache.put("Saurabh");
		cache.put("Ryan");
		cache.put("Geet");
	}
}
