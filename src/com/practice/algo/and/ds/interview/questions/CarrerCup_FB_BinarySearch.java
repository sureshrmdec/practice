package com.practice.algo.and.ds.interview.questions;

/*Given an array of ages (integers) sorted lowest to highest, output the number of occurrences for each age. 
For instance: 
[8,8,8,9,9,11,15,16,16,16] 
should output something like: 
8: 3 
9: 2 
11: 1 
15: 1 
16: 3 

This should be done in less than O(n).
*/
//https://www.careercup.com/question?id=5129701993480192
//Amazing Problem for Binary Search
public class CarrerCup_FB_BinarySearch {
	
	public static void main(String[] args) {
		int[] input = {8,8,8,9,9,11,15,16,16,16};
		CarrerCup_FB_BinarySearch o = new CarrerCup_FB_BinarySearch();
		System.out.println(count(input));
	}
	
	public static int[] count(int[] input) {
		
		int[] count = new int[input[input.length-1]+1];
		count (input, 0, input.length-1, count);
		return count;
		
	}
	private static void count(int[] input, int begin, int end, int[] count) {
		if (input[begin] == input[end]) {
			count[input[begin]] += end-begin+1;
		}
		else {
			count(input, begin, (begin+end)/2, count);
			count(input, (begin+end)/2 + 1, end, count);
		}		
	}
}
