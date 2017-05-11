package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class BackTracking_LeetCode_FactorCombinations {

	public static void main(String[] args) {
		BackTracking_LeetCode_FactorCombinations o = new BackTracking_LeetCode_FactorCombinations();
		System.out.println(o.getFactorsL(32));
		System.out.println(o.getFactors(32));

	}
	public List<List<Integer>> getFactorsL(int n) {
		
		return getFactorsOL(n,2);
		//return result;
	}
	
	
    
	private List<List<Integer>> getFactorsOL(int n,int start) {
		List<List<Integer>> factors = new ArrayList<>();
		int sq = ((Double)Math.sqrt(n)).intValue();
		for(int i=start;i<=sq;i++){
			List<Integer> single = new ArrayList<>();
			if(n%i==0){
				single.add(i);
				single.add(n/i);
				factors.add(single);

				List<List<Integer>> ndividedByIFactors = getFactorsOL(n/i,i);
				for(List<Integer> l:ndividedByIFactors){
					l.add(i);
					factors.add(l);
				}
			}
		}
		return factors;
	}
	
	
	//The Backtracking
	//https://discuss.leetcode.com/topic/21082/my-recursive-dfs-java-solution
	public List<List<Integer>> getFactors(int n) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    helper(result, new ArrayList<Integer>(), n, 2);
	    return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
	    if (n <= 1) {
	        if (item.size() > 1) {
	            result.add(new ArrayList<Integer>(item));
	        }
	        return;
	    }
	    
	    for (int i = start; i <= n; ++i) {
	        if (n % i == 0) {
	            item.add(i);
	            helper(result, item, n/i, i);
	            item.remove(item.size()-1);
	        }
	    }
	}
	
	
	
	
}
