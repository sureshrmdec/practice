package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayDeque;
import java.util.Queue;

public class Graphs_KnightOnChessBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphs_KnightOnChessBoard o = new Graphs_KnightOnChessBoard();
		System.out.println(o.knight(4,7,2,6,2,4));
		
	}

	public int knight(int N, int M, int x1, int y1, int x2, int y2) {
		
		
		int[] dx = {-1,1,2,2,1,-1,-2,-2};
		int[] dy = {-2,-2,-1,1,2,2,1,-1};
		
		boolean[][] visited = new boolean[N+1][M+1];
		Node start = new Node(x1,y1,0);
		
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(start);
		
		while(!queue.isEmpty()){
			Node current = queue.poll();
			if(current.x<1 || current.x>N ||  current.y<1 || current.y>M){
				continue;
			}
			 if(visited[current.x][current.y]){
				 continue;
			 }
			visited[current.x][current.y]=true;
			
			if(current.x==x2 && current.y==y2){
				return current.steps;
			}
			 for(int i=0;i<8;i++){
				 Node n = new Node(current.x+dx[i],current.y+dy[i],current.steps+1);
				 System.out.println(n);
				 queue.add(n);
			 }
		}
		
		return -1;
	}
	class Node{
		int x;
		int y;
		int steps;
		Node(int x,int y,int steps){
			this.x = x;
			this.y = y;
			this.steps = steps;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "x: "+this.x + " y: "+this.y+ " Steps: "+this.steps;
		}
	}

}

