package com.practice.algo.and.ds.Graphs.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Isitatree_PT07Y {

	/**
	 * @param args
	 */
	 private static ArrayList<Integer>[] grid;
	static boolean[] v;
	static int c;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		grid = new ArrayList[n+1];
		for(int i = 1; i < grid.length; i++) grid[i] = new ArrayList<Integer>();
		if(e!=n-1){
			System.out.println("NO");
			System.exit(0);
		}
		
		v = new boolean[n+1];
		for(int i=0;i<e;i++){
			int u = sc.nextInt();
			int vv = sc.nextInt();
			grid[u].add(vv);
			//grid[vv].add(u);
		}
		
		
		if(dfs(1)&& c==n){
			System.out.println("YES");	
		}else{
			System.out.println("NO");
		}
	}
	
	private static boolean dfs(int i){

		if(v[i]){ 
			return false;
		}
		v[i]=true;	
		c++;
		for(int ii : grid[i])
        {
             if(!dfs(ii)) return false;
        }
		
		return true;
	}

}
