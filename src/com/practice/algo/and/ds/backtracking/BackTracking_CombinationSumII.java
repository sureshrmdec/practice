package com.practice.algo.and.ds.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//BackTracking_CombinationSumIIRevisited is more cleaner than this...
public class BackTracking_CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackTracking_CombinationSumII o = new BackTracking_CombinationSumII();
		Integer[] candidates = {1,2,3};
		int target = 4;
		//Integer[] candidates = {10, 1, 2, 7, 6, 1, 5};
		//int target =8;
		System.out.println(o.combinationSum(new ArrayList<>(Arrays.asList(candidates)), target));
	}


	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> candidates, int target) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> combination = new ArrayList<>();
		Collections.sort(candidates);
		backtrack(result,combination,candidates,target,0);
		return result;
		
	}
	private void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> combination,ArrayList<Integer> candidates, int target, int start) {
		// TODO Auto-generated method stub
		if(target ==0){
			ArrayList<Integer> c = new ArrayList<>();
			c.addAll(combination);
			result.add(c);
			return;
		}
		if(start>=candidates.size() || target<candidates.get(start)){
			return;
		}
		for(int i=start;i<candidates.size();i++){
			if(i>start && candidates.get(i)==candidates.get(i-1) )
				continue;
			target-=candidates.get(i);
			combination.add(candidates.get(i));
			backtrack(result, combination, candidates, target, i+1);
			target+=candidates.get(i);
			combination.remove(combination.size()-1);
		}
		
	}

}
