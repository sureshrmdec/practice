package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.Stack;

public class Graphs_BlackShapes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> a = new ArrayList<>();
		a.add("OOOXOOO");
		a.add("OOXXOXO");
		a.add("OXOOOXO");
		Graphs_BlackShapes o = new  Graphs_BlackShapes();
		System.out.println(o.solve(a));

	}

	public int solve(ArrayList<String> a){
		int[][] board = new int[a.size()][a.get(0).length()];
        
        int ik = 0;
        for (String str: a) {
            for (int j = 0; j < str.length(); j++) {
            	board[ik][j] = 0;
                if (str.charAt(j) == 'X') board[ik][j] = 1;
            }
            ik++;
        }
		int result = 0;
		boolean[][] visited = new boolean[board.length][board[0].length];
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]==1 && !visited[i][j]){
					result++;
					Stack<Node> stack = new Stack<Node>();
					
					stack.push(new Node(i,j));
					while(!stack.isEmpty()){
						Node top = stack.pop();
						 if (top.x < 0 || top.x >= board.length) continue;
						 // Similar check for y
						 if (top.y < 0 || top.y >= board[0].length) continue;
						 // Check that we haven't already visited this position, as we don't want to count it twice
						 if (visited[top.x][top.y] || board[top.x][top.y]==0) {
							 continue;
						 }
						 visited[top.x][top.y] = true; // Record that we have visited this node

						 // Now we know that we have at least one empty square, then we will attempt to
						 // visit every node adjacent to this node.
						 stack.push(new Node(top.x + 1, top.y));
						 stack.push(new Node(top.x - 1, top.y));
						 stack.push(new Node(top.x, top.y + 1));
						 stack.push(new Node(top.x, top.y - 1));
					}
				}
			}
		}
		return result;
	}
	class Node{
		int x;int y;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
