package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class Graphs_LeetCode_EvaluateDivision {

	public static void main(String[] args) {
		String[][] equations = {{"a", "b"}, {"b", "c"},{"bc","cd"}};
		double[] values = {1.5,2.5,5.0};
		String[][] queries = {{"a", "c"}, {"c", "b"}, {"bc", "cd"}, {"cd", "bc"}}; 
		Graphs_LeetCode_EvaluateDivision o = new Graphs_LeetCode_EvaluateDivision();
		double[] d = o.calcEquation(equations, values, queries);
		System.out.println();

	}
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<equations.length;i++){
			set.add(equations[i][0]);
			set.add(equations[i][1]);
		}
		//Double[][] graph = new Double[set.size()][set.size()];
		HashMap<String,ArrayList<String>> graph = new HashMap<>();
		HashMap<String,ArrayList<Double>> graphValue = new HashMap<>();
		
		buildGraph(equations,values,graph,graphValue);
		double[] result = new double[queries.length];
		
		for(int i=0;i<queries.length;i++){
			String start= queries[i][0];
			String dest = queries[i][1];
			if(!set.contains(queries[i][0]) || !set.contains(queries[i][1])){
				result[i] = -1;
				continue;
			}
				
			if((graph.get(dest)!=null && graph.get(dest).indexOf(start)!=-1) || 
					(graph.get(start)!=null && graph.get(start).indexOf(dest)==-1)){
				double d = 0;
				if(graph.get(dest)!=null && graph.get(dest).contains(start)){
					//graph[start][dest] =  1/graph[dest][start];
					int index = graph.get(dest).indexOf(start);
					d = 1/graphValue.get(dest).get(index);
				}else{
					d = bfs(start,dest,graph,graphValue);	
				}
				result[i] = d;
			}else{
				int index = graph.get(start).indexOf(dest);
				result[i] = graphValue.get(start).get(index);
			}
		}
		return result;
	}
	private double bfs(String start,String end,HashMap<String,ArrayList<String>> graph,HashMap<String,ArrayList<Double>> graphValue) {

		Queue<State> queue = new java.util.LinkedList<State>();
		State state = new State(start,1);
		queue.add(state);
		while(!queue.isEmpty()){
			State st = queue.poll();
			String l = st.label;
			if(l.equals(end)){
				return st.value;
			}
			for(int i=0;i<graph.get(l).size();i++){
					State nS = new State(graph.get(l).get(i), st.value*graphValue.get(l).get(i));
					queue.add(nS);
			}

		}

		double d = -1;
		return d;
	}
	private void buildGraph(String[][] equations, double[] values,HashMap<String,ArrayList<String>> graph,HashMap<String,ArrayList<Double>> graphValue) {

		for(int i=0;i<equations.length;i++){
			if(graph.containsKey(equations[i][0])){
				graph.get(equations[i][0]).add(equations[i][1]);
				graphValue.get(equations[i][0]).add(values[i]);
				
			}else{
				ArrayList<String> neighbors = new ArrayList<>();
				neighbors.add(equations[i][1]);
				graph.put(equations[i][0],neighbors);
				ArrayList<Double> neighborsValue = new ArrayList<>();
				neighborsValue.add(values[i]);
				graphValue.put(equations[i][0],neighborsValue);
			}
		}
	}
	static class State{
		String label;
		double value;
		public State(String label, double value) {
			super();
			this.label = label;
			this.value = value;
		}

	}
}
