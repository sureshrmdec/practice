package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class BackTracking_CombinationSumRevisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackTracking_CombinationSumRevisited o = new BackTracking_CombinationSumRevisited();
		//int[] candidates = {2,2,2};
		//int target = 4;
		//int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int[] candidates = {2,2,3,5};
		int target =8;
		System.out.println(o.combinationSum(candidates, target));
	}
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> combination = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(result,combination,candidates,target,0);
		return result;
	}
	private void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> combination,int[] candidates, int target, int i) {
		
		if(target ==0){
			ArrayList<Integer> c = new ArrayList<>();
			c.addAll(combination);
			result.add(c);
			return;
		}
		if(i>=candidates.length || target<candidates[i]){
			return;
		}
		
		for(int j=i;j<candidates.length;j++){
			if(j>0 && candidates[j]==candidates[j-1]){
				continue;
			}
			target-=candidates[j];
			combination.add(candidates[j]);
			backtrack(result, combination, candidates, target, j);
			target+=candidates[j];
			combination.remove(combination.size()-1);
		}
	}
}
