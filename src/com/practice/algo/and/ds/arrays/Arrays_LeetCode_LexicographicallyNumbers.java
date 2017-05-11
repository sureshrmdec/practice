package com.practice.algo.and.ds.arrays;

import java.util.ArrayList;
import java.util.List;

public class Arrays_LeetCode_LexicographicallyNumbers {

	public static void main(String[] args) {
		Arrays_LeetCode_LexicographicallyNumbers o = new Arrays_LeetCode_LexicographicallyNumbers();
		o.lexicalOrder(6);
	}
	
	//My Soln
    public List<Integer> lexicalOrder(int n) {
    	List<Integer> result = new ArrayList<Integer>();
    	lexicalOrderHelper(n,result,1);
    	return result;
    }
	private void lexicalOrderHelper(int n, List<Integer> result, int i) {
		if(i>n)
			return;
		
		for(int start = i;start<=n;start++){
			if(i==1 && start>9)  //it should run for 1 to 9 only...as starting digits..
				return;
			if(start-i>=10) //it should add till +9...eg 10 to 19...not 20...
				return;
			result.add(start);
			lexicalOrderHelper(n, result, start*10);
		}
	}
	
	
	//Leet Soln https://discuss.leetcode.com/topic/55086/java-backtracking-solution-similar-to-subsets
	public List<Integer> lexicalOrderLeet(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (i <= n) {
                helper(result, n, i);
            }
        }
        return result;
    }
    
    private void helper(List<Integer> result, int n, int last) {
        if (last > n) {
            return;
        }
        result.add(last);
        for (int i = 0; i <= 9; i++) {
            helper(result, n, last * 10 + i);
        }
    }
	
}
