package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graphs_LeetCode_WordSearchII {

	public static void main(String[] args) {
		/*String[] word = {"aaaa","aaaa","aaaa","aaaa","bcde","fghi","jklm","nopq","rstu","vwxy","zzzz"};
		char[][] board2 = new char[word.length][word[0].length()];
		for(int i=0;i<word.length;i++){
			for(int j=0;j<word[i].length();j++){
				board2[i][j] = word[i].charAt(j);
			}
		}*/
		char[][] board = 	
			{
					{'o','a','a','n'},
					{'e','t','a','e'},
					{'i','h','k','r'},
					{'i','f','l','v'}
			};
		{

		};

		Graphs_LeetCode_WordSearchII o = new Graphs_LeetCode_WordSearchII();
		String[] words = {"oath","pea","eat","rain"};		
		System.out.println(o.findWords(board, words));


	}

	public List<String> findWords(char[][] board, String[] words) {
		TrieNode root = buildTrie(words);
		List<String> result = new LinkedList<>();
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
					dfs(board,root,i,j,result);
				}
			}
		return result;
	}

	/* when you start at i=0 and j=0 i.e. 'o', then you can either go to board[0][1] and board[1][0]...so prefix will be oa and oe respectively,
	 * but there is no word in the trie with prefix 'oe' so just return from there... and continue search from character a...
	 * Doing above improves performance
	 * 
	 */


	private void dfs(char[][] board,TrieNode root,int i,int j,List<String> result) {
		if(i<0 || j<0 || i> board.length-1 || j> board[0].length-1 || board[i][j] == '#' || root.next[board[i][j]-'a']==null){
			return;
		}
		char c = board[i][j];
		board[i][j] = '#';
		if(root.next[c-'a']!=null){
			root = root.next[c-'a'];
			if(root.word!=null){
				result.add(root.word);
				root.word = null;
			}
			dfs(board, root, i, j+1, result);
			dfs(board, root, i+1, j, result);
			dfs(board, root, i, j-1, result);
			dfs(board, root, i-1, j, result);

		}
		board[i][j] = c;
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for(String word:words){
			TrieNode current = root;
			char[] wordArr = word.toCharArray();
			for(char c:wordArr){
				TrieNode newNode = new TrieNode();
				int i = c-'a';
				if(current.next[i]==null){
					current.next[i] = newNode;
				}
				current = current.next[i];
			}
			current.word = word;
		}
		return root;
	}

	class TrieNode{
		  TrieNode[] next = new TrieNode[26];
		  String word;

	}
	
	
	
	
	
	
	
	
	
	
	
	/* This soln is based on Word Search I, and slow for the big inputs*/
	/* Dont use this...never*/
	public List<String> findWords2(char[][] board, String[] words) {
		boolean[][] visisted = new boolean[board.length][board[0].length];

		List<String> list = new ArrayList<>();
		for(String word:words){

			for(int i=0;i<board.length;i++){
				for(int j=0;j<board[0].length;j++){
					if(!list.contains(word) && dfs(board,word,i,j,0,visisted)){
						list.add(word);
						//return true;
					}
				}
			}

		}
		return list;    
	}


	private boolean dfs(char[][] board, String word, int i, int j, int k,boolean[][] visited) {

		if(k == word.length())
			return true;		
		char c = word.charAt(k);
		if(i<0 || j<0 || i> board.length-1 || j> board[0].length-1 || board[i][j]!=c || visited[i][j]){
			return false;
		}
		visited[i][j] = true;


		if(dfs(board,word,i,j+1,k+1,visited) || dfs(board,word,i+1,j,k+1,visited) || dfs(board,word,i,j-1,k+1,visited) || dfs(board,word,i-1,j,k+1,visited)){
			visited[i][j] = false;
			return true;
		} 
		visited[i][j] = false;
		return false;
	}

}
