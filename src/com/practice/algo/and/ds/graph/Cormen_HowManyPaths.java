package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*22.4-2
Give a linear-time algorithm that takes as input a directed acyclic graph G D .V;E/ and 
two vertices s and t, and returns the number of simple paths from s to t in G. For example, 
the directed acyclic graph of Figure 22.8 contains exactly four simple paths from vertex p to vertex 􏰁: 
po􏰁, pory􏰁, posry􏰁, and psry􏰁.
(Your algorithm needs only to count the simple paths, not list them.)
 */
public class Cormen_HowManyPaths {

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

		countAndPrintPaths(graph,'p','v');

	}

	private static void countAndPrintPaths(Graph graph,Character source,Character dest) {

		dfs(source,dest,graph,"p");

	}

	private static void dfs(Character source,Character dest,Graph graph,String path) {

		if(source == dest){
			System.out.println(path);
			return;
		}
		ArrayList<Character> edges = graph.edges.get(source);

		if(edges!=null)
			for(int i=0;i<edges.size();i++){
				Character newSource = edges.get(i);
				dfs(newSource,dest,graph,path+newSource);
			}
	}

	static class Graph{
		HashMap<Character,ArrayList<Character>> edges = new HashMap<>();

		public void addEdge(Character u,Character v){
			if(edges.containsKey(u)){
				edges.get(u).add(v);
			}else{
				ArrayList<Character> al = new ArrayList<>();
				al.add(v);
				edges.put(u,al);
			}
		}
	}

}
