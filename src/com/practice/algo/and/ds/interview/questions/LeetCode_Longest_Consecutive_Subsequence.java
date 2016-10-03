package com.practice.algo.and.ds.interview.questions;

import java.util.HashSet;
import java.util.Set;

//http://www.geeksforgeeks.org/longest-consecutive-subsequence/
//Used hashing and check if current number is starting number or not
public class LeetCode_Longest_Consecutive_Subsequence {

	
	
	public static void main(String args[])
    {
        int arr[] =  {1, 9, 3, 10, 4, 20, 2};
        int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is " +
                           findLongestConseqSubseq(arr,n));
    }

	private static int findLongestConseqSubseq(int[] arr, int n) {
		int ans = 0;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<n;i++)
			set.add(arr[i]);
		
		for(int i=0;i<n;i++){
			int s = arr[i];
			//check if current element is the starting number or there exists number lower than that so wait for that number.
			if(!set.contains(arr[i]-1)){
				int res=1;
				while(true){
					if(set.contains(++s)){
						res++;
					}else{
						break;
					}
				}
				ans = Math.max(ans, res);
			}
			
		}
		return ans;
	}

}
