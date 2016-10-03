package com.practice.algo.and.ds.sorting;

public class LeetCode_Median_of_Two_Sorted_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums1 = {1,2,3};
		int[] nums2 = {3,4};
		LeetCode_Median_of_Two_Sorted_Arrays o = new LeetCode_Median_of_Two_Sorted_Arrays();
		System.out.println(o.findMedianSortedArrays(nums1, nums2));
	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		double res = 0;
		boolean isEven = false;
		int median = ((nums1.length + nums2.length)/2);
		if((nums1.length + nums2.length)%2 == 0){
			isEven = true;
			median = ((nums1.length + nums2.length)/2) ;
		}
		int[] k = new int[median+1];
		int i=0;
		int j=0;
		int m=-1;
		if(nums2.length==0){
			if(isEven){
				double d = nums1[nums1.length/2 - 1] + nums1[nums1.length/2];
				return d/2;
			}else{
				double d = nums1[nums1.length/2];
				return d;
			}
		}else if(nums1.length==0){
			if(isEven){
				double d = nums2[nums2.length/2 - 1] + nums2[nums2.length/2];
				return d/2;
			}else{
				double d = nums2[nums2.length/2];
				return d;
			}
		}
		while(i<nums1.length && j<nums2.length){

			if(nums1[i]<nums2[j]){
				k[++m] = nums1[i];
				i++;
			}else{
				k[++m] = nums2[j];
				j++;
			}
			//m++;
			if(m==median){
				//if(nums1[ii]<nums2[jj]){
					if(isEven){
						double d = k[k.length-1] + k[k.length-2];
						return d/2;
					}else{
						double d = k[k.length-1];
						return d;
					}
				
			}
		}
		if(m<median){
			if(i>=nums1.length){
				while(m<median){
					k[++m] = nums2[j];
					j++;
				}
			}else{
				while(m<median){
					k[++m] = nums1[i];
					i++;
				}
			}
		}
		if(isEven){
			double d = k[k.length-1] + k[k.length-2];
			return d/2;
		}else{
			double d = k[k.length-1];
			return d;
		}
		
	}

}
