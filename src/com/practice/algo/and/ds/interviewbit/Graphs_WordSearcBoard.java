package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graphs_WordSearcBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	char[][] board = 	{
		  {'A','B','C','E'},
		  {'S','F','C','S'},
		  {'A','D','E','E'}};
		/*char[][] board = 	{{'A','B','C','E'},
							 {'S','F','E','S'},
							 {'A','D','E','E'}};*/
		//char[][] board = 	{{'A','B'}};
	Graphs_WordSearcBoard o = new Graphs_WordSearcBoard();
	//System.out.println(o.wordExists(board,"ABCCED"));
	
	List<String> boardL = new ArrayList<>();
	boardL.add("ABCE");
	boardL.add("SFCS");
	boardL.add("ADEE");
	
	String[] boardArr =  { "FEDCBECD", 
						   "FABBGACG", 
						   "CDEDGAEC", 
						   "BFFEGGBA", 
						   "FCEEAFDA", 
						   "AGFADEAC", 
						   "ADGDCBAA", 
						   "EAABDDFF" };
	String B = "BCDB";
	boardL = Arrays.asList(boardArr);
	
	System.out.println(o.exist(boardL,B));
	
	}

	
	public boolean exist(List<String> a, String word) {
	    int m = a.size();
	    int n = a.get(0).length();
	 
	    char[][] board = new char[m][n];
	    for(int i=0;i<a.size();i++){
	    	String s = a.get(i);
	    	for(int j=0;j<s.length();j++){
	    		board[i][j] = s.charAt(j);
	    	}
	    }
	    boolean result = false;
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	           if(dfs(board,word,i,j,0)){
	               result = true;
	           }
	        }
	    }
	 
	    return result;
	}
	 
	public boolean dfs(char[][] board, String word, int i, int j, int k){
		 int m = board.length;
		 int n = board[0].length;
	 
	    if(i<0 || j<0 || i>=m || j>=n){
	        return false;
	    }
	 
	    if(board[i][j] == word.charAt(k)){
	        char temp = board[i][j];
	        board[i][j]='#';
	        if(k==word.length()-1){
	            return true;
	        }else if(dfs(board, word, i-1, j, k+1)//up
			        ||dfs(board, word, i+1, j, k+1)//down
			        ||dfs(board, word, i, j-1, k+1)//left
			        ||dfs(board, word, i, j+1, k+1)//right
	        ){
	            return true;
	        }
	        board[i][j]=temp;
	    }
	 
	    return false;
	}
	
	
	
	
	
	
}
