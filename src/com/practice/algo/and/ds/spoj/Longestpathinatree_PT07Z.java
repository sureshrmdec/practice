/*

You are given an unweighted, undirected tree. Write a program to output the length of the longest path (from one node to another) in that tree. The length of a path in this case is number of edges we traverse from source to destination.
Input

The first line of the input file contains one integer N --- number of nodes in the tree (0 < N <= 10000). Next N-1 lines contain N-1 edges of that tree --- Each line contains a pair (u, v) means there is an edge between node u and node v (1 <= u,v <= N).
Output

Print the length of the longest path on one line.
Example

Input:
3
1 2
2 3

Output:
2

*/
package com.practice.algo.and.ds.spoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Longestpathinatree_PT07Z {

	/**
	 * @param args
	 */
	//First do BFS and find farthest node and then DFS.
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> al;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		 al = new ArrayList<ArrayList<Integer>>();

	        for(int i = 0; i <= n; i++) {
	            al.add(new ArrayList<Integer>());
	        }
		for(int i =0;i<n-1;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			 al.get(a).add(b);
	         al.get(b).add(a);
			
		}
		visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1] = true;
		Integer s = 1;
		Integer farthes = s;
		int dist = 0;
		while(!q.isEmpty()){
			s = q.poll();
			ArrayList<Integer> ai = al.get(s);
			for(int i=0;i<ai.size();i++){
				
				int d = ai.get(i);
				if(!visited[d]){
					//Node b = new Node(d,s.dist+1);
					q.add(d);
					visited[d] = true;
					farthes = d;
			}
			
		}
			//dist++;
		}
		dist=0;
		Arrays.fill(visited, false);
		dfs(farthes,-1);
/*		Queue<Integer> qq = new LinkedList<Integer>();
		Arrays.fill(visited, false);
		qq.add(farthes);
		visited[farthes] = true;
		Integer ss = null;
		while(!qq.isEmpty()){
			Queue<Integer> iqq = new LinkedList<Integer>();
			iqq.addAll(qq);
			qq.removeAll(qq);
			while(!iqq.isEmpty()){
				ss = iqq.poll();
				ArrayList<Integer> aii = al.get(ss);
				for(int i=0;i<aii.size();i++){
					int cn = aii.get(i);
					if(!visited[cn]){
						qq.add(cn);
						visited[cn] = true;
					}
				}
				
			}
			if(qq.size()>0)
				dist++;

		}*/
	System.out.println(gc);
		
	}
	static int gc = 0;
	static boolean dfs(int i,int c){
		
		if(visited[i]){ 
			return false;
		}
		c=c+1;
		if(c>gc)
			gc =c;
		
		visited[i]=true;	
		ArrayList<Integer> aii = al.get(i);
		for(int ii=0;ii<aii.size();ii++)
        {
			int aa = aii.get(ii);
			dfs(aa,c);
        }
		
		return true;
	
		
		
	}
}
