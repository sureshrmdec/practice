package com.practice.algo.and.ds.graph;

//http://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
public class Graphs_Boggle_GeeksForGeeks {

	public static void main(String[] args) {
		String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GO","GEG"};
		char[][] boggle   = {{'G','I','Z'},
							 {'U','E','K'},
							 {'Q','S','E'}};

		doesExists(dictionary,boggle);

	}

	private static void doesExists(String[] dictionary, char[][] boggle) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[boggle.length][boggle[0].length];
		for(String s:dictionary){
			outer:
				for(int i=0;i<boggle.length;i++)
					for(int j=0;j<boggle[0].length;j++)
						if(boggle[i][j]==s.charAt(0))
							if(dfs(s,boggle,i,j,1,visited))
								break outer;
		}
	}

	private static boolean  dfs(String s, char[][] boggle,int i,int j,int pos,boolean[][] visited) {

		if(s.length()==pos){
			System.out.println("Word Found "+s);
			return true;
		}
		visited[i][j] = true;
		//U,D,R,L,UR,DR,UL,DL
		int[] dx = {-1,1,0,0,-1,1,-1, 1};
		int[] dy = { 0,0,1,-1,1,1,-1,-1};
		for(int d=0;d<dx.length;d++){
			int ii = i+ dx[d];
			int jj = j+ dy[d];

			if(ii<0 || ii>=boggle.length || jj<0 || jj>=boggle[0].length || visited[ii][jj])
				continue;
			if(boggle[ii][jj]==s.charAt(pos))
				dfs(s,boggle,ii,jj,pos+1,visited);
			
		}
		visited[i][j] = false;
		return false;

	}


}
