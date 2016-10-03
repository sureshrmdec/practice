package com.practice.algo.and.ds.interviewbit;

import java.util.HashSet;
import java.util.Set;

public class Maths_GridUniquePaths {

	public static void main(String[] args) {
		Maths_GridUniquePaths i = new Maths_GridUniquePaths();
		System.out.println(i.uniquePaths(6, 5));

	}

	public int uniquePaths(int a, int b) {
		
		Integer[][] m = new Integer[a][b];
		for(int i=0;i<b;i++){
			m[0][i]=1;
		}
		for(int i=0;i<a;i++){
			m[i][0]=1;
		}
		Set<Node> s = new HashSet<Node>();
		for(int i=1;i<a;i++){
			for(int j=1;j<b;j++){
				if(m[i][j]!=null && m[i][j]==1){
					continue;
				}else{
					m[i][j] = m[i][j-1] + m[i-1][j];
				}
				
			}
		}
		return m[a-1][b-1];
		
	}
	class Node{
		int x = 0;
		int y = 0;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}

