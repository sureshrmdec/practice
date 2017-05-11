package com.practice.algo.and.ds.interview.questions;


//Asked to me for my FB interviews
////https://www.glassdoor.com/Interview/Given-an-array-of-positive-integers-and-a-target-integer-find-if-there-is-a-consecutive-subarray-that-sums-to-the-target-QTN_984284.htm


/*Given an array of positive integers and a target integer   , 
find if there is a consecutive subarray that sums to the target. E.g, given {5,6,4,12}, findsum(10)=true, findsum(13)=false.*/ 
public class FB_GlassDoor_ContigousSubArrayTargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FB_GlassDoor_ContigousSubArrayTargetSum o = new FB_GlassDoor_ContigousSubArrayTargetSum();
		int[] a = {-3,-5};
		System.out.println(o.contiguousSubSequenceWithSum(a, 8));
	}
	public static boolean contiguousSubSequenceWithSum(int [] a, int sum){
		boolean result = false;
		
		int currentSum = a[0];
		int start = 0;
		for(int i=1;i<a.length;i++){
			
			while(currentSum+a[i]>sum){
				currentSum-=a[start];
				start++;
			}
			currentSum+=a[i];
			if(currentSum==sum)
				return true;
			
		}
		
		return result;
		
	}
}
