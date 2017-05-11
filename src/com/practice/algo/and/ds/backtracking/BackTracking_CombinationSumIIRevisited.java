package com.practice.algo.and.ds.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BackTracking_CombinationSumIIRevisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackTracking_CombinationSumIIRevisited o = new BackTracking_CombinationSumIIRevisited();
		//int[] candidates = {2,2,2};
		//int target = 4;
		int[] candidates = {3,7,8,10,10,11,15,15,17,18,19};
		int target =33;
		System.out.println(o.combinationSum2(candidates, target));
	}
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> combination = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(result,combination,candidates,target,0);
		return result;
		
	}
	private void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> combination,int[] candidates, int target, int start) {
		// TODO Auto-generated method stub
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
			if(i>start && candidates[i]==candidates[i-1] )
				continue;
			target-=candidates[i];
			combination.add(candidates[i]);
			backtrack(result, combination, candidates, target, i+1);
			target+=candidates[i];
			combination.remove(combination.size()-1);
		}
		
	}
}
