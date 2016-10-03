package com.practice.algo.and.ds.hackerrank;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class HackerRank_EvenTree {
	static Map<Integer,List<Node>> graph = new HashMap<>();
	static boolean[] visited ;
	static int[] children ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int edges = sc.nextInt();
		visited = new boolean[v+1];
		children = new int[v+1];
		for(int i =1;i<=v;i++){
			List<Node> neighbors = new LinkedList<>();
			graph.put(i, neighbors);
		}
		for(int i=0;i<edges;i++){
			int from = sc.nextInt();
			int to = sc.nextInt();
				graph.get(from).add(new Node(to));
				graph.get(to).add(new Node(from));
		}
		System.out.println(removeEdges());
		
	}
	private static int removeEdges(){
		int result=0;
		dfs(1);
		for(int i =2;i<children.length;i++){
			if(children[i]%2!=0){
				result++;
			}
		}
		
		return result;
	}
	Stack<Node> stack = new Stack<Node>();
	
	static private int dfs(int i) {
		List<Node> neighbours = graph.get(i);
		visited[i]=true;
		for(Node neighbour:neighbours){
			if(!visited[neighbour.label])
				children[i]+=dfs(neighbour.label);
		}
		
		return children[i]+1;
		
		
	}

	static class Node{
		List<Node> adjacent;
		int below;
		int label;
		Node(int label){
			this.label = label;
		}
	}

}
