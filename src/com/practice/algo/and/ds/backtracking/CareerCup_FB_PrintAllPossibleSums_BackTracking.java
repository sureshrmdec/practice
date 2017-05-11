package com.practice.algo.and.ds.backtracking;

import java.util.ArrayList;

public class CareerCup_FB_PrintAllPossibleSums_BackTracking {

	public static void main(String[] args) {
		printAllPossibleSums(0, 5, 1, new ArrayList<Integer>());

	}
	
	private static void printAllPossibleSums(int sumsoFar,int N,int k,ArrayList<Integer> list){
		if(sumsoFar==N){
			System.out.println(list);
		}
		if(sumsoFar>N){
			return;
		}
		for(int i=k;i<N;i++){
			ArrayList<Integer> list2 = new ArrayList<>(list);
			list2.add(i);
			printAllPossibleSums(sumsoFar+i,N,i,list2);
		}
	}

}
