package com.practice.algo.and.ds.interviewbit;

public class BinarySearch_MedianOfAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,4,5,6,7};
		int[] b = {2};
		//int[] a = {2,4,5,8,10,12,13,18};
		//int[] b = {1,3,6,7,9,15,19,21};
		System.out.println(findKth(4,a, b,0,0));
		System.out.println(findMedianSortedArrays(a, b));
	}
	// 4 6 8 10 16
	// 3 5 7 9
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int total = nums1.length+nums2.length;
	    if(total%2==0){
	        return (findKth(total/2+1, nums1, nums2, 0, 0)+findKth(total/2, nums1, nums2, 0, 0))/2.0;
	    }else{
	        return findKth(total/2+1, nums1, nums2, 0, 0);
	    }
	}
	 
	public static int findKth(int k, int[] nums1, int[] nums2, int s1, int s2){
	    if(s1>=nums1.length)
	        return nums2[s2+k-1];
	 
	    if(s2>=nums2.length)
	        return nums1[s1+k-1];
	 
	    if(k==1)
	        return Math.min(nums1[s1], nums2[s2]);
	 
	    int m1 = s1+k/2-1;
	    int m2 = s2+k/2-1;
	 
	    int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;    
	    int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;
	 
	    if(mid1<mid2){
	        return findKth(k-k/2, nums1, nums2, m1+1, s2);
	    }else{
	        return findKth(k-k/2, nums1, nums2, s1, m2+1);
	    }
	}

}
