package com.practice.algo.and.ds.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//http://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/

public class Hashing_LeetCode_InsertionDeletionRandomInO1 {
	
	
	public static void main(String[] args) {
		Hashing_LeetCode_InsertionDeletionRandomInO1 randomSet = new Hashing_LeetCode_InsertionDeletionRandomInO1();

		// Inserts 1 to the set. Returns true as 1 was inserted successfully.
		randomSet.insert(1);

		// Returns false as 2 does not exist in the set.
		randomSet.remove(2);

		// Inserts 2 to the set, returns true. Set now contains [1,2].
		randomSet.insert(2);

		// getRandom should return either 1 or 2 randomly.
		randomSet.getRandom();

		// Removes 1 from the set, returns true. Set now contains [2].
		randomSet.remove(1);

		// 2 was already in the set, so return false.
		randomSet.insert(2);

		// Since 2 is the only number in the set, getRandom always return 2.
		randomSet.getRandom();
	}
	/** Initialize your data structure here. */
	Map<Integer,Integer> map;
	List<Integer> list;
	Random r;
    public Hashing_LeetCode_InsertionDeletionRandomInO1() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
        	return false;
        }else{
        	map.put(val, list.size());
        	list.add(val);
        	return true;
        }
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(!map.containsKey(val)){
        	return false;
        }else{
        	int index = map.get(val);
        	list.set(index,list.get(list.size()-1));
        	map.put(list.get(list.size()-1), index);
        	
        	list.remove(list.size()-1);
        	map.remove(val);
            return true;
        }
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int a = r.nextInt(list.size());
       return list.get(a);
    }

}
