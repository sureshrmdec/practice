package com.practice.algo.and.ds.sorting;

//http://stackoverflow.com/questions/2572195/how-is-counting-sort-a-stable-sort
//Count Sort is a stable sort, that is it maintains the order of the input having same value. Please see above stackoverflow url comment by nybon (GOOG CSCO MSFT example)

public class CountSort_StableSort {

	public static void main(String[] args) {
		int[] A={2,5,3,0,2,3,0,3}; //input
		int k =5; //(array contains values from 0 to k)
		contSort(A,k);
	}

	private static void contSort(int[] A,int k) {
		int[] C = new int[k+1]; //Count Array
		int[] B = new int[A.length]; // Output Array
		for(int i=0;i<A.length;i++){
			C[A[i]]++;
		}
		for(int i=1;i<C.length;i++){
			C[i]+=C[i-1];
		}
		
		for(int i=A.length-1;i>=0;i--){
			B[C[A[i]]-1] = A[i];
			C[A[i]]--;
			
		}
		System.out.println();
	}
	
}
