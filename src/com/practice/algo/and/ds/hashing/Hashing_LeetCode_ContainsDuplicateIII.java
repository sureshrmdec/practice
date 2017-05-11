package com.practice.algo.and.ds.hashing;

import java.util.TreeSet;

public class Hashing_LeetCode_ContainsDuplicateIII {

	public static void main(String[] args) {
		int[] nums = {1,7,10,13,16,14};
		Hashing_LeetCode_ContainsDuplicateIII o = new Hashing_LeetCode_ContainsDuplicateIII();
		o.containsNearbyAlmostDuplicate(nums, 3, 2);

	}
	/*
	 This problem requires to maintain a window of size k of the previous values that can be queried for value ranges. 
	 The best data structure to do that is Binary Search Tree. As a result maintaining the tree of size k will result 
	 in time complexity O(N lg K). In order to check if there exists any value of range abs(nums[i] - nums[j]) to 
	 simple queries can be executed both of time complexity O(lg K)

	 Here is the whole solution using TreeMap.
	 
	 */
	//As a result maintaining the tree of size k will result in time complexity O(N lg K)
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) { //k is window
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }
}
