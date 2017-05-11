package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class BackTracking_LeetCode_ReConstructItenrary {
	//JFK --> KUL
	// | ^
	// | |
	// | |
	// # |	
	// NRT	
	public static void main(String[] args) {
		//String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		BackTracking_LeetCode_ReConstructItenrary o = new BackTracking_LeetCode_ReConstructItenrary();
		System.out.println(o.findItinerary(tickets));

	}
	public List<String> findItinerary(String[][] tickets) {
		HashMap<String,ArrayList<String>> graph = new HashMap<>();
		buildGraph(tickets,graph);
		List<String> result = new ArrayList<>();
		Set<Entry<String,ArrayList<String>>> entries = graph.entrySet();
		Iterator<Entry<String,ArrayList<String>>> it = entries.iterator();
		while(it.hasNext()){
			Entry<String,ArrayList<String>> e = it.next();
			Collections.sort(e.getValue());
		}
		result.add("JFK");
		findItineraryHelper(graph,result,tickets.length,"JFK");
		return result;

	}
	private void findItineraryHelper( HashMap<String, ArrayList<String>> graph,List<String> result,int edges,
			String current) {
		if(result.size()==edges+1){
			return;
		}
		ArrayList<String> neigbors = graph.get(current);
		if(neigbors!=null)
			for(int i=0;i<neigbors.size();i++){
				String next = neigbors.get(i);
				neigbors.remove(i);
				result.add(next);
				findItineraryHelper(graph, result, edges, next);
				if(result.size()==edges+1)
					return;
				result.remove(result.size()-1);
				neigbors.add(i, next);
			}

	}
	private void buildGraph(String[][] tickets, HashMap<String, ArrayList<String>> graph) {
		// TODO Auto-generated method stub
		for(int i=0;i<tickets.length;i++){
			String source = tickets[i][0];
			String dest = tickets[i][1];
			if(graph.containsKey(source)){
				graph.get(source).add(dest);
			}else{
				ArrayList<String> neighbors = new ArrayList<>();
				neighbors.add(dest);
				graph.put(source, neighbors);
			}
		}
	}
}
