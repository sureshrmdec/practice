package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*1 2 2 3 3

3
3 3
--------
2
2 3
2 3 3
3
3 3
--------
2
2 2
2 2 3
2 2 3 3
2 3
2 3 3
3
3 3
*/
public class BackTracking_SubSetII {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		ArrayList<Integer> numsL = new ArrayList<>();
		//numsL.add(1);
		//numsL.add(2);
		//numsL.add(2);
		//numsL.add(3);
		//numsL.add(3);
		numsL.add(5);
		numsL.add(5);
		numsL.add(5);
		numsL.add(5);

		BackTracking_SubSetII o = new BackTracking_SubSetII();

		System.out.println(o.subsets(numsL));
		System.out.println(o.subsets(numsL).size());
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

		for(ArrayList<Integer> l: subSetForRemaining){
			ArrayList<Integer> al = new ArrayList<>(l);
			al.add(0, first);
			subSet.add(al);
		}
		//This is to add sets which have already been added last time but should be continued as it is,
		// adding "first" to it will cause duplicates. 
		// For more clarity check 1 2 2 3 3. See above.Check 3 and 33 in last block.This is for that
		for(ArrayList<Integer> l: subSetForRemaining){
			if(curr+1<nums.size() && first==nums.get(curr+1)){
				if(l.get(0)!=first){
					subSet.add(l);
				}
			}
		}
		if(curr+1<nums.size() && first!=nums.get(curr+1))
			subSet.addAll(subSetForRemaining);



		return subSet;
	}
}
