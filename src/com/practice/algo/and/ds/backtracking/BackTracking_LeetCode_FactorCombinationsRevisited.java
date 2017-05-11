
package com.practice.algo.and.ds.backtracking;

import java.util.ArrayList;
import java.util.List;


public class BackTracking_LeetCode_FactorCombinationsRevisited {

	public static void main(String[] args) {
		BackTracking_LeetCode_FactorCombinationsRevisited o = new BackTracking_LeetCode_FactorCombinationsRevisited();
		o.getFactors(33);

	}
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		getFactorsHelper(n,2,result,new ArrayList<>()); 
		System.out.println(result);
		return result;
	}
	private void getFactorsHelper(int n, int start, List<List<Integer>> result,ArrayList<Integer> tmpList) {
		if (n == 1) {
			if (tmpList.size() > 1) {
				result.add(new ArrayList<Integer>(tmpList));
			}
			return;
		}
		for(int i=start;i<=Math.sqrt(n);i++){
			if(n%i==0){
				tmpList.add(i);
				getFactorsHelper(n/i, i, result, tmpList);
				tmpList.remove(tmpList.size()-1);
			}
		}
		int i = n; // ===> here, change 2 // Here code will reach in case when start and n are same...may be prime numbers //https://discuss.leetcode.com/topic/21082/my-recursive-dfs-java-solution/5
		tmpList.add(i);						// try running 32...and when it reaches n = 2.... then it will not go inside for loop but come at above line...
		getFactorsHelper(n/i, i, result,tmpList);
		tmpList.remove(tmpList.size()-1);
	}
}
