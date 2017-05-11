package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Graphs_CommutableIslands {

	public static void main(String[] args) {
		
		Integer[] a = {1,2,10};
		Integer[] b = {2,3,5};
		Integer[] c = {1,3,9};
		Integer[] d = {4,3,2};
		Integer[] e = {1,3,10};
		
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(a));
		ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(b));
		ArrayList<Integer> al3 = new ArrayList<>(Arrays.asList(c));
		ArrayList<Integer> al4 = new ArrayList<>(Arrays.asList(d));
		ArrayList<Integer> al5 = new ArrayList<>(Arrays.asList(e));
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		list.add(al);
		list.add(al2);
		list.add(al3);
		//list.add(al4);
		//list.add(al5);
		Graphs_CommutableIslands o = new Graphs_CommutableIslands();
		System.out.println(o.solve(3, list));
		
	}
	
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
    	ArrayList<Node>[] graph = (ArrayList<Node>[])new ArrayList[A+1];
    	ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[A+1];
		Node[] nodes = new Node[A+1];
		for(int i=1;i<=A;i++){
			nodes[i] = new Node(i);
		}
		nodes[1].cost = 0;
		
		
    	buildGraph(B,graph,cost,nodes);
    	boolean[] inQueue = new boolean[A+1];
    	Arrays.fill(inQueue, true);
    	PriorityQueue<Node> q = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.cost.compareTo(o2.cost);
			}
		
    	
    	});
    	for(int i = 1;i<nodes.length;i++){
    		q.add(nodes[i]);
    	}
    	
    	int result = 0;
    	while(!q.isEmpty()){
    		Node top = q.poll();
    		if(inQueue[top.a])
    			result+=top.cost;
    		inQueue[top.a] = false;
    		ArrayList<Node> neigbors = graph[top.a];
    		
    		for(int i=0;i<neigbors.size();i++){
    			Node n = neigbors.get(i);
    			int c = n.cost;
    			if(inQueue[n.a]){
    				if(c > cost[top.a].get(i)){
    					q.remove(n);//heapify
    					Node newNode = new Node(n.a);
    					newNode.cost = cost[top.a].get(i); 
    					q.add(newNode);
    				}
    			}
    		}
    		
    		
    	}
    	return result;
    }

	private void buildGraph(ArrayList<ArrayList<Integer>> B,ArrayList<Node>[] graph,ArrayList<Integer>[] cost,Node[] nodes) {
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Node>();
			cost[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < B.size(); i++) {
        	ArrayList<Integer> al = B.get(i);
        	graph[al.get(0)].add(nodes[al.get(1)]);
        	graph[al.get(1)].add(nodes[al.get(0)]);
        	cost[al.get(0)].add(al.get(2));
        	cost[al.get(1)].add(al.get(2));
        }
		
	}
	class Node{
		int a;
		Integer cost = Integer.MAX_VALUE;
		Node(int a){
			this.a = a;
		}
	}

}
