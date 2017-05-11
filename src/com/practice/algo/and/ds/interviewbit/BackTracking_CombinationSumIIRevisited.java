package com.practice.algo.and.ds.interviewbit;

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
	private void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> combination,int[] candidates, int target, int i) {
		// TODO Auto-generated method stub
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
			if(j>i && candidates[j]==candidates[j-1])
				continue;
			target-=candidates[j];
			combination.add(candidates[j]);
			backtrack(result, combination, candidates, target, j+1);
			target+=candidates[j];
			combination.remove(combination.size()-1);
		}
		
	}
}
