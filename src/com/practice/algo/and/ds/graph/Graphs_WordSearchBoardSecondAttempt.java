package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//this is IB version...you can use same character
public class Graphs_WordSearchBoardSecondAttempt {

	public static void main(String[] args) {
		char[][] board = 	{
				  {'A','B','C','E'},
				  {'S','F','C','S'},
				  {'A','D','E','E'}
				  };
		ArrayList<String> boardL = new ArrayList<>();
		boardL.add("FCDFFD");
		boardL.add("DEGEBA");
		boardL.add("FEDCGD");
		boardL.add("DFCECC");
		boardL.add("EEAFCF");
		boardL.add("EEBGAE");
		boardL.add("AAGCAE");
		boardL.add("BGCBFC");
		
		String B = "FCED";
		Graphs_WordSearchBoardSecondAttempt o = new Graphs_WordSearchBoardSecondAttempt();
		
		System.out.println(o.exist(boardL,B));

	}
	public int exist(ArrayList<String> a, String word) {
		char c = word.charAt(0);
		for(int i =0;i<a.size();i++){
			for(int j =0;j<a.get(0).length();j++){
				if(dfs(a,word,i,j,0))
					return 1;
			}
		}
		
		return 0;
		
	}
	private boolean dfs(ArrayList<String> a, String word, int i, int j, int k) {
		
		if(i<0 || i>= a.size() || j<0 || j>=a.get(0).length()){
			return false;
		}

		if(word.charAt(k)!=a.get(i).charAt(j)){
			return false;
		}
		if(k == word.length()-1){
			return true;
		}
		else if(dfs(a,word,i-1,j,k+1) 
				|| dfs(a,word,i,j+1,k+1) 
				|| dfs(a,word,i+1,j,k+1) 
				|| dfs(a,word,i,j-1,k+1)){
			return true;
		}
		
		return false;
	}
}
