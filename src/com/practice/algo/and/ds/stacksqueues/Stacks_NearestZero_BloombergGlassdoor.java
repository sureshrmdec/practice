package com.practice.algo.and.ds.stacksqueues;

import java.util.Arrays;
import java.util.Stack;
//https://www.glassdoor.com/Interview/Why-Bloomberg-Tell-me-about-yourself-and-what-you-do-Given-11000111-output-how-far-each-0-is-from-the-current-index-So-QTN_1969749.htm
public class Stacks_NearestZero_BloombergGlassdoor {

	public static void main(String[] args) {
		int[] nums = {1,1,0,0,0,1,1,0,0,1};
		//int[] nums = {1,1,1,1,1,1,1,0};
		Stacks_NearestZero_BloombergGlassdoor o = new Stacks_NearestZero_BloombergGlassdoor();
		o.closestZeroes2(nums);

	}
	public void closestZeroes2(int[] nums) {
		int start = -1;
		int[] result = new int[nums.length];
		Arrays.fill(result, Integer.MAX_VALUE);
		for(int i=0;i<nums.length;i++){
			
			if(nums[i]==0){
				int dist = 1;
				int j = i-1;
				while(j>=0 && result[j]>dist){
					result[j] = dist;
					dist++;
					j--;
				}
				result[i] = 0;
				start = i;
			}else{
				if(start!=-1)
					result[i] = Math.abs(i-start);
			}
		}
		for (int i = 0; i < result.length; i++)
		{
			System.out.print(result[i] + " ");
		}
	}
	public void closestZeroes(int[] nums) {
		Stack<Integer> s = new Stack();
		int existZ = 0;
		int dist = 1;
		int otherDist = 1;

		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] != 0)
				nums[i] = nums.length;
			dist = 1;
			if (existZ == 0 && nums[i] != 0)
				s.push(i + 1);
			else if (nums[i] == 0)
			{
				otherDist = 1;
				existZ = 1;
				while(!s.isEmpty() && s.peek() != 0)
				{
					int top = s.pop();
					if (dist < nums[top - 1])
						nums[top - 1] = dist;
					dist++;
				}
				s.push(0);
			}
			else if (existZ == 1)
			{
				s.push(i + 1);
				if (dist < nums[i])
					nums[i] = otherDist;
				otherDist++;
			}
		}

		for (int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i] + " ");
		}
	}
}
