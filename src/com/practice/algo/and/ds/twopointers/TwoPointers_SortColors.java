package com.practice.algo.and.ds.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointers_SortColors {

	public static void main(String[] args) {
		Integer[] c = {1,0,2,1,0};
		ArrayList<Integer> colors = new ArrayList<>(Arrays.asList(c));
		TwoPointers_SortColors o = new TwoPointers_SortColors();
		System.out.println(o.sortColors(colors));
		

	}
	public ArrayList<Integer> sortColors(ArrayList<Integer> colors){

		//Quick Sort Partition as pivot as 1, r=1
		int r = 1;
		int p = 0;
		int q = colors.size()-1;
		int i = -1;
		for(int j=p;j<=q;j++){
			if(colors.get(j)<r){
				i=i+1;
				swap(i,j,colors);
			}
		}
		//Quick Sort Partition as pivot as 2, r=2
		r=2;
		p=i+1;
		q = colors.size()-1;
		for(int j=p;j<=q;j++){
			if(colors.get(j)<r){
				i=i+1;
				swap(i,j,colors);
			}
		}
		
		return colors;
	}
	private void swap(int i, int j,ArrayList<Integer> colors) {
		// TODO Auto-generated method stub
		int temp = colors.get(j);
		colors.set(j, colors.get(i));
		colors.set(i, temp);
	}

	//leet
	void sortColors(int A[], int n) {
	    int j = 0, k = n-1;
	    for (int i=0; i <= k; i++) {
	        if (A[i] == 0)
	            swap(A[i], A[j++],A);
	        else if (A[i] == 2)
	            swap(A[i--], A[k--],A);
	    }
	}
	private void swap(int i, int j,int[] colors) {
		// TODO Auto-generated method stub
		int temp = colors[j];
		colors[j] = colors[i];
		colors[i] = temp;
	}
}
