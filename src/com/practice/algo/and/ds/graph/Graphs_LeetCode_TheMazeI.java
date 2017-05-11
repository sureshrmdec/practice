package com.practice.algo.and.ds.graph;


import java.util.Stack;
//https://discuss.leetcode.com/topic/78133/simple-dfs-solution-beat-97
public class Graphs_LeetCode_TheMazeI {

	public static void main(String[] args) {
		Graphs_LeetCode_TheMazeI mz = new Graphs_LeetCode_TheMazeI();

		int[][] maze = {
				{0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0},
				{1, 1, 0, 1, 1},
				{0, 0, 0, 0, 0}
		};

		int[] start = {0,4};
		int[] dest = {4,4};

		System.out.println(mz.hasPath(maze, start, dest));

	}
	
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    	return hasPathOL(maze,start,destination);
	}
	private boolean hasPathOL(int[][] maze, int[] start, int[] destination) {
		Stack<BallState> stack = new Stack<BallState>();
		
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		visited[start[0]][start[1]] = true;
		BallState b = new BallState(start[0],start[1]);
		stack.push(b);
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		while(!stack.isEmpty()){

			BallState currentState = stack.peek();
			if(currentState.x==destination[0] && currentState.y==destination[1])
				return true;
			int direction = getNextDirection(currentState);

			if(direction==-1 ){
				stack.pop();
				continue;
			}
			int x = currentState.x;
			int y = currentState.y;
			while(true){
				int xx = x + dx[direction];
				int yy = y + dy[direction];
				if(xx<0 || yy<0 || xx>maze.length-1 || yy> maze[0].length-1 || maze[xx][yy]==1){ 
					BallState newState =new BallState(x,y);
					if( !visited[newState.x][newState.y])
						if(x!=currentState.x || y!=currentState.y){
							visited[newState.x][newState.y] = true;
							stack.push(newState);
						}
					break;
				}
				x = xx;
				y = yy;
			}
		}
		return false;
	}
	private int getNextDirection(BallState ballState){
		int d = -1;
		if(!ballState.up){
			ballState.up = true;
			return 0; 
		}
		if(!ballState.right){
			ballState.right = true;
			return 1; 
		}
		if(!ballState.down){
			ballState.down = true;
			return 2; 
		}
		if(!ballState.left){
			ballState.left = true;
			return 3; 
		}
		return d;
	}
	static class BallState{
		boolean up;
		boolean right;
		boolean down;
		boolean left;
		int x;
		int y;
		public BallState(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public BallState() {
			super();

		}
	}
    
}
