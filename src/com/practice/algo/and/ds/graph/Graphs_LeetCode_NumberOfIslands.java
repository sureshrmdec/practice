package com.practice.algo.and.ds.graph;

public class Graphs_LeetCode_NumberOfIslands {

	public static void main(String[] args) {
		char[][] input = {{'1','1','0','0','0'},
						  {'1','1','0','0','0'},
						  {'0','0','1','0','0'},
						  {'0','0','0','1','1'}};
		
		Graphs_LeetCode_NumberOfIslands o = new Graphs_LeetCode_NumberOfIslands();
		System.out.println(o.countIslands(input));
	}
	boolean[][] visited;
	public int countIslands(char[][] input){
		int result = 0;
		visited = new boolean[input.length][input[0].length];
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input[0].length;j++){
				if(input[i][j]=='1' && !visited[i][j]){
					dfs(i,j,input);
					result++;
				}
			}	
		}
		return result;
	}

	private void dfs(int i, int j, char[][] input) {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,1,-1};
		visited[i][j] = true;
		for(int d=0;d<dx.length;d++){
			int ii = i+dx[d];
			int jj = j+dy[d];
			if(ii<0 || jj<0 || ii>=input.length || jj>=input[0].length || visited[ii][jj] || input[ii][jj]=='0'){
				continue;
			}
			dfs(ii,jj,input);
		}
	}
}
