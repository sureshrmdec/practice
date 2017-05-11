package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Greedy_HighestProduct {

	public static void main(String[] args) {
		Integer[] numsA = {0, -1,-2,3, 100,2};
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(numsA));
		Greedy_HighestProduct o = new Greedy_HighestProduct();
		System.out.println(o.highestProduct(nums));

	}

	public int highestProduct(ArrayList<Integer> nums){
		if(nums.size()==3){
			return nums.get(nums.size()-1) * nums.get(nums.size()-2) * nums.get(nums.size()-3);
		}
		Collections.sort(nums);
		int a = 0;
		if(nums.get(0) <0 && nums.get(1)<0){
			a = nums.get(nums.size()-1) * nums.get(0) * nums.get(1);
		}
		int b = nums.get(nums.size()-1) * nums.get(nums.size()-2) * nums.get(nums.size()-3);
		
		return Math.max(a, b);
	}
}
