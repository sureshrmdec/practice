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

// Also See In package com.practice.algo.and.ds.interview.questions class LeetCode_MissingNumber
public class Arrays_FirstMissingInteger {

	public static void main(String[] args) {

		Arrays_FirstMissingInteger ai = new Arrays_FirstMissingInteger();
		Integer[] in = {1,2,0};
		System.out.println(ai.firstMissingPositiveLeet(new ArrayList<Integer>(Arrays.asList(in))));
		System.out.println(ai.firstMissingPositive2(new ArrayList<Integer>(Arrays.asList(in))));

	}

	//I am going with this one!!..Same as my approach but too neat
	//https://discuss.leetcode.com/topic/2633/share-my-o-n-time-o-1-space-solution/3
	//vivek nalla
	public int firstMissingPositiveLeet(ArrayList<Integer> nums) {
		for (int i = 0; i < nums.size(); ++i)
		{
			int digit = nums.get(i);
			while (digit <= nums.size() && digit > 0 && nums.get(digit - 1) != digit)
			{
				swap(nums,digit - 1, i);
				digit = nums.get(i);
			}
		}
		for (int i = 0; i < nums.size(); ++i)
		{
			if (nums.get(i) != i + 1)
			{
				return i + 1;
			}
		}
		return nums.size() + 1;
	}

	public void swap(ArrayList<Integer> nums, int i, int j){
		if(i!=j){
			int temp = nums.get(j);
			nums.set(j, nums.get(i));
			nums.set(i, temp);
		}
	}  


	//Solved it second time...during revision..uses O(1) space...array itself
	public int firstMissingPositive2(ArrayList<Integer> nums) {
		if(nums.size()==0)
			return 1;
		for(int i=0;i<nums.size();i++){
			int currentNum = nums.get(i);
			//currentNum and index i+1 should match
			if(currentNum!=i+1){
				int tobeMatched = i+1;
				while(currentNum!=tobeMatched){
					if(currentNum<=0 || currentNum>nums.size() ){
						break;
					}
					//fwd is the number which would be next in while loop evaluation, save this in this variable
					int fwd = nums.get(currentNum-1);
					//put a marker here.
					nums.set(i, -1);
					//put this number at its correct location, also we saved that location number in 'fwd' variable.
					if(currentNum<=nums.size())
						nums.set(currentNum-1, currentNum);
					if(fwd>nums.size() || fwd<=0){
						break;
					}
					//if number at fwd is less than 0, then just put fwd at its correct location and break the loop
					if(nums.get(fwd-1)<=0){
						nums.set(fwd-1, fwd);
						break;
					}
					//assign correct values to currentNum and tobeMatched
					currentNum = fwd;
					tobeMatched = nums.get(currentNum-1);

				}
			}
		}
		//k is initialized to nums.size()+1 because if array contains all the numbers from 1 to N (N being the size of the array)
		//answer can never be zero
		int k = nums.size()+1;
		for(int i=0;i<nums.size();i++){
			if(i+1 != nums.get(i)){
				k=i+1;
				break;
			}
		}
		return k;
	}



	//Below soln is not complyng with O(1) space...
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
