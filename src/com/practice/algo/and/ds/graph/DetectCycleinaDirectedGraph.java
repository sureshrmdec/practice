package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

//http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
//This program detects all the cycle
public class DetectCycleinaDirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] graph = {{0,1,1,0},{0,0,1,0},{1,0,0,1},{0,0,0,1}};
		DetectCycleinaDirectedGraph o = new DetectCycleinaDirectedGraph();
		o.isCycle(graph);
	}

	public boolean isCycle(int[][] graph){

		for(int ii=0;ii<graph.length;ii++){
			edgeDetected.put(ii, new ArrayList<Integer>());
		}
		for(int i=0;i<graph.length;i++){
			dfs(i,graph);
		}


		return false;
	}

	HashSet<Integer> visited = new HashSet<>();
	HashMap<Integer,List<Integer>> edgeDetected = new HashMap<>();

	private void dfs(int i,int[][] graph) {
		if(visited.contains(i))
			return;
		Stack<Integer> stack = new Stack<>();
		stack.add(i);
		while(!stack.isEmpty()){
			Integer top = stack.peek();
			visited.add(top);
			Integer c = getNextChildren(top,graph);
			if(c!=-1){
				if(visited.contains(c)){
					if(edgeDetected.get(top)!=null && edgeDetected.get(top).contains(c))
						continue;
					System.out.println("cycle detected");
					stack.pop();
					continue;
				}
				//add edge
				if(edgeDetected.get(top)!=null){
					List<Integer> alreadyVisitedfromTop= edgeDetected.get(top);
					alreadyVisitedfromTop.add(c);
				}else{
					List<Integer> alreadyVisitedfromTop = new ArrayList<>();
					alreadyVisitedfromTop.add(c);
					edgeDetected.put(top, alreadyVisitedfromTop);
				}
				if(!visited.contains(c))
					stack.push(c);
			}else{
				stack.pop();
			}
		}

	}

	private Integer getNextChildren(Integer top,int[][] graph) {
		// TODO Auto-generated method stub
		for(int i=0;i<graph.length;i++){
			if(graph[top][i]==1 && (!edgeDetected.get(top).contains(i)))
				return i;
		}
		return -1;
	}
}
