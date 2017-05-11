package com.practice.algo.and.ds.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointers_MaxContinuousSeriesof1s {

	public static void main(String[] args) {

		Integer[] c = {1,1,0};
		//Integer[] c = {0,1,1,1};
		ArrayList<Integer> in = new ArrayList<>(Arrays.asList(c));
		TwoPointers_MaxContinuousSeriesof1s o = new TwoPointers_MaxContinuousSeriesof1s();
		System.out.println(o.getIndexes(in,2));
	
		
	}
	public ArrayList<Integer> getIndexes(ArrayList<Integer> in,int m){
		ArrayList<Integer> result = new ArrayList<>();
		int bestL=0;
		int start=0;
		int end=0;
		int count = 0;
		int maxLength = Integer.MIN_VALUE;
		for(end=0;end<in.size();end++){
			if(in.get(end)==0){
				count++;
			}
			
			if(count>m){
				int lengthOfOnes = end - start;
				if(lengthOfOnes>maxLength){
					maxLength=lengthOfOnes;
					bestL = start;
				}
				while(count>m){
					if(in.get(start)==0){
						count--;
					}
					start=start+1;
				}
			}
			
		}
		if(end - start>maxLength){
			bestL = start;
			maxLength=end - start;
		}
/*		for(int i=0;i<maxLength;i++){
			if(in.get(i+start)==0)
				result.add(i+start);
		}*/
		for(int i=0;i<maxLength;i++){
			result.add(bestL+i);
	}
		return result;
	}

}
