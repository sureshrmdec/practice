package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class BackTracking_Combinations {

	public static void main(String[] args) {
		BackTracking_Combinations o = new BackTracking_Combinations();
		o.combine(4, 2);

	}
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(result,n, k,1,new ArrayList<Integer>());
		return result;
	}
	private void backtrack(List<List<Integer>> result,int n, int k, int c,ArrayList<Integer> soFar) {
		// TODO Auto-generated method stub
		
		if(k==soFar.size()){
			ArrayList<Integer> copy = new ArrayList<>(soFar);
			result.add(copy);
			return;
		}
		for(int i=c;i<=n;i++){
			soFar.add(i);
			backtrack(result, n, k, i+1,soFar);
			soFar.remove(soFar.size()-1);
		}
	}
}
