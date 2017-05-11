package com.practice.algo.and.ds.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DP_QueenAttack {

	public static void main(String[] args) {
				int[][] board = {{0, 1, 0},
								 {1, 0, 0},
								 {0, 0, 1}};

				DP_QueenAttack o = new DP_QueenAttack();
				int[][] result = o.getBoard(board);
				ArrayList<String> boardAL = new ArrayList<String>();
				
				boardAL.add("0101010010");
				boardAL.add("1100000101");
				boardAL.add("0001100101");
				boardAL.add("0110000101");
				boardAL.add("0000011101");
				boardAL.add("0001001101");
				boardAL.add("0011010100");
				boardAL.add("1100000011");
				boardAL.add("0101100100");
				boardAL.add("0011000110");
				
				System.out.println(o.queenAttack(boardAL));
/*				for(int i=0;i<result.length;i++){
					for(int j=0;j<result[0].length;j++){
						System.out.print(result[i][j]);
					}
					System.out.println();
				}
*/				
	}

	 public ArrayList<ArrayList<Integer>> queenAttack(ArrayList<String> board) {
	    	ArrayList<ArrayList<Integer>> resultAL = new ArrayList<ArrayList<Integer>>();
	    	int[][] result = new int[board.size()][board.get(0).length()];
			
			int[] dx = {-1,1,0,0,-1,1,1,-1};
			int[] dy = {0,0,1,-1,1,1,-1,-1};
			
			for(int i=0;i<board.size();i++){
				for(int j=0;j<board.get(0).length();j++){
					
					if(board.get(i).charAt(j)=='1'){
						Queue<Node> queue = new LinkedList<>();
						for(int d=0;d<dx.length;d++){
							int ii = i + dx[d];
							int jj = j + dy[d];
							if(ii<0 || jj<0 || ii>=board.size() || jj>= board.get(0).length()){
								continue;
							}
							result[ii][jj]+=1;
							if(board.get(ii).charAt(jj)!='1')
								queue.add(new Node(ii,jj,dx[d],dy[d],-1));
						}
						while(!queue.isEmpty()){
							Node current = queue.poll();
							int x1 = current.x;
							int y1 = current.y;
							int d1 = current.xx;
							int d2 = current.yy;
							while(true){
								int ii = x1 + d1;
								int jj = y1 + d2;							
								if(ii<0 || jj<0 || ii>=board.size()  || jj>= board.get(0).length()){
									break;
								}
								if(board.get(ii).charAt(jj)=='1'){
									result[ii][jj]+=1;
									break;
								}
								result[ii][jj]+=1;
								x1 = ii;
								y1 = jj;
							}
						}
						
					}
				}
			}
			for(int i=0;i<result.length;i++){
				ArrayList<Integer> in = new ArrayList<Integer>();
				for(int j=0;j<result[0].length;j++){
					in.add(result[i][j]);
				}
				resultAL.add(in);
			}
			return resultAL;
			
	    }
	 
	private int[][] getBoard(int[][] board) {
		// TODO Auto-generated method stub
		int[][] result = new int[board.length][board[0].length];
		
		int[] dx = {-1,1,0,0,-1,1,1,-1};
		int[] dy = {0,0,1,-1,1,1,-1,-1};
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				
				if(board[i][j]==1){
					Queue<Node> queue = new LinkedList<>();
					for(int d=0;d<dx.length;d++){
						int ii = i + dx[d];
						int jj = j + dy[d];
						if(ii<0 || jj<0 || ii>=board.length || jj>= board[0].length){
							continue;
						}
						result[ii][jj]+=1;
						if(board[ii][jj]!=1)
							queue.add(new Node(ii,jj,dx[d],dy[d],-1));
					}
					while(!queue.isEmpty()){
						Node current = queue.poll();
						int x1 = current.x;
						int y1 = current.y;
						int d1 = current.xx;
						int d2 = current.yy;
						while(true){
							int ii = x1 + d1;
							int jj = y1 + d2;							
							if(ii<0 || jj<0 || ii>=board.length || jj>= board[0].length || board[ii][jj]==1){
								break;
							}
							result[ii][jj]+=1;
							x1 = ii;
							y1 = jj;
						}
					}
					
				}
			}
		}

		return result;
		}
	
   
	class Node{
		int x;
		int y;
		int xx;
		int yy;
		int val;
		public Node(int x, int y,int xx,int yy,int val) {
			super();
			this.x = x;
			this.y = y;
			this.xx = xx;
			this.yy = yy;
			this.val = val;
			
		}
		
	}
}


