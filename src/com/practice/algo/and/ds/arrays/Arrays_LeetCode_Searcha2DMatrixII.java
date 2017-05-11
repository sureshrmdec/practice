package com.practice.algo.and.ds.arrays;

public class Arrays_LeetCode_Searcha2DMatrixII {

	public static void main(String[] args) {

		Arrays_LeetCode_Searcha2DMatrixII o = new Arrays_LeetCode_Searcha2DMatrixII();

		int[][] matrix = {
		                  {1,   4,  7, 11, 15},
		                  {2,   5,  8, 12, 19},
		                  {3,   6,  9, 16, 22},
		                  {10, 13, 14, 17, 24},
		                  {18, 21, 23, 26, 30}
		                };

		System.out.println(o.searchMatrixAwesome(matrix, -5));

	}

	//Awesome soln
	// https://discuss.leetcode.com/topic/28277/java-short-code-o-m-n
	public boolean searchMatrixAwesome(int[][] matrix, int target) {
	    if(matrix.length == 0 || matrix[0].length == 0)
            return false;
		int m = matrix.length, n = matrix[0].length, i = 0, j = n - 1;
		while (i < m && j >= 0) {
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] < target)
				i++;
			else
				j--;
		}
		return false;
	}
}
