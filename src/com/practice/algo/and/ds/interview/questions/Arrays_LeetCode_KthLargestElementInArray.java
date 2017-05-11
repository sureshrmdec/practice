package com.practice.algo.and.ds.interview.questions;

public class Arrays_LeetCode_KthLargestElementInArray {

	public static void main(String[] args) {
		int[] nums = {-1,-1};
		int k = 2;
		Arrays_LeetCode_KthLargestElementInArray o = new Arrays_LeetCode_KthLargestElementInArray();
		System.out.println(o.findKthLargest(nums, k));

	}
	public int findKthLargest(int[] nums, int k) {
		return quickSort(nums,k,0,nums.length-1);
	}
	private int quickSort(int[] nums, int k, int p, int r) {
		if(p>r)
			return -1;
		int q = partition(nums,p,r);
		if(q==nums.length-k)
			return nums[q];
		if(nums.length-k<q)
			return quickSort(nums, k, p, q-1);
		else
			return quickSort(nums, k, q+1, r);

	}
	private int partition(int[] nums, int p, int r) {
		// TODO Auto-generated method stub
		int i=p-1;

		for(int j=p;j<r;j++){
			if(nums[j]<nums[r]){
				i = i+1;
				swap(nums,i,j);
			}
		}
		i=i+1;
		swap(nums,i,r);

		return i;
	}
	private void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;

	}
}
