package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class BackTracking_AllUniquePermutations {

	public static void main(String[] args) {
		Integer[] ar = {0,0,0,1,2};
		BackTracking_AllUniquePermutations o = new BackTracking_AllUniquePermutations();
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(ar));
		o.permute(a);
	}
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> first = new ArrayList<>();
		permuteOL(a,result,first,0);
		System.out.println(result);
		return result;

	}
	private void permuteOL(ArrayList<Integer> a, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> first,int i) {

		if(first.size()==a.size()){
			ArrayList<Integer> af = new ArrayList<Integer>(first);
			result.add(af);
			return;
		}
		int last = -1;
		for(int j=i;j<a.size();j++){
			int current = a.get(j);
			if(j>i && (current==last || current == a.get(i)))
				continue;
			swap(j,i,a);
			first.add(current);
			permuteOL(a, result, first, i+1);
			swap(i,j,a);
			last = first.remove(first.size()-1);
		}
	}
	private void swap(int i, int j, ArrayList<Integer> a) {
		int t = a.get(i);
		a.set(i, a.get(j));
		a.set(j, t);
	}
}
