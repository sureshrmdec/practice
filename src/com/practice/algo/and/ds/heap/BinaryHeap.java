package com.practice.algo.and.ds.heap;

public class BinaryHeap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryHeap h = new BinaryHeap();
		h.buildMaxHeap(h.arr);
	}
	int[] arr = {4,1,3,2,16,9,10,14,8,7};

	private void maxHeapify(int[] arr,int i){

		int largest = i;
		
		int left = 2*i+1;
		int right = 2*i+2;
		
		//left child	
		if(left <= arr.length-1 && arr[left]>arr[i]){
			largest = left;
		}
		if(right <= arr.length-1 && arr[right]>arr[largest]){
			largest = right;
		}
		
		if(i!=largest){
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			maxHeapify(arr, largest);
		}
		
	}
	private void buildMaxHeap(int[] arr){

		for(int i=((arr.length)/2)-1;i>=0;i--){
			maxHeapify(arr, i);
		}
	}
	
}


