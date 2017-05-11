package com.practice.algo.and.ds.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs_LeetCode_WallsandGates {

	public static void main(String[] args) {
		int[][] in  = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
		Graphs_LeetCode_WallsandGates o = new Graphs_LeetCode_WallsandGates();
		o.wallsAndGates(in);
	}
    public void wallsAndGates(int[][] rooms) {
    	
    	for(int i=0;i<rooms.length;i++){
    		for(int j=0;j<rooms[0].length;j++){
        		if(rooms[i][j]==0){
        			bfs(i,j,rooms);
        		}
        	}
    	}
        
    }
    private void bfs(int i, int j,int[][] rooms) {
    	Queue<State> queue = new LinkedList<>();
    	queue.add(new State(i,j,0));
    	int[] dx = {0,1,0,-1};
    	int[] dy = {1,0,-1,0};
    	while(!queue.isEmpty()){
    		State state = queue.poll();
    		for(int d=0;d<dx.length;d++){
    			int ii = state.i+dx[d];
    			int jj = state.j+dy[d];
    			if(ii>rooms.length-1 || ii<0 || jj>rooms[0].length-1 || jj<0 || rooms[ii][jj]==-1)
    				continue;
    			if(rooms[ii][jj]<state.count+1)
    				continue;
    			rooms[ii][jj] = state.count+1;
    			queue.add(new State(ii,jj,state.count+1));
    		}
    	}
	}
	class State{
    	int i;
    	int j;
    	int count;
		public State(int i, int j, int count) {
			super();
			this.i = i;
			this.j = j;
			this.count = count;
		}
    	
    }
	
	//Awesome Soln
	//https://discuss.leetcode.com/topic/35242/benchmarks-of-dfs-and-bfs
	//Multi end bfs
	public static final int[] d = {0, 1, 0, -1, 0};

	public void wallsAndGatesLeet(int[][] rooms) {
	    if (rooms.length == 0) return;
	    int m = rooms.length, n = rooms[0].length;

	    Deque<Integer> queue = new ArrayDeque<>();
	    for (int i = 0; i < m; ++i)
	        for (int j = 0; j < n; ++j)
	            if (rooms[i][j] == 0) queue.offer(i * n + j); // Put gates in the queue // Awesome way of storing i and j

	    while (!queue.isEmpty()) {
	        int x = queue.poll();
	        int i = x / n, j = x % n;
	        for (int k = 0; k < 4; ++k) {
	            int p = i + d[k], q = j + d[k + 1]; // empty room
	            if (0 <= p && p < m && 0 <= q && q < n && rooms[p][q] == Integer.MAX_VALUE) {
	                rooms[p][q] = rooms[i][j] + 1;
	                queue.offer(p * n + q);
	            }
	        }
	    }
	}
	
	//LeetCode
	//https://discuss.leetcode.com/topic/33459/my-short-java-solution-very-easy-to-understand
	public void wallsAndGatesLeetDFS(int[][] rooms) {
	    for (int i = 0; i < rooms.length; i++)
	        for (int j = 0; j < rooms[0].length; j++)
	            if (rooms[i][j] == 0) 
	            	dfs(rooms, i, j, 0);
	}

	private void dfs(int[][] rooms, int i, int j, int d) {
	    if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;
	    rooms[i][j] = d;
	    dfs(rooms, i - 1, j, d + 1);
	    dfs(rooms, i + 1, j, d + 1);
	    dfs(rooms, i, j - 1, d + 1);
	    dfs(rooms, i, j + 1, d + 1);
	}
}
