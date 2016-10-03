package com.practice.algo.and.ds.interviewbit;

import java.util.Stack;

import com.practice.algo.and.ds.interviewbit.Graphs_BlackShapes.Node;

public class Graphs_CaptureSurroundedRegions {

	public static void main(String[] args) {
		char[][] board = {{'X', 'X', 'X', 'X'},
			{'X', 'O' ,'O', 'X'},
			{'X', 'X', 'O', 'X'},
			{'X', 'O', 'X', 'X'}};
		
		Graphs_CaptureSurroundedRegions o = new Graphs_CaptureSurroundedRegions();
		o.solve(board);
	}
	public void solve(char[][] board) {
		
		for(int i=0;i<board.length;i++){
			if(board[i][0]=='O'){
				dfs(i,0,board);
			}
			if(board[i][board[0].length-1]=='O'){
				dfs(i,board[0].length-1,board);
			}
		}
		for(int i=0;i<board[0].length;i++){
			if(board[0][i]=='O'){
				dfs(0,i,board);
			}
			if(board[board.length-1][i]=='O'){
				dfs(board.length-1,i,board);
			}
		}
		 //process the board
	    for(int i=0;i<board.length;i++){
	        for(int j=0; j<board[0].length; j++){
	            if(board[i][j] == 'O'){
	                board[i][j] = 'X';
	            }else if(board[i][j] == '#'){
	                board[i][j] = 'O';
	            }
	        }
	    }
	}
	
	
	private void dfs(int i,int j,char[][] board){
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(new Node(i,j));
		while(!stack.isEmpty()){
			Node top = stack.pop();
			 if (top.x < 0 || top.x >= board.length) continue;
			 // Similar check for y
			 if (top.y < 0 || top.y >= board[0].length) continue;
			 // Check that we haven't already visited this position, as we don't want to count it twice
			 if (board[top.x][top.y]=='#') {
				 continue;
			 }
			 if(board[top.x][top.y]=='O'){
				 board[top.x][top.y] = '#'; // Record that we have visited this node

			 // Now we know that we have at least one empty square, then we will attempt to
			 // visit every node adjacent to this node.
			 stack.push(new Node(top.x + 1, top.y));
			 stack.push(new Node(top.x - 1, top.y));
			 stack.push(new Node(top.x, top.y + 1));
			 stack.push(new Node(top.x, top.y - 1));
			 }
		}
		
		
	}
	class Node{
		int x;int y;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
