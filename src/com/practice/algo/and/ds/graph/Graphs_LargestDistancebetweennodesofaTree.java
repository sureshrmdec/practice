package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graphs_LargestDistancebetweennodesofaTree {

	public static void main(String[] args) {
		Integer[] a = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 8, 37, 11, 14, 27, 90, 5, 11, 86, 91};
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(a));
		Graphs_LargestDistancebetweennodesofaTree o = new Graphs_LargestDistancebetweennodesofaTree();
		System.out.println(o.solve(A));
		System.out.println(o.answer);

	}
	public int solve(ArrayList<Integer> A) {
		ArrayList<Integer>[] graph = (ArrayList<Integer>[])new ArrayList[A.size()];
		buildTree(A,graph);
		helper(graph,0);
		return answer;

	}
	int answer = 0;
	private int helper(ArrayList<Integer>[] graph,int root) {
		if(graph[root].size()==0)
			return 1;
		ArrayList<Integer> neigbors = graph[root];
		int maxOne = -1;
		int maxTwo = -1;
		for(int n:neigbors){
			int dist = helper(graph, n);
			if(dist>maxOne){
				maxTwo = maxOne;
				maxOne = dist;
			}else if(dist>maxTwo)
				maxTwo = dist;
		}
		answer = Math.max(maxOne+maxTwo+1, answer);
		return maxOne+1;

	}
	private void buildTree(ArrayList<Integer> a,ArrayList<Integer>[] graph) {
		for(int i = 0;i<a.size();i++){
			graph[i] = new ArrayList<>();
		}
		for(int i = 1;i<a.size();i++){
			graph[a.get(i)].add(i);
		}
	}
}
