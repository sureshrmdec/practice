package com.practice.algo.and.ds.dp;
//Awesome Problem on DFS and DP
public class DP_LeetCode_LongestIncreasingPathinaMatrix {

	public static void main(String[] args) {
		DP_LeetCode_LongestIncreasingPathinaMatrix o = new DP_LeetCode_LongestIncreasingPathinaMatrix();
		//int[][] matrix = {{6,5,4},{7,2,3},{8,1,4},{9,5,6}};
		int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
		System.out.println(o.longestIncreasingPath(matrix));

	}
	public int longestIncreasingPath(int[][] matrix) {
		int result = 0;
		int[][] dp  = new int[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				result = Math.max(result,dfs(i,j,matrix,dp));
			}
		}
		return result;
	}
	private int dfs(int i, int j, int[][] matrix, int[][] dp) {
		if(dp[i][j]!=0)
			return dp[i][j];
		
		int[] dx = {-1,0,1,0};
		int[] dy = { 0,1,0,-1};

		int mainDist = 1;
		for(int d=0;d<=3;d++){
			int ii = i + dx[d];
			int jj = j + dy[d];

			if(ii<0 || ii>=matrix.length || jj<0 || jj>=matrix[0].length || matrix[ii][jj]<=matrix[i][j]){
				continue;
			}
			int dist = 1 + dfs(ii,jj,matrix,dp);
			mainDist = Math.max(dist, mainDist);
		}
		dp[i][j] = mainDist;
		return mainDist;	

	}

}

