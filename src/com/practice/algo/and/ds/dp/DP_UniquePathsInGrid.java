package com.practice.algo.and.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP_UniquePathsInGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DP_UniquePathsInGrid o = new DP_UniquePathsInGrid();
		int[][] obstacleGrid = {{0, 0},
				  {0, 0},
				  {0, 0},
						  {1, 0},
						  {0, 0}};
		//int[][] obstacleGrid = {{0,0}};
		System.out.println(o.uniquePathsWithObstacles(obstacleGrid));
		
	}

	//LeetCode
	public int uniquePaths(int m, int n) {
        
		int[][] dp = new int[m][n];
		//last columns
		for(int i=0;i<m;i++){
			dp[i][n-1] = 1;
		}
		//last row
		for(int i=0;i<n;i++){
			dp[m-1][i] = 1;
		}
		
		for(int i=m-2;i>=0;i--){
			for(int j=n-2;j>=0;j--){
				dp[i][j] = dp[i][j+1] + dp[i+1][j];
			}
		}
		return dp[0][0];
    }
	//Interview Bit
	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
		if(a.get(0).get(0)==1)
			return 0;
		
		if(a.size()==1 && a.get(0).size()==1){
			if(a.get(0).get(0)==0)
				return 1;
			else{
				return 0;
			}
		}
		int[][] dp = new int[a.size()][a.get(0).size()];
		dp[0][0] = 1;
		//first row
			for(int i=1;i<a.get(0).size();i++){
				if(a.get(0).get(i)==0 && dp[0][i-1]==1){
					dp[0][i] = 1;
				}else{
					dp[0][i] = 0;
				}
			}
			//first colum
			for(int i=1;i<a.size();i++){
				if(a.get(i).get(0)==0  && dp[i-1][0]==1){
					dp[i][0] = 1;
				}else{
					dp[i][0] = 0;
				}
			}
			for(int i=1;i<a.size();i++){
				for(int j=1;j<a.get(0).size();j++){
					if(a.get(i).get(j)==1){
						dp[i][j] = 0;
					}else{
						dp[i][j] = dp[i-1][j] + dp[i][j-1];
					}
				}
			}
		
	return dp[a.size()-1][a.get(0).size()-1];
	}
	
	//Unique Path II - Leet Code https://leetcode.com/problems/unique-paths-ii/
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid[0][0]==1)
			return 0;
		
		
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
		dp[0][0] = 1;
		//first row
			for(int i=1;i<obstacleGrid[0].length;i++){
				if(obstacleGrid[0][i]==0 && dp[0][i-1]==1){
					dp[0][i] = 1;
				}else{
					dp[0][i] = 0;
				}
			}
			//first colum
			for(int i=1;i<obstacleGrid.length;i++){
				if(obstacleGrid[i][0]==0  && dp[i-1][0]==1){
					dp[i][0] = 1;
				}else{
					dp[i][0] = 0;
				}
			}
			for(int i=1;i<obstacleGrid.length;i++){
				for(int j=1;j<obstacleGrid[0].length;j++){
					if(obstacleGrid[i][j]==1){
						continue;
					}else{
						dp[i][j] = dp[i-1][j] + dp[i][j-1];
					}
				}
			}
		
	return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
	}
}
