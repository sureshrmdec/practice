package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;

public class HeapsAndMaps_DistinctNumbersinWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<Integer> countDistinct(ArrayList<Integer> arr, int k)
    {
		ArrayList<Integer> result = new ArrayList<>();
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM =
                      new HashMap<Integer, Integer>();
 
        // initialize distinct element  count for
        // current window
        int dist_count = 0;
 
        // Traverse the first window and store count
        // of every element in hash map
        for (int i = 0; i < k; i++)
        {
            if (hM.get(arr.get(i)) == null)
            {
                hM.put(arr.get(i), 1);
                dist_count++;
            }
            else
            {
               int count = hM.get(arr.get(i));
               hM.put(arr.get(i), count+1);
            }
        }
 
        // Print count of first window
        result.add(dist_count);
 
        // Traverse through the remaining array
        for (int i = k; i < arr.size(); i++)
        {
 
            // Remove first element of previous window
            // If there was only one occurrence, then
            // reduce distinct count.
            if (hM.get(arr.get(i-k)) == 1)
            {
                hM.remove(arr.get(i-k));
                dist_count--;
            }
            else // reduce count of the removed element
            {
               int count = hM.get(arr.get(i-k));
               hM.put(arr.get(i-k), count-1);
            }
 
            // Add new element of current window
            // If this element appears first time,
            // increment distinct element count
            if (hM.get(arr.get(i)) == null)
            {
                hM.put(arr.get(i), 1);
                dist_count++;
            }
            else // Increment distinct element count
            {
               int count = hM.get(arr.get(i));
               hM.put(arr.get(i), count+1);
            }
 
           // Print count of current window
            result.add(dist_count);
        }
        return result;
    }
}
