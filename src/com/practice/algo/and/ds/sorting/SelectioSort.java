package com.practice.algo.and.ds.sorting;

public class SelectioSort {

	/*What’s involved in the selection sort is making a pass through all the players and
	picking (or selecting, hence the name of the sort) the shortest one. This shortest
	player is then swapped with the player on the left end of the line, at position 0. Now
	the leftmost player is sorted and won’t need to be moved again. Notice that in this
	algorithm the sorted players accumulate on the left (lower indices), whereas in the
	bubble sort they accumulated on the right.
	The next time you pass down the row of players, you start at position 1, and, finding
	the minimum, swap with position 1. This process continues until all the players are
	sorted.*/
	
	/*Efficiency of Selection Sort : O(N^2)*/
	
	
	public static void main(String[] args) {
		SelectioSort s = new SelectioSort();
		int[] array = {4,2,1,6,4,9,6,2};
		s.selectionSort(array);
	}

	private void selectionSort(int[] array) {
		int swapIndex=0;
		int currIndex = -1;
		
		for(int i = swapIndex;i<array.length-1;i++){
			int key = array[i];
			currIndex = -1;
			int currSmall = array[i];
			for(int j = i+1;j<array.length;j++){
				if(array[j] < currSmall){
					currSmall = array[j];
					currIndex = j;
				}
			}
			if(currIndex!=-1){
				array[i] = array[currIndex];
				array[currIndex] = key;
			}
			
		}
	}

}
