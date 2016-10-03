package com.practice.algo.and.ds.dp;

public class MinCostPath {

	/**
	 * @param args
	 */

/*	Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum 
	cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell.
	Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and 
	destination). You can only traverse down, right and diagonally lower cells from a given cell, i.e., 
	from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all 
	costs are positive integers.*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinCostPath m = new MinCostPath();
		int[][] board = {{1,2,3},{4,8,2},{1,5,3}};
		m.getMinCost(board);
	}

	private int getMinCost(int[][] board) {
	
		int[][] dp = new int[board.length][board[0].length];
		dp[0][0] = board[0][0];
		/* Initialize first column of total cost(tc) array */
	     for (int i = 1; i < board.length; i++)
	        dp[i][0] = dp[i-1][0] + board[i][0];
	 
	     /* Initialize first row of tc array */
	     for (int j = 1; j < board[0].length; j++)
	        dp[0][j] = dp[0][j-1] + board[0][j];
	 
		
		for(int i=1;i<board.length;i++){
			for(int j=1;j<board[0].length;j++){
				
				dp[i][j] =  Math.min(board[i][j] + dp[i-1][j-1],Math.min(board[i][j] + dp[i][j-1],board[i][j] + dp[i-1][j]));
			}	
		}
		return dp[board.length][board[0].length];
	}

}
