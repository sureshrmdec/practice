package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.practice.algo.and.ds.graph.MST_Prims_Algo.EDGE;
//http://www.codebytes.in/2015/06/prims-algorithm-java-implementation.html
public class MST_Prims_Algo<T extends Comparable<T>> {

	public static void main(String[] args) {
		MST_Prims_Algo<Integer> o = new MST_Prims_Algo<>();
		EDGE[] edges = new EDGE[14];
        
        edges[0] = new EDGE(1, 2, 4);
        edges[1] = new EDGE(1, 9, 8);
        edges[2] = new EDGE(2, 9, 11);
        edges[3] = new EDGE(9, 8, 7);
        
        edges[4] = new EDGE(2, 3, 8);
        edges[5] = new EDGE(3, 8, 2);
        edges[6] = new EDGE(8, 7, 6);
        edges[7] = new EDGE(9, 7, 1);
        
        edges[8] = new EDGE(7, 6, 2);
        edges[9] = new EDGE(3, 4, 7);
        edges[10] = new EDGE(3, 6, 4);
        edges[11] = new EDGE(4,6, 14);
        
        edges[12] = new EDGE(4, 5, 9);
        edges[13] = new EDGE(6, 5,10);
        /*edges[14] = new EDGE(6, 0, 0.58);
        edges[15] = new EDGE(6, 4, 0.93);*/
        ArrayList<ArrayList<EDGE>> graph = createGraph(edges);
        ArrayList<EDGE> mst = prims(graph);
        
        System.out.println("MST: ");
        for(EDGE e:mst){
            System.out.println(e.from+" - "+e.to+" : "+e.weight);
        }
		
	}
	public static ArrayList<ArrayList<EDGE>> createGraph(EDGE[] edges){
        ArrayList<ArrayList<EDGE>> G = new ArrayList<>();
        int length = edges.length*2;
        for(int i=0;i<10;++i){
            G.add(new ArrayList<>());
        }
        
        for(EDGE e:edges){
            EDGE other = new EDGE(e.to, e.from, e.weight);
            G.get(e.from).add(e);
            G.get(e.to).add(other);
            System.out.println("Added edge ["+e.from+", "+e.to+" : "+e.weight+"] "+"["+e.to+", "+e.from+" : "+e.weight+"]");
        }
        
        return G; 
    }
	 public static ArrayList<EDGE> prims(ArrayList<ArrayList<EDGE>> G){
	        if(G.isEmpty())throw new NullPointerException("The Graph is empty");
	        
	        ArrayList<EDGE> mst = new ArrayList<>();
	        PriorityQueue<EDGE> pq = new PriorityQueue<>((Object o1, Object o2) -> {
	            EDGE first = (EDGE)o1;
	            EDGE second = (EDGE)o2;
	            
	            if(first.weight<second.weight)return -1;
	            else if(first.weight>second.weight)return 1;
	            else return 0;
	        });
	        
	        for(EDGE e:G.get(1)){
	            pq.add(e);
	        } 
	        
	        boolean[] marked = new boolean[G.size()];
	        marked[1] = true;
	        while(!pq.isEmpty()){
	            EDGE e = pq.peek();
	            
	            pq.poll();
	            if(marked[e.from] && marked[e.to]){
	            	continue;
	            }
	            marked[e.from] = true;  
	            for(EDGE edge:G.get(e.to)){
	                if(!marked[edge.to]){
	                    pq.add(edge);  
	                }
	            }
	            marked[e.to] = true; 
	            mst.add(e);
	            
	        }
	        return mst;  
	 }
	static class EDGE{
        int from, to;
        double weight;
        
        EDGE(int f, int t, double w){
            from = f;
            to = t;
            weight = w;
        }
    }
}
