package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP_MinSumPathInTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a =  {1};
		Integer[] b =   {2,3};
		/*Integer[] c = {6,5,2};
		Integer[] d = {-8,-2,-7,3};
		Integer[] e = {-2,6,-6,-1,4};*/
		  List<ArrayList<Integer>> triangle = new ArrayList<>();
		  triangle.add(new ArrayList<>(Arrays.asList(a)));
		  triangle.add(new ArrayList<>(Arrays.asList(b)));
		/*  triangle.add(new ArrayList<>(Arrays.asList(c)));
		  triangle.add(new ArrayList<>(Arrays.asList(d)));
		  triangle.add(new ArrayList<>(Arrays.asList(e)));*/
		  DP_MinSumPathInTriangle o = new DP_MinSumPathInTriangle();
		  System.out.println(o.minimumTotal(triangle));
	}

	public int minimumTotal(List<ArrayList<Integer>> triangle) {
		int size = triangle.get(triangle.size()-1).size();
		int[][] dp = new int[size][size];
		dp[0][0] = triangle.get(0).get(0);
		int res = dp[0][0];
		for(int i=1;i<triangle.size();i++){
			if(i==triangle.size()-1){
				res = Integer.MAX_VALUE;
			}
			for(int j=0;j<triangle.get(i).size();j++){
				if(j==0){
					dp[i][j] = triangle.get(i).get(j) +dp[i-1][j];
					
				}
				else if(j==triangle.get(i).size()-1){
					dp[i][j] = triangle.get(i).get(j) +dp[i-1][j-1];
					
				}else{
				dp[i][j] = dp[i-1][j-1]<=dp[i-1][j]?triangle.get(i).get(j) +dp[i-1][j-1]:triangle.get(i).get(j) +dp[i-1][j];
				}
				if(i==triangle.size()-1){
					res = Math.min(res, dp[i][j]);
				}
				
			}	
		}
		return res;
	}
}
