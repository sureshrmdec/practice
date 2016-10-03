package com.practice.algo.and.ds.interviewbit;
//http://wlcoding.blogspot.com/2015/03/coins-in-line.html
public class DP_CoinsInALine {

	public static void main(String[] args) {
		int[] A = {8,15,3,7};
		System.out.println(calculate(A));
	}
	private static int calculate(int[] A){
		int N = A.length;
		int[][] d = new int[N][N];

		//Awesome code of filling the matrix diagonally....Too cool
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N - i; j++) {
				int r = j, c = i + j;
				if (r == c)
					d[r][c] = A[r];
				else if (r == c - 1)
					d[r][c] = Math.max(A[r], A[c]);
				else
					d[r][c] = Math.max(A[r] + Math.min(d[r + 2][c], d[r + 1][c - 1]), 
							A[c] + Math.min(d[r + 1][c - 1], d[r][c - 2]));
			}

		return d[0][N - 1];}
}
