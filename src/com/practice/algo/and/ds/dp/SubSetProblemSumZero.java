package com.practice.algo.and.ds.dp;

import java.util.Arrays;

public class SubSetProblemSumZero {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] set = {3,6,7,8};
		int k = 11;
		SubSetProblemSumZero s = new SubSetProblemSumZero();
		System.out.println(s.isSumPossible(set,k));
	}

	private Object isSumPossible(int[] set, int k) {
		// TODO Auto-generated method stub
		Arrays.sort(set); 
		
		int min = 0;
		int max = 0;
		for(int i=0;i<set.length;i++){
			if(set[i]<0){
				min+=set[i];
			}else{
				max+=set[i];
			}
		}
		
		int[][] dp = new int[set.length][];
		return null;
	}

}
