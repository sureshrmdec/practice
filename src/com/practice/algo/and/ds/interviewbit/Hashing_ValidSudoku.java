package com.practice.algo.and.ds.interviewbit;

import java.util.HashSet;

public class Hashing_ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isValid(char[][] board){

		for(int i=0;i<board.length;i++){
			HashSet<Character> row = new HashSet<Character>();
			HashSet<Character> col = new HashSet<Character>();
			HashSet<Character> cube = new HashSet<Character>();
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]!='.' && !row.add(board[i][j]))
					return false;	
				if(board[i][j]!='.' && !col.add(board[j][i]))
					return false;
				int RowIndex = 3*(i/3);
	            int ColIndex = 3*(i%3);
	            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
	                return false;
				
			}
		}
		return true;
	}

}
