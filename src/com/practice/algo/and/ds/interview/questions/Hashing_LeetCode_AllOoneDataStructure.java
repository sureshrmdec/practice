package com.practice.algo.and.ds.interview.questions;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.TreeMap;
//https://discuss.leetcode.com/topic/65634/java-ac-all-strict-o-1-not-average-o-1-easy-to-read

//My soln is same...but using treemap..
public class Hashing_LeetCode_AllOoneDataStructure {

	public static void main(String[] args) {
		
		Hashing_LeetCode_AllOoneDataStructure o = new Hashing_LeetCode_AllOoneDataStructure();
		o.inc("a");
		o.inc("b");
		o.inc("b");
		o.inc("c");
		o.inc("c");
		o.inc("c");
		o.dec("b");
		o.dec("b");
		System.out.println(o.getMaxKey());
		System.out.println(o.getMinKey());

	}
	/** Initialize your data structure here. */
	HashMap<String,Integer> map;
	TreeMap<Integer,LinkedHashSet<String>> valueToKeysSetMap;
	public Hashing_LeetCode_AllOoneDataStructure() {
		map = new HashMap<>();
		valueToKeysSetMap	= new TreeMap<>();
	}

	/** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	public void inc(String key) {
		
		if(map.containsKey(key)){
			int currentValue = map.get(key);
			int updatedValue = currentValue+1;
			map.put(key, updatedValue);
			//Delete from Current value
			valueToKeysSetMap.get(currentValue).remove(key);
			if(valueToKeysSetMap.get(currentValue).size()==0){
				valueToKeysSetMap.remove(currentValue);
			}

			//Add in updated Value
			if(valueToKeysSetMap.get(updatedValue)!=null)
				valueToKeysSetMap.get(updatedValue).add(key);
			else{
				LinkedHashSet<String> set = new LinkedHashSet<>();
				set.add(key);
				valueToKeysSetMap.put(updatedValue, set);
			}
		}else{
			// Inserts a new key with value 1
			map.put(key, 1);
			if(valueToKeysSetMap.get(1)!=null)
				valueToKeysSetMap.get(1).add(key);
			else{
				LinkedHashSet<String> set = new LinkedHashSet<>();
				set.add(key);
				valueToKeysSetMap.put(1, set);
			}

		}

	}



	/** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	public void dec(String key) {
		if(!map.containsKey(key)){
			return;
		}
		//If Key's value is 1, remove it from the data structure
		int currentValue = map.get(key);
		int updatedValue = currentValue -1;
		if(updatedValue==0){
			map.remove(key);
		}
		valueToKeysSetMap.get(currentValue).remove(key);
		if(valueToKeysSetMap.get(currentValue).size()==0){
			valueToKeysSetMap.remove(currentValue);
		}
		//Add in updated Value
		if(updatedValue!=0) //Dont put zero...
		if(valueToKeysSetMap.get(updatedValue)!=null)
			valueToKeysSetMap.get(updatedValue).add(key);
		else{
			LinkedHashSet<String> set = new LinkedHashSet<>();
			set.add(key);
			valueToKeysSetMap.put(updatedValue, set);
		}
		map.put(key, updatedValue);
	}

	/** Returns one of the keys with maximal value. */
	public String getMaxKey() {
		if(valueToKeysSetMap.size()==0)
			return "";
		Entry<Integer,LinkedHashSet<String>> lastEntry = valueToKeysSetMap.lastEntry();
		return lastEntry.getValue().iterator().next();
	}

	/** Returns one of the keys with Minimal value. */
	public String getMinKey() {
		if(valueToKeysSetMap.size()==0)
			return "";
		Entry<Integer,LinkedHashSet<String>> firstEntry = valueToKeysSetMap.firstEntry();
		return firstEntry.getValue().iterator().next();
	}
}
