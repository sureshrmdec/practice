package com.practice.algo.and.ds.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graphs_LeetCode_TheMazeII {

	public static void main(String[] args) {
		Graphs_LeetCode_TheMazeII mz = new Graphs_LeetCode_TheMazeII();

		int[][] maze = {
				{0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0},
				{1, 1, 0, 1, 1},
				{0, 0, 0, 0, 0}
		};

		int[] start = {0,4};
		int[] dest = {4,4};

		System.out.println(mz.shortestDistance(maze, start, dest));

	}
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {

		Queue<Point> queue = new LinkedList<>();
		int[][] visited = new int[maze.length][maze[0].length];
		visited[start[0]][start[1]]=0;
		queue.add(new Point(start[0],start[1],0));
		for(int i = 0; i < maze.length; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int minDist = Integer.MAX_VALUE;
		while(!queue.isEmpty()){
			Point current = queue.poll();
			if(current.x==destination[0] && current.y==destination[1]){
				minDist = Math.min(minDist, current.steps);
				continue;
			}
			for(int d=0;d<=3;d++){
				int steps=0;
				int x = current.x;
				int y = current.y;
				while(true){
					int xx = x + dx[d];
					int yy = y + dy[d];
					if(xx<0 || yy<0 || xx>maze.length-1 || yy> maze[0].length-1 || maze[xx][yy]==1){
						if(current.steps+steps< visited[x][y]){
							if(x!=current.x || y!=current.y){
								visited[x][y] = current.steps+steps;
								queue.add(new Point(x,y,current.steps+steps));
							}
						}
						break;
					}
					steps++;
					x = xx;
					y = yy;
				}

			}

		}
		return minDist==Integer.MAX_VALUE?-1:minDist;
	}
	
	static class Point{
		int x;
		int y;
		int steps;
		public Point(int x,int y,int steps){
			this.x = x;
			this.y = y;
			this.steps = steps;
		}
	}
}
