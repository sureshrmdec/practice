package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graphs_CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode node = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(0);
		UndirectedGraphNode node2 = new UndirectedGraphNode(0);
		node.neighbors.add(node);
		//node.neighbors.add(node2);
		Graphs_CloneGraph o = new Graphs_CloneGraph();
		o.cloneGraph(node);
	}
	
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
    	if(node==null)
    		return null;
    	HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
    	
    
    	Queue<UndirectedGraphNode> queue = new LinkedList<>();
    	queue.add(node);
    	UndirectedGraphNode aa = new UndirectedGraphNode(node.label);
    	map.put(node,aa);
    	HashSet<UndirectedGraphNode> processed = new HashSet<UndirectedGraphNode>();
    	processed.add(node);
    	while(!queue.isEmpty()){
    		
    		UndirectedGraphNode current = queue.poll();
    		
    		UndirectedGraphNode a = map.get(current);
    		
    		List<UndirectedGraphNode> neighbors = current.neighbors;
    		
    		for(UndirectedGraphNode neighbor:neighbors){
    			
    			if(map.containsKey(neighbor)){
    				//use already made
    				a.neighbors.add(map.get(neighbor));
    			}else{
    				UndirectedGraphNode n = new UndirectedGraphNode(neighbor.label);
    				a.neighbors.add(n);
        			map.put(neighbor,n);
    			}
    			if(!processed.contains(neighbor)){
    		    	processed.add(neighbor);
    				queue.add(neighbor);
    		}
    		}
    		
    	}
    	
    	
    	return aa;
    
    }

}
class UndirectedGraphNode {
	      int label;
	      List<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) { 
	    	  label = x; 
	    	  neighbors = new ArrayList<UndirectedGraphNode>(); 
	    	  }
	  };