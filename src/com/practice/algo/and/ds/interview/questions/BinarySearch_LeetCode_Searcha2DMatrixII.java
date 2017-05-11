package com.practice.algo.and.ds.interview.questions;

public class BinarySearch_LeetCode_Searcha2DMatrixII {

	public static void main(String[] args) {

		BinarySearch_LeetCode_Searcha2DMatrixII o = new BinarySearch_LeetCode_Searcha2DMatrixII();

		int[][] matrix = { { -5 } };

		System.out.println(o.searchMatrix(matrix, -5));

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

	public boolean searchMatrix(int[][] matrix, int target) {

		int rows = matrix.length;
		int cols = matrix[0].length;

		boolean byRows = rows <= cols ? true : false;

		int si = 0;
		int sj = 0;
		int ei = byRows ? 0 : matrix.length - 1;
		int ej = byRows ? matrix[0].length - 1 : 0;

		while (si <= matrix.length - 1 && sj <= matrix[0].length - 1) {
			if (binarySearch(matrix, si, sj, ei, ej, byRows, target))
				return true;

			if (byRows) {
				si += 1;
				ei += 1;
			} else {
				sj += 1;
				ej += 1;
			}
		}

		return false;

	}

	private boolean binarySearch(int[][] matrix, int si, int sj, int ei, int ej, boolean byRows, int target) {
		// TODO Auto-generated method stub
		if (target < matrix[si][sj] || target > matrix[ei][ej])
			return false;

		while (si <= ei && sj <= ej) {
			int mid = -1;
			int mi = -1;
			int mj = -1;
			if (byRows) {
				mi = si;
				mj = (sj + ej) / 2;
				mid = matrix[mi][mj];
			} else {
				mi = (si + ei) / 2;
				mj = sj;
				mid = matrix[mi][mj];
			}
			if (mid > target) {
				if (byRows)
					ej = mj - 1;
				else {
					ei = mi - 1;
				}
			} else if (mid < target) {
				if (byRows)
					sj = mj + 1;
				else {
					si = mi + 1;
				}
			}

			if (mid == target)
				return true;
		}
		return false;
	}

}
