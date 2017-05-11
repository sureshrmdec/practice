package com.practice.algo.and.ds.binarysearch;

public class FindElementIncreasingThenDecreasing {

	public static void main(String[] args) {
		int arr[] = {1, 3, 50, 10, 9, 7, 6};
		FindElementIncreasingThenDecreasing f = new FindElementIncreasingThenDecreasing();
		System.out.println(f.findMax(arr,0,arr.length-1));
	}

	private int findMax(int[] arr,int low, int high) {
		// TODO Auto-generated method stub
		/* Base Case: Only one element is present in arr[low..high]*/
		   if (low == high)
		     return arr[low];
		 
		   /* If there are two elements and first is greater then
		      the first element is maximum */
		   if ((high == low + 1) && arr[low] >= arr[high])
		      return arr[low];
		 
		   /* If there are two elements and second is greater then
		      the second element is maximum */
		   if ((high == low + 1) && arr[low] < arr[high])
		      return arr[high];
		int mid = (low+high)/2;
		
		if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
			return arr[mid];
		}
		if(arr[mid]<arr[mid+1] && arr[mid]>arr[mid-1]){ // mid is in increasing
			return findMax(arr,mid+1,high);
		}else{									// mid is in decreasing
			return findMax(arr,low,mid-1);
		}
			
	}
}
