package com.practice.algo.and.ds.interviewbit;

public class BinarySearch_SearchInRotatedArray {

	public static void main(String[] args) {
		int[] n = {3,1};
		int a = 1;
		System.out.println(searchInRotatedArray(n, a));

	}

	private static int searchInRotatedArray(int[] n, int a){


		int l = 0;
		int h = n.length -1;

		while(l<=h){
			int mid = (l+h)/2;
			if(n[mid]==a){
				return mid;
			}
			//left to mid is sorted
			if(n[l]<=n[mid]){
				if(a>=n[l] && a<n[mid]){
					h = mid-1;
				}else{
					l = mid+1;
				}
			}else {
				if(a>n[mid] && a<= n[h]){
					l = mid +1;
				}else{
					h = mid-1;
				}
			}
		}
		return -1;
	}
}
