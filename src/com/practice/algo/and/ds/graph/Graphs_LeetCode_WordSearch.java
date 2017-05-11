package com.practice.algo.and.ds.graph;

public class Graphs_LeetCode_WordSearch {

	public static void main(String[] args) {
		char[][] board = 	
		{
		  {'A','B','C','E'},
		  {'S','F','C','S'},
		  {'A','D','E','E'}
		  };
		String word = "ABCCED";// -> returns true,
		String word2 = "SEE";//, -> returns true,
				String word3 = "ABCB";//, -> returns false.
				Graphs_LeetCode_WordSearch o = new Graphs_LeetCode_WordSearch();
				
		System.out.println(o.exist(board, word));
		System.out.println(o.exist(board, word2));
		System.out.println(o.exist(board, word3));

	}
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[0].length;j++){
        		if(dfs(board,word,i,j,0,visited))
        			return true;
        	}
    	}
    	return false;
    	
    }
    //Memory can be saved by marking the character as "#"...so u can avoid using visited
	private boolean dfs(char[][] board, String word, int i, int j, int k,boolean[][] visited) {
		
		if(k == word.length())
			return true;		
		char c = word.charAt(k);
		if(i<0 || j<0 || i> board.length-1 || j> board[0].length-1 || board[i][j]!=c || visited[i][j]){
			return false;
		}
		visited[i][j] = true;
		
		
		if(dfs(board,word,i,j+1,k+1,visited) || 
		   dfs(board,word,i+1,j,k+1,visited) || 
		   dfs(board,word,i,j-1,k+1,visited) || 
		   dfs(board,word,i-1,j,k+1,visited)){
			return true;
		} 
		visited[i][j] = false;
		return false;
	}
	
}
