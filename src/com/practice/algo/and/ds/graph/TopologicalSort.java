package com.practice.algo.and.ds.graph;

import java.util.HashMap;
import java.util.Stack;

import com.practice.algo.and.ds.graph.Cormen_HowManyPaths.Graph;

public class TopologicalSort {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addEdge('p', 'o');
		graph.addEdge('p', 's');
		graph.addEdge('p', 'z');
		graph.addEdge('o', 'r');
		graph.addEdge('o', 'v');
		graph.addEdge('o', 's');
		graph.addEdge('s', 'r');
		graph.addEdge('r', 'u');
		graph.addEdge('r', 'y');
		graph.addEdge('y', 'v');
		resolveDependency(graph);
	}

	static HashMap<Character,Boolean> visited = new HashMap<>();
	
	private static void resolveDependency(Graph graph) {
		for(Character node:graph.edges.keySet()){
			if(!visited.containsKey(node))
				dfs(node,graph);
		}
	}

	private static void dfs(Character node,Graph graph) {
		Stack<Character> stack = new Stack();
		stack.push(node);
		while(!stack.isEmpty()){
			Character top = stack.peek();
			Character next = getNextChildren(top,graph);
			if(next!=null){
				stack.push(next);
			}else{
				Character c = stack.pop();
				System.out.println(c);
				visited.put(c, true);
			}
		}
	}
	
	private static Character getNextChildren(Character top,Graph graph) {
		if(graph.edges.get(top)!=null)
			for(Character c:graph.edges.get(top)){
				if(!visited.containsKey(c)){
					return c;
				}
			}
		return null;
	}



}
