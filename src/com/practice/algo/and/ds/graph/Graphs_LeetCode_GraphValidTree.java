package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Graphs_LeetCode_GraphValidTree {

	public static void main(String[] args) {
		//int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
		int n = 5;
		Graphs_LeetCode_GraphValidTree o = new Graphs_LeetCode_GraphValidTree();
		System.out.println(o.validTree(n, edges));
		System.out.println(o.validTreeDFS(n, edges));

	}
	
	//Disjoint Union Set
	public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            nums[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    int find(int nums[], int i) {
        if (nums[i] == -1) 
        	return i;
        return find(nums, nums[i]);
    }
    
    
	
	
	
	//DFS
    //Note that visited marking...
    public boolean validTreeDFS(int n, int[][] edges) {
        // initialize adjacency list
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);
        
        // initialize vertices
        for (int i = 0; i < n; i++)
            adjList.add(i, new ArrayList<Integer>());
        
        // add edges    
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        
        // make sure there's no cycle
        if (hasCycle(adjList, 0, visited, -1))
            return false;
        
        // make sure all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) 
                return false;
        }
        
        return true;
    }
    
    // check if an undirected graph has cycle started from vertex u
    boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
        visited[u] = true;
        
        for (int i = 0; i < adjList.get(u).size(); i++) {
            int v = adjList.get(u).get(i);
            
            if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, v, visited, u)))
                return true;
        }
        
        return false;
    }
	
	
	
	//Wrong soln below
	
    public boolean validTree2(int n, int[][] edges) {
    	ArrayList<Integer>[] graph = (ArrayList<Integer>[])new ArrayList[n];
    	buildGraph(edges,graph);
    	for(int i=0;i<n;i++){
    		if(!checkValidity(graph,i))
        		return false;	
    	}
    	return true;
    }
	private boolean checkValidity(ArrayList<Integer>[] graph,int root) {
		boolean[] visited = new boolean[graph.length];
		boolean[] onStack = new boolean[graph.length];
		onStack[root] = true;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(root);
		while(!stack.isEmpty()){
			int top = stack.peek();
			int next = getNextChild(top,graph,visited);
			if(next != -1 && onStack[next])
				return false;
			else{
				if(next!=-1){
				stack.push(next);
				onStack[next] = true;
				}else{
					stack.pop();
					visited[top] = true;
					onStack[top] = false;
				}
			}
		}
		return true;
	}
	private int getNextChild(int top, ArrayList<Integer>[] graph,boolean[] visited) {
		ArrayList<Integer> neigbors = graph[top];
		
		for(int i=0;i<neigbors.size();i++){
			if(!visited[neigbors.get(i)])
				return neigbors.get(i);
		}
		return -1;
	}
	private void buildGraph(int[][] edges, ArrayList<Integer>[] graph) {
		for(int i = 0;i<graph.length;i++){
			graph[i] = new ArrayList<>();
		}
		for(int i = 0;i<graph.length;i++){
			graph[edges[i][0]].add(edges[i][1]);
		}
	}
}
