package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*Given [1,2,0] return 3,

[3,4,-1,-2] return 2,

[-8, -7, -6] returns 1

But what we are really looking for is a O(n) time, O(1) space solution.

https://www.quora.com/What-is-the-algorithmic-approach-to-find-the-first-missing-positive-integer-provided-an-unsorted-integer-array-in-O-n-time-complexity-and-constant-space
*/
public class Arrays_FirstMissingInteger {

	public static void main(String[] args) {

		Arrays_FirstMissingInteger ai = new Arrays_FirstMissingInteger();
		Integer[] in = {-2,4,1,3};
		System.out.println(ai.firstMissingPositive(new ArrayList<Integer>(Arrays.asList(in))));

	}

	public int firstMissingPositive(ArrayList<Integer> nums) {
		Set<Integer> set = new HashSet<>();
		int missing = 1;
		for(int i=0;i<nums.size();i++){
			if(nums.get(i)>0){
				set.add(nums.get(i));
			}
		}
	int i=1;
		while(true){
			if(!set.contains(i)){
				break;
			}
			i++;
		}
		return i;
	}
}
