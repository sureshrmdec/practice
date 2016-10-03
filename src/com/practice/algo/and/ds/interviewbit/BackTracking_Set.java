package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackTracking_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		ArrayList<Integer> numsL = new ArrayList<>();
		numsL.add(1);
		numsL.add(2);
		numsL.add(3);
		numsL.add(4);
		BackTracking_Set o = new BackTracking_Set();
		
		System.out.println(o.subsets(numsL));
	}
	 //public static List<List<Integer>> subsets(int[] nums) {
	 public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> nums) {
		 ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		 if(nums.isEmpty()){
			 list.add(nums);
			 return list;
		 }
		 
		 Collections.sort(nums);
		 list = getSubSets(nums, 0);
		 
				ArrayList<Integer> al = new ArrayList<>();
				list.add(0,al);
			
	     return list;
	 }
	private static ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> nums,Integer curr) {
		ArrayList<ArrayList<Integer>> subSet = new ArrayList<>();
		
		if(curr==nums.size()-1){
			ArrayList<Integer> single = new ArrayList<>();
			single.add(nums.get(curr));
			subSet.add(single);
			return subSet;
		}
		

		
			int first = nums.get(curr);
			ArrayList<Integer> single = new ArrayList<>();
			single.add(first);
			subSet.add(single);
			
			ArrayList<ArrayList<Integer>>  subSetForRemaining = getSubSets(nums, curr+1);
			
			for(List<Integer> l: subSetForRemaining){
				ArrayList<Integer> al = new ArrayList<>(l);
				al.add(0, first);
				subSet.add(al);
				
			}
			
			subSet.addAll(subSetForRemaining);
			
		
		
		return subSet;
	}
}
