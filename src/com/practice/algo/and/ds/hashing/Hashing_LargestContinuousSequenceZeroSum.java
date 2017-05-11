package com.practice.algo.and.ds.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Hashing_LargestContinuousSequenceZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashing_LargestContinuousSequenceZeroSum o = new Hashing_LargestContinuousSequenceZeroSum();
		Integer[] inA = {1 ,2 ,-2 ,4 ,-4};
		ArrayList<Integer> in = new ArrayList<>(Arrays.asList(inA));

		System.out.println(o.getSequence(in));
	}

	public ArrayList<Integer> getSequence(ArrayList<Integer> in){
		
		ArrayList<Integer> result = new ArrayList<>();
		int currentSum=0;
		int startIndex = -1;
		int endIndex = -1;
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0, -1);
		for(int i=0;i<in.size();i++){
			currentSum+=in.get(i);
			if(in.get(i)==0){
				if(startIndex==-1 && endIndex==-1){
					startIndex=i;
					endIndex=i;
					continue;
				}
			}
			if(map.containsKey(currentSum)){
				int tstartIndex = map.get(currentSum)+1;
				int tendIndex = i;
				if(tendIndex-tstartIndex>endIndex-startIndex){
					startIndex=tstartIndex;
					endIndex=tendIndex;
				}
			}else{
				map.put(currentSum, i);
			}
			if(currentSum==0){
				startIndex = startIndex==-1?0:startIndex;
				endIndex = i;
			}
				
			
		}
		if(startIndex!=-1 && endIndex!=-1)
		for(int i=startIndex;i<=endIndex;i++){
			result.add(in.get(i));
		}
		return result;
	}
}
