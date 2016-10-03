package com.practice.algo.and.ds.sorting;

public class QuickSortRevisited {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxSize = 10; // array size
		int[] arr = new int[maxSize]; // reference to array

		for(int j=0; j<maxSize; j++) // fill array with
		{ // random numbers
			int n = (int)(java.lang.Math.random()*199);
			arr[j] = n;
		}
		
		QuickSortRevisited q = new QuickSortRevisited();
		q.display(arr);
		q.quicksort(arr, 0, arr.length-1);
		q.display(arr);
	}

	private void quicksort(int[] arr,int l ,int h){
		if(l>h){
			return;
		}
		int q = partition(arr, l, h);
		quicksort(arr, l, q-1);
		quicksort(arr, q+1, h);
	}
	private int partition(int[]arr,int l,int h){
		int pivot = arr[h];
		int i = l-1; 
		for(int j=l;j<h;j++){
			if(arr[j]<=pivot){
				i = i+1;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,h);
		return i+1;
	}


	private void swap(int[] arr,int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		
	}
	
	public void display(int[] arr) // displays array contents
	{
		System.out.print("A=");
		for(int j=0; j<arr.length; j++) // for each element,
			System.out.print(arr[j] + " "); // display it
		System.out.println(" ");
	}
}
