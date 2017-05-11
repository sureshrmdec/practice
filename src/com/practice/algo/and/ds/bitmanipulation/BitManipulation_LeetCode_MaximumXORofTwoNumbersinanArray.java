package com.practice.algo.and.ds.bitmanipulation;

import java.util.HashSet;
import java.util.Set;

public class BitManipulation_LeetCode_MaximumXORofTwoNumbersinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 10, 5, 25, 2, 8};
		BitManipulation_LeetCode_MaximumXORofTwoNumbersinanArray o = new BitManipulation_LeetCode_MaximumXORofTwoNumbersinanArray();
		o.findMaximumXOR(nums);
	}
	
//https://discuss.leetcode.com/topic/63213/java-o-n-solution-using-bit-manipulation-and-hashmap/8	
	public int findMaximumXOR(int[] nums) {
		int max = 0, mask = 0;
		 // search from left to right, find out for each bit is there 
		// two numbers that has different value
		for(int i = 31; i >= 0; i--){
			// mask contains the bits considered so far
			mask = mask | (1 << i);
			System.out.println("Mask--->>"+Integer.toBinaryString(mask));
			Set<Integer> set = new HashSet<>();   
			// store prefix of all number with right i bits discarded
			for(int num : nums){
				set.add(num & mask); 
			}
			int tmp = max | (1 << i);
			System.out.println("tmp--->>"+Integer.toBinaryString(tmp));
			System.out.println("max BEFORE--->>"+Integer.toBinaryString(max));
            // now find out if there are two prefix with different i-th bit
            // if there is, the new max should be current max with one 1 bit at i-th position, which is candidate
            // and the two prefix, say A and B, satisfies:
            // A ^ B = candidate
            // so we also have A ^ candidate = B or B ^ candidate = A
            // thus we can use this method to find out if such A and B exists in the set 

			
			for(int prefix : set){
				if(set.contains(tmp ^ prefix)) { //if(temp is the soln, then there must exists a number in the set 
					max = tmp;					//which can be derived with current prefix ^ tmp).See below example of 7,10,13
					break;
				}
			}
			System.out.println("max AFTER--->>"+Integer.toBinaryString(max));
			System.out.println("----------------------------");
			System.out.println("----------------------------");
		}
		return max;
	} 
}
/* 1010 -- 10
   0111 -- 7
  ^1101 -- 13

   1101 -- 13
   0111 -- 7
  ^1010 -- 10

   1101 -- 13
   1010 -- 10
  ^0111 -- 7   
   
*/