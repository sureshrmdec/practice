package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking_CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackTracking_CombinationSum o = new BackTracking_CombinationSum();
		//int[] candidates = {2,2,2};
		//int target = 4;
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int target =8;
		System.out.println(o.combinationSum(candidates, target));
	}
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		backtrack(result,candidates,target,new ArrayList<>(),0);
		return result;
	}
	private boolean backtrack(ArrayList<ArrayList<Integer>> result,int[] candidates, int remaining,ArrayList<Integer> soFar,int curr) {
			if(remaining==0){
			ArrayList<Integer> copy = new ArrayList<>(soFar);
			result.add(copy);
			return  true;
		}
		if(curr>=candidates.length){
			return false;
		}
		if(remaining < candidates[curr]){
			return false;
		}

		for(int i=curr;i<candidates.length;i++){
			if(i-1>=0 && candidates[i]==candidates[i-1]){
				continue;
			}
			remaining -=  candidates[i];
			if(remaining <0){
				return false;
			}
			
			soFar.add(candidates[i]);
			backtrack(result,candidates,  remaining, soFar, i);
			soFar.remove(soFar.size()-1);
			remaining += candidates[i];
		}
		
		return  false;
	}
}
