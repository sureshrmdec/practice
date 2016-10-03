package com.practice.algo.and.ds.spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class InversionCount_INVCNT {

	/**
	 * @param args
	 */

	static BigInteger inversions;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			
			int n=sc.nextInt();
			inversions = BigInteger.ZERO;
			int[] a=new int[n];
			for(int j=0;j<n;j++){
				a[j] = sc.nextInt();
			}
			mergeSort(a,0,a.length-1);
			System.out.println(inversions);
		}

	}

	private static void mergeSort(int[] a,int l,int r) {

		if(l<r){
			int mid = (l+r)/2;
			mergeSort(a,l,mid);
			mergeSort(a,mid+1,r);
			merge(a,l,mid, r);
		}


	}

	private static void merge(int[] nums, int left, int mid,int right) {
		int leftLength = mid - left + 1;
		int rightLength = right - mid;
	  int[] lAr = new int[leftLength];
	  //Just for simplicity, we are creating this right array.
	  //We could use actual nums array with mid and right indexes.
	  //a place to improve memory foot print.
	  int[] rAr = new int[rightLength];
	  for (int i = 0; i < leftLength; i++) {
	    lAr[i] = nums[left + i];
	  }
	  for (int i = 0; i < rightLength; i++) {
	    rAr[i] = nums[mid + 1 + i];
	  }
	  int i = 0, j = 0, k = left;
	  while (i < leftLength && j < rightLength) {
	    if (lAr[i] <= rAr[j]) {
	      nums[k] = lAr[i];
	      inversions= inversions.add(BigInteger.valueOf(j));
	      i++;
	    } else {
	      nums[k] = rAr[j];
	      j++;
	    }
	    k++;
	  }
	  //remaining iversions, using long cast as multiplication will be out of
	  //Integer range for large inputs
	 // inversions += (long) j * (leftLength - i);
	  inversions = inversions.add(BigInteger.valueOf(j).multiply(BigInteger.valueOf(leftLength).subtract(BigInteger.valueOf(i))));
	  if (i >= leftLength) {
	    //copy remaining elements from right
	    for (; j < rightLength; j++, k++) {
	      nums[k] = rAr[j];
	    }
	  } else {
	    //copy remaining elements from left
	    for (; i < leftLength; i++, k++) {
	      nums[k] = lAr[i];
	    }
	    }
	}
}
