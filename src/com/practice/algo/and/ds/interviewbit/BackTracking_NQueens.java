package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking_NQueens {

	public static void main(String[] args) {
		BackTracking_NQueens o = new BackTracking_NQueens();
		System.out.println(o.solveNQueens(4));

	}
	public ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		String[][] board;
		int[][] inter;

		board = new String[n][n];
		for(int h=0;h<board.length;h++){
			Arrays.fill(board[h], ".");
		}

		inter = new int[n][n];
		isPossible(result,board,0,0,inter);
		return result;
	}
	private void isPossible(ArrayList<ArrayList<String>> result, String[][] board,int i,int q,int[][] inter) {
		// TODO Auto-generated method stub
		if(q==board.length){
			ArrayList<String> list = new ArrayList<>();
			for(int k=0;k<board.length;k++){
				StringBuilder str = new StringBuilder();
				for(int m=0;m<board.length;m++){
					str.append(board[k][m] );		
				}
				list.add(str.toString());
			}
			result.add(list);
			return ;
		}
		//Place Queen at board[i][j]
		//for(int ii=0;ii<board.length;ii++){

		for(int jj=0;jj<board.length;jj++){
			if(inter[i][jj]==0){
				board[i][jj] = "Q";
				fillPathWithCrosses(i,jj,board,"+",inter);
				isPossible(result, board,i+1, q+1,inter);
				board[i][jj] = ".";
				fillPathWithCrosses(i,jj,board,"-",inter);
			}		
		}	

	}
	private void fillPathWithCrosses(int i, int j, String[][] board,String symbol,int[][] inter) {
		//fill diagnols
		int jj = j;
		for(int ii=i+1;ii<board.length && jj+1<board.length;ii++){
			jj = jj+1;
			updateInter(inter, symbol, ii, jj);
			//jj++;
		}
		jj = j;
		for(int ii=i-1;ii>=0 && jj-1>=0;ii--){
			jj = jj-1;
			updateInter(inter, symbol, ii, jj);
			//jj--;
		}
		jj=j;
		for(int ii=i-1;ii>=0 && jj+1<board.length;ii--){
			jj = jj+1;
			updateInter(inter, symbol, ii, jj);
			//jj--;
		}
		jj=j;
		for(int ii=i+1;ii<board.length && jj-1>=0;ii++){
			jj = jj-1;
			updateInter(inter, symbol, ii, jj);
			//jj--;
		}

		//fill horizontally
		jj = j;
		for(jj=j+1;jj<board.length;jj++){
			updateInter(inter, symbol, i, jj);
		}
		jj = j;
		for(jj=j-1;jj>=0;jj--){
			updateInter(inter, symbol, i, jj);
		}
		//fill verically
		for(int ii=i+1;ii<board.length;ii++){
			updateInter(inter, symbol, ii, j);
		}
		for(int ii=i-1;ii>=0;ii--){
			updateInter(inter, symbol, ii, j);
		}
	}

	void updateInter(int[][] inter,String symbol,int ii,int jj){
		if(symbol == "+")
			inter[ii][jj] = inter[ii][jj]+1;
		else{
			inter[ii][jj] = inter[ii][jj]-1;
		}
	}
}
