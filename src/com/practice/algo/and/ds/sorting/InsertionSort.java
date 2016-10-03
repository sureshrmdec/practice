package com.practice.algo.and.ds.sorting;

import java.util.LinkedList;

//start at index i,(start of i is 1) compare elements from i-1 till 0 until smaller element than A[i] is found

/*Partial Sorting
At this point there’s an imaginary marker somewhere in the middle of the line.
(Maybe you threw a red T-shirt on the ground in front of a player.) The players to
the left of this marker are partially sorted. This means that they are sorted among
themselves; each one is taller than the person to his or her left. However, the players
aren’t necessarily in their final positions because they may still need to be moved
when previously unsorted players are inserted between them.
 */

/*Efficiency : In any case, like the other sort routines in this chapter, the insertion sort runs in
O(N^2) time for random data.*/

public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort s = new InsertionSort();
		InsertionSort.C ic = s.new C(4,"saurabh");

		int[] array = {2,1,4,2,1,6,4,9,6,2};
		s.insertionSort(array);
	}
	private String inString = "sau";
	public void insertionSort(int[] array){
		for(int i=1;i<array.length;i++){
			int key = array[i];
			int j = i-1;
			while(j>=0 && array[j] > key){
				array[j+1] = array[j];
				array[j] = key;
				j= j-1;
			}
			//array[j] = key;
		}
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
	 interface DataStructureIterator extends java.util.Iterator<Integer> { } 
	private void insertionSort(LinkedList<Integer> list){

		
	}
	private  class C{
		int a;
		String s;
		public C(int a, String s) {
			super();
			this.a = a;
			this.s = s;
			
		}
		
	}
}
