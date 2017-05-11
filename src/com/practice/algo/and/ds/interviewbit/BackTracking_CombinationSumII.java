package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
//BackTracking_CombinationSumIIRevisited is more cleaner than this...
public class BackTracking_CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackTracking_CombinationSumII o = new BackTracking_CombinationSumII();
		//int[] candidates = {2,2,2};
		//int target = 4;
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int target =8;
		System.out.println(o.combinationSum2(candidates, target));
	}
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
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
		int lastRemoved = 0;
		for(int i=curr;i<candidates.length;i++){
			//This is to avoid duplicate.First condition is if next starting element is same as last one for which we have just computed the combinations.
			// Second Combination is used when we have already added that element in the set.For eg [2,2,2]...In this case, 2 at index 1 is already added so 2 at index 2 is not required to add.
			//It will cause duplicates.
			if(soFar.isEmpty() && i-1>=0 && candidates[i]==candidates[i-1] || (lastRemoved==candidates[i])){
				continue;
			}
			remaining -=  candidates[i];
			if(remaining <0){
				return false;
			}
			
			soFar.add(candidates[i]);
			backtrack(result,candidates,  remaining, soFar, i+1);
			lastRemoved = soFar.remove(soFar.size()-1);
			remaining += candidates[i];
			
		}
		
		return  false;
	}
}
