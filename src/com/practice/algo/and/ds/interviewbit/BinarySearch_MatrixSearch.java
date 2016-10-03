package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch_MatrixSearch {

	public static void main(String[] args) {
		BinarySearch_MatrixSearch o = new BinarySearch_MatrixSearch();
		Integer[] in1 = {2,2};
		ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(in1));
		Integer[] in2 = {2,2};
		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(in2));
		Integer[] in3 = {20,21,23,24,25};
		ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(in3));
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		a.add(a1);
		a.add(a2);
		//a.add(a3);
		System.out.println(o.searchMatrix(a, 3));

	}
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
		
		int l=0;
		int h=a.size()*a.get(0).size()-1;
		int r= a.size();
		int c = a.get(0).size();
		while(l<=h){
			int mid = (l+h)/2;
			int row = mid/c;
			int col = mid%c;
			if(a.get(row).get(col) > b){
				h = mid-1;
				
			}else if(a.get(row).get(col) < b){
				l = mid+1;
			}
			else if(a.get(row).get(col)==b){
				return 1;
			}
			
		}
		return 0;
	}
}
