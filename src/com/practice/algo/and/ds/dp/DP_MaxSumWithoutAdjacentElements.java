package com.practice.algo.and.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP_MaxSumWithoutAdjacentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DP_MaxSumWithoutAdjacentElements o = new DP_MaxSumWithoutAdjacentElements();
		Integer[] a1 = {2};
		ArrayList<Integer> al1 = new ArrayList<Integer>(Arrays.asList(a1));
		
		Integer[] a2 = {7};
		ArrayList<Integer> a21 = new ArrayList<Integer>(Arrays.asList(a2));
		
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		a.add(al1);
		a.add(a21);
		

		System.out.println(o.adjacent(a));
	}


	public int adjacent(ArrayList<ArrayList<Integer>> a) {

		
		ArrayList<Integer> first = a.get(0);
		ArrayList<Integer> second = a.get(1);
		int[] dp = new int[first.size()];
		
		
		dp[0] = first.get(0)>second.get(0)?first.get(0):second.get(0);
		int max = dp[0];
		if(first.size()>1){
			dp[1] = first.get(1)>second.get(1)?first.get(1):second.get(1);
			max = Math.max(dp[0], dp[1]);
		}
		if(first.size()>2){
			int c = first.get(2)>second.get(2)?first.get(2):second.get(2);
			dp[2] = c + dp[0];
			max = Math.max(max, dp[2]);
		}
		for(int i=3;i<first.size();i++){
			int big = first.get(i)>second.get(i)?first.get(i):second.get(i); 
			if(big+dp[i-2]>big+dp[i-3]){
				dp[i] = big+dp[i-2];
			}else{
				dp[i]=big+dp[i-3];
			}
			if(dp[i] > max){
				max = dp[i];
			}
		}
		return max;
	}

}
