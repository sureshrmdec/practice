package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;

import com.practice.algo.and.ds.interviewbit.BackTracking_SubSetII;

public class BackTracking_SubsetsIIRevisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		ArrayList<Integer> numsL = new ArrayList<>();
		//numsL.add(1);
		//numsL.add(2);
		//numsL.add(2);
		//numsL.add(3);
		//numsL.add(3);
		numsL.add(1);
		numsL.add(2);
		numsL.add(2);
		numsL.add(3);

		BackTracking_SubsetsIIRevisited o = new BackTracking_SubsetsIIRevisited();

		System.out.println(o.subsets(numsL));
		System.out.println(o.subsets(numsL).size());
	}

	private ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> numsL) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		result = backtrack(numsL,0);


		return result;
	}

	private ArrayList<ArrayList<Integer>> backtrack( ArrayList<Integer> numsL, int i) {
		if(i==numsL.size()-1){
			ArrayList<ArrayList<Integer>> result2= new ArrayList<>();
			ArrayList<Integer> single = new ArrayList<>();
			single.add(numsL.get(i));
			result2.add(single);
			return result2;
		}
			
		ArrayList<Integer> single = new ArrayList<>();
		single.add(numsL.get(i));

		ArrayList<ArrayList<Integer>> result2 = backtrack(numsL, i+1);
		ArrayList<ArrayList<Integer>> nL = new ArrayList<>();
		for(ArrayList<Integer> al:result2){
			ArrayList<Integer> al2 = new ArrayList<>();
			al2.addAll(al);
			al2.add(0,numsL.get(i));
			nL.add(al2);
		}
		result2.addAll(nL);
		result2.add(single);
		return result2;
	}

}
