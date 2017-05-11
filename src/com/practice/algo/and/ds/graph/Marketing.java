package com.practice.algo.and.ds.graph;

import java.util.StringTokenizer;

public class Marketing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] compete = {"1 4",
				"2",
				"3",
				"0",
		""};
		Marketing m = new Marketing();
		System.out.println(m.howMany(compete));
	}
	boolean adj[][] = new boolean[64][64];
	int color[] = new int[64];
	int n;
	boolean oddcycle = false;
	 
	public long howMany(String[] compete)
	{
	   n = compete.length;
	   for (int i = 0; i < compete.length; i++) {
	      StringTokenizer st = new StringTokenizer(compete[i], " ");
	      while (st.hasMoreTokens()) {
	         int j = Integer.parseInt(st.nextToken());
	         adj[i][j] = adj[j][i] = true;
	      }
	   }
	   for (int i = 0; i < n; i++) color[i] = 0;
	 
	   int ncomp = 0;
	 
	   // count components
	   for (int i = 0; i < n; i++)
	      if (color[i] == 0) {
	         ncomp++;
	         dfs(i, 1);
	      }
	   if (oddcycle)
	      return -1;
	 
	   long res = 1;
	   while (ncomp-- > 0) res *= 2;
	   return res;
	}
	 
	void dfs(int u, int c)
	{
	   if (color[u] != 0) {
	      if (color[u] != c) oddcycle = true;
	      return;
	   }
	   
	   color[u] = c;
	   for (int v = 0; v < n; v++)
	      if (adj[u][v])
	         dfs(v, 3 - c);
	}
}
