package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;

public class DP_MinSumPathinMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,2},{1,1}};
		DP_MinSumPathinMatrix o = new DP_MinSumPathinMatrix();
		o.minPathSum(grid);

	}
	public int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		for(int i =1;i<grid.length;i++){
			dp[i][0] = grid[i][0] + dp[i-1][0];
		}
		for(int i =1;i<grid[0].length;i++){
			dp[0][i] = grid[0][i] + dp[0][i-1];
		}
		for(int i=1;i<grid.length;i++){
			for(int j=1;j<grid[0].length;j++){
				
				int top = dp[i-1][j];
				int right = dp[i][j-1];
				
				dp[i][j] = Math.min(grid[i][j]+top, grid[i][j]+right);
			}
		}
    return dp[grid.length-1][grid[0].length-1];
	}
	
	public int minPathSum(ArrayList<ArrayList<Integer>> grid) {
		int[][] dp = new int[grid.size()][grid.get(0).size()];
		dp[0][0] = grid.get(0).get(0);
		for(int i =1;i<grid.size();i++){
			dp[i][0] = grid.get(i).get(0) + dp[i-1][0];
		}
		for(int i =1;i<grid.get(0).size();i++){
			dp[0][i] = grid.get(0).get(i) + dp[0][i-1];
		}
		for(int i=1;i<grid.size();i++){
			for(int j=1;j<grid.get(0).size();j++){
				
				int top = dp[i-1][j];
				int right = dp[i][j-1];
				
				dp[i][j] = Math.min(grid.get(i).get(j)+top, grid.get(i).get(j)+right);
			}
		}
    return dp[grid.size()-1][grid.get(0).size()-1];
	}
}
