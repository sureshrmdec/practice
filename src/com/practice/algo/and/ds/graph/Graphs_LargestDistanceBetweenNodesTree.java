package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graphs_LargestDistanceBetweenNodesTree {

	public static void main(String[] args) {
		Integer[] P = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 8, 37, 11, 14, 27, 90, 5, 11, 86, 91};
		
		Graphs_LargestDistanceBetweenNodesTree o = new Graphs_LargestDistanceBetweenNodesTree();
		System.out.println(o.solve(new ArrayList<Integer>(Arrays.asList(P))));

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
