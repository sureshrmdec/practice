package com.practice.algo.and.ds.backtracking;

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
	private void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> combination,int[] candidates, int target, int start) {

		if(target ==0){
			ArrayList<Integer> c = new ArrayList<>();
			c.addAll(combination);
			result.add(c);
			return;
		}
		if(start>=candidates.length || target<candidates[start]){
			return;
		}
		
		for(int i=start;i<candidates.length;i++){
			if(i>start && candidates[i]==candidates[i-1]){
				continue;
			}
			target-=candidates[i];
			combination.add(candidates[i]);
			backtrack(result, combination, candidates, target, i);
			target+=candidates[i];
			combination.remove(combination.size()-1);
		}
	}
}
