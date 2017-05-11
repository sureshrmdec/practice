package com.practice.algo.and.ds.interview.questions;
//https://discuss.leetcode.com/topic/61324/clear-explanation-8ms-binary-search-java
/*3.1 Cut the array from left.
3.2 Try our best to make sure that the sum of numbers between each two cuts (inclusive) is large enough but still less than mid.
3.3 We'll end up with two results: either we can divide the array into more than m subarrays or we cannot.
If we can, it means that the mid value we pick is too small because we've already tried our best to make sure each part holds as many 
non-negative numbers as we can but we still have numbers left. So, it is impossible to cut the array into m parts and make sure each parts
is no larger than mid. We should increase m. 
This leads to l = mid + 1;

If we can't, it is  
either	we successfully divide the array into m parts and the sum of each part is less than mid, 
 or     we used up all numbers before we reach m. 
	    Both of them mean that we should lower mid because we need to find the minimum one. 
This leads to r = mid - 1;*/

public class BinarySearch_LeetCode_SplitArrayLargestSum {

	public static void main(String[] args) {
		int[] nums = {7,2,5,10,8};
		int m = 2;
		BinarySearch_LeetCode_SplitArrayLargestSum o = new BinarySearch_LeetCode_SplitArrayLargestSum();
		o.splitArray(nums, m);
	}
	public int splitArray(int[] nums, int m) {
        int max = 0; long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return (int)sum;
        //binary search
        long low = max; long high = sum;
        while (low <= high) {
            long mid = (low + high)/ 2;
            if (valid(mid, nums, m)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)low;
    }
    public boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
