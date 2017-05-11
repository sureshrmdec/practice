package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graphs_LargestDistanceBetweenNodesTree {

	public static void main(String[] args) {
		Integer[] P = {-1, 0, 0, 0, 3};
		
		Graphs_LargestDistanceBetweenNodesTree o = new Graphs_LargestDistanceBetweenNodesTree();
		o.solve(new ArrayList<Integer>(Arrays.asList(P)));

	}
	

	

	public int solve(ArrayList<Integer> A) {
		int result = 0;
		Map<Integer,List<Integer>> graph2 = new HashMap<>();
		int start = makeGraph(A,graph2);
		int farthest = bfs(graph2.get(start));
		//bfs(farthest);
		return result;
	
	}
	private int bfs(List<Integer> list) {
		Queue<Integer> queue = new LinkedList<>();
		
		
		return 0;
	}




	private int makeGraph(ArrayList<Integer> A, Map<Integer, List<Integer>> graph2) {
		// TODO Auto-generated method stub
		int start = -1;
		for(int i=0;i<A.size();i++){
			if(A.get(i)==-1)
				start = i;
			if(graph2.containsKey(A.get(i))){
				graph2.get(A.get(i)).add(i);
			}else{
				List<Integer> neigbors = new ArrayList<>();
				neigbors.add(i);
				graph2.put(A.get(i), neigbors);
			}
		}
		return start;
	}
	

}
