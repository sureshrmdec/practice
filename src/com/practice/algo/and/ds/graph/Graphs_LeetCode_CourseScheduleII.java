package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.Stack;

public class Graphs_LeetCode_CourseScheduleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 4;
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		Graphs_LeetCode_CourseScheduleII o = new Graphs_LeetCode_CourseScheduleII();
		int[] result = o.findOrder(numCourses, prerequisites);
		for(int r :result)
			System.out.println(r);
	}
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		ArrayList<Integer>[] graph = (ArrayList<Integer>[])new ArrayList[numCourses];
		ArrayList<Integer> result = new ArrayList<Integer>(numCourses);
		buildGraph(graph,prerequisites,numCourses);
		boolean[] onStack = new boolean[numCourses];
		boolean[] visited = new boolean[numCourses];
		for(int i=0;i<numCourses;i++){
			if(!visited[i]){
				if(!dfs(i,graph,onStack,visited,result)){
					int[] r = new int[0];
					return r;
				}
			}		
		}
		int[] r = new int[numCourses];
		for(int i = 0;i<numCourses;i++){
			r[i] = result.get(i);
		}
		return r;
	}
	private boolean dfs(int i,ArrayList<Integer>[] graph,boolean[] onStack,boolean[] visited,ArrayList<Integer> result) {

		onStack[i] = true;	
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(i);
		while(!stack.isEmpty()){
			Integer top = stack.peek();
			Integer next = getNextChild(top,graph,visited);
			if(next!=null && onStack[next]){
				return false;
			}
			if(next!=null){
				onStack[next] = true;
				stack.push(next);
			}else{
				stack.pop();
				result.add(top);
				visited[top] = true;
				onStack[top] = false;
			}
		}
		return true;
	}
	private Integer getNextChild(int top, ArrayList<Integer>[] graph, boolean[] visited) {
		ArrayList<Integer> listNeighbors = graph[top];
		for(int i=0;i<listNeighbors.size();i++){
			if(!visited[listNeighbors.get(i)])
				return listNeighbors.get(i);
		}
		return null;
	}
	private void buildGraph(ArrayList<Integer>[] graph, int[][] prerequisites, int numCourses) {
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][0]].add(prerequisites[i][1]);
		}
	}
}
