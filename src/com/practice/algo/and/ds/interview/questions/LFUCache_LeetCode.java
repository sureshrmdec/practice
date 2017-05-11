package com.practice.algo.and.ds.interview.questions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeMap;

public class LFUCache_LeetCode {

	public static void main(String[] args) {
		LFUCache_LeetCode cache = new LFUCache_LeetCode(0);
		cache.put(0, 0);
		System.out.println(cache.get(0));
		/*cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.get(3);       // returns 3.
		cache.put(4, 4);    // evicts key 1.
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
		 */		
	}
	HashMap<Integer,Integer> keyCountMap = new HashMap<>();
	TreeMap<Integer,LinkedHashSet<Integer>> countKeyMap = new TreeMap<>();
	HashMap<Integer,Integer> mainKeyValueMap = new HashMap<>();
	int capacity = 0;
	public LFUCache_LeetCode(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if(!mainKeyValueMap.containsKey(key))
			return -1;
		int value = mainKeyValueMap.get(key);
		int currentFrequency = keyCountMap.get(key);
		keyCountMap.put(key, currentFrequency+1);  //update the count
		//remove from linkedhashset and reinsert
		countKeyMap.get(currentFrequency).remove(key); // delete from countKeyMap
		if(countKeyMap.get(currentFrequency).size()==0)
			countKeyMap.remove(currentFrequency);                     //remove if count gets empty
		if(countKeyMap.containsKey(currentFrequency+1)){
			countKeyMap.get(currentFrequency+1).add(key);
		}else{
			LinkedHashSet<Integer> keys = new LinkedHashSet<>();
			keys.add(key);
			countKeyMap.put(currentFrequency+1,keys);
		}
		return value;
	}

	public void put(int key, int value) {
		if(capacity==0)
			return;
		if(mainKeyValueMap.containsKey(key)){
			mainKeyValueMap.put(key,value); //update the value
			int currentFrequency = keyCountMap.get(key);
			keyCountMap.put(key, currentFrequency+1); //increment the count in keyCountMap
			countKeyMap.get(currentFrequency).remove(key); // delete from countKeyMap
			if(countKeyMap.get(currentFrequency).size()==0)
				countKeyMap.remove(currentFrequency);                     //remove if count gets empty
			if(countKeyMap.containsKey(currentFrequency+1)){
				countKeyMap.get(currentFrequency+1).add(key);
			}else{
				LinkedHashSet<Integer> keys = new LinkedHashSet<>();
				keys.add(key);
				countKeyMap.put(currentFrequency+1,keys);
			}
		}else{  
			if(mainKeyValueMap.size()==capacity && capacity>0){  //Cache is full, remove LFU item
				Integer LFUCount = countKeyMap.firstKey();
				LinkedHashSet<Integer> LFUKeys = countKeyMap.get(LFUCount);
				Iterator<Integer> it = LFUKeys.iterator();
				Integer keyToRemove = it.next();
				LFUKeys.remove(keyToRemove);

				if(countKeyMap.get(LFUCount).size()==0)
					countKeyMap.remove(LFUCount);                     //remove if count gets empty
				//add new key in countKeyMap
				if(countKeyMap.containsKey(1)){
					countKeyMap.get(1).add(key);
				}else{
					LinkedHashSet<Integer> keys = new LinkedHashSet<>();
					keys.add(key);
					countKeyMap.put(1,keys);
				}


				mainKeyValueMap.remove(keyToRemove); //remove from mainKeyValueMap
				mainKeyValueMap.put(key, value);

				keyCountMap.remove(keyToRemove);
				keyCountMap.put(key,1);
			}else{   //cache has space
				keyCountMap.put(key,1);
				mainKeyValueMap.put(key, value);
				if(countKeyMap.containsKey(1)){
					countKeyMap.get(1).add(key);
				}else{
					LinkedHashSet<Integer> keys = new LinkedHashSet<>();
					keys.add(key);
					countKeyMap.put(1,keys);
				}
			}

		}

	}
}
