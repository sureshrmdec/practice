package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.Stack;

public class Graphs_LeetCode_CourseSchedule {

	public static void main(String[] args) {
		Graphs_LeetCode_CourseSchedule o = new Graphs_LeetCode_CourseSchedule();
		int numCourses = 2;
		int[][] prerequisites = {{0,1},{1,0}};
		System.out.println(o.canFinish(numCourses, prerequisites));
		// TODO Auto-generated method stub

	}
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	//int[][] graph = new int[numCourses][numCourses];
    	boolean[] onStack = new boolean[numCourses];
    	boolean[] visited = new boolean[numCourses];
    	ArrayList<Integer>[] graph = (ArrayList<Integer>[])new ArrayList[numCourses];
    	buildGraph(prerequisites,numCourses,graph);
    	for(int i=0;i<numCourses;i++){
    		if(!visited[i])
    			if(!dfs(i,graph,onStack,visited))
    				return false;
    	}
    	return true;
    }
    


	private boolean dfs(int i,ArrayList<Integer>[] graph,boolean[] onStack,boolean[] visited) {
		onStack[i] = true;
		Stack<Integer> stack = new Stack<>();
		stack.push(i);
		while(!stack.isEmpty()){
			Integer top = stack.peek();
			Integer next = getNextChildren(top,graph,visited);
			if(next!=null && onStack[next])
				return false;
			if(next!=null){
				stack.push(next);
				onStack[next] = true;
			}else{
				stack.pop();
				visited[top] = true;
				onStack[top] = false;
			}
		}
		return true;
	}
	private Integer getNextChildren(Integer top, ArrayList<Integer>[] graph,boolean[] visited) {
		// TODO Auto-generated method stub
		ArrayList<Integer> listNeighbors = graph[top];
		for(int i=0;i<listNeighbors.size();i++){
			if(!visited[listNeighbors.get(i)])
					return listNeighbors.get(i);
		}
		return null;
	}
	private void buildGraph(int[][] prerequisites,int n,ArrayList<Integer>[] graph) {
		
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < prerequisites.length; i++) {
        	graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
	}
}
