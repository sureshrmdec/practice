package com.practice.algo.and.ds.interview.questions;

// AWESOME : https://www.careercup.com/question?id=4909367207919616
public class CareerCup_FB_InPlaceRelocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,1,0};
		relocate(A, A.length);
		for(int i:A){
			System.out.print(i+" ");
		}
	}
	public static void relocate(int[] arr,int size) {
		for(int i=0;i<size;i++) {
			arr[i] += (arr[arr[i]]%size)*size;
		}
		for(int i=0;i<size;i++) {
			arr[i] /= size;
		}
	}
}
