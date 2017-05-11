package com.practice.algo.and.ds.disjointdataset;

import com.practice.algo.and.ds.graph.Graphs_LeetCode_NumberOfIslands;

//http://www.programcreek.com/2014/04/leetcode-number-of-islands-java/
public class DisJoint_LeetCode_NumberOfIslands {

	public static void main(String[] args) {
		char[][] input = {{'1','1','0','0','0'},
				  {'1','1','0','0','0'},
				  {'0','0','1','0','0'},
				  {'0','0','0','1','1'}};

		DisJoint_LeetCode_NumberOfIslands o = new DisJoint_LeetCode_NumberOfIslands();
		System.out.println(o.numIslands(input));
}
	public int numIslands(char[][] grid) {
	    if(grid==null || grid.length==0 || grid[0].length==0)
	        return 0;
	 
	    int m = grid.length;
	    int n = grid[0].length;
	 
	    int[] dx={-1, 1, 0, 0};
	    int[] dy={0, 0, -1, 1};
	 
	    int[] root = new int[m*n];
	 
	    int count=0;
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	            if(grid[i][j]=='1'){
	                root[i*n+j] = i*n+j;            
	                count++;
	            }
	        }
	    }
	 
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	            if(grid[i][j]=='1'){
	                for(int k=0; k<4; k++){
	                    int x = i+dx[k];
	                    int y = j+dy[k];
	 
	                    if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]=='1'){
	                        int cRoot = getRoot(root, i*n+j);
	                        int nRoot = getRoot(root, x*n+y);
	                        if(nRoot!=cRoot){
	                            root[cRoot]=nRoot; //update previous node's root to be current
	                            count--;
	                        }
	 
	                    }
	                }
	            }
	        }
	    }
	 
	    return count;
	}
	 
	public int getRoot(int[] arr , int i){
	    while(arr[i]!=i){
	        i = arr[arr[i]];
	    }
	 
	    return i;
	}
}
