package com.practice.algo.and.ds.sorting;

public class MedianOfUnSortedArray {

	/**
	 * @param args
	 */
	int[] arr = {4,5,1,2,7,8,3,6,9};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianOfUnSortedArray m = new MedianOfUnSortedArray();
		int left = 0;
		int right = m.arr.length - 1;
		int k = 4;
		
		int val = m.selectionSort(left,right,k);
		System.out.println(val);
		
	}
	private int selectionSort(int left, int right, int k) {
		// TODO Auto-generated method stub
		for(;;){
			int pivotIndex = partition2(left, right);
			
		        if((k-1)==pivotIndex)
		            return arr[pivotIndex];

		        else if((k-1)<pivotIndex){
		            right=pivotIndex-1;
		        	selectionSort(left,right,k);
		        }else
		        {
		            k= (k-1) - (pivotIndex-left+1);
		            left=pivotIndex+1;
		            selectionSort(left,right,k);
		        }
		}
		
	}
	private int partition2(int l,int h){
	
		int pivot = arr[h];
		int i = l-1;
		for(int j=l;j<=h-1;j++){
			if(arr[j]<=pivot){
				i = i+1;
				swap(i,j);
			}
		}
		swap(i+1,h);
		return i+1;
	}
	private void swap(int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		
	}
	private int partition(int[] arr,int left,int right,int pivot) {
		int leftPtr = left - 1;
		int rightPtr = right;
		while(true){
			while(leftPtr<right && arr[++leftPtr] < pivot){

			}
			while(rightPtr>left && arr[--rightPtr] > pivot){

			}
			if(leftPtr>=rightPtr){	// if pointers cross
				break;				// partition done
			}else{
				int temp;
				temp = arr[leftPtr];// A into temp
				arr[leftPtr] = arr[rightPtr]; // B into A
				arr[rightPtr] = temp;
				//		display(arr);
			}

		}
		int temp;
		temp = arr[leftPtr];// A into temp
		arr[leftPtr] = arr[right]; // B into A
		arr[right] = temp;
		display(arr);
		return leftPtr;				// return partition

	}
	public void display(int[] arr) // displays array contents
	{
		System.out.print("A=");
		for(int j=0; j<arr.length; j++) // for each element,
			System.out.print(arr[j] + " "); // display it
		System.out.println(" ");
	}
}
