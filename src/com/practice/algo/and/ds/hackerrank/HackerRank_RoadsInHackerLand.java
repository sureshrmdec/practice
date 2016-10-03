package com.practice.algo.and.ds.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HackerRank_RoadsInHackerLand {

	static int cost=0;
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>(n+1);
        for(int i=0; i<n+1; i++)
        	adj.add(new ArrayList<Node>(n+1));
    
        while(m-- > 0){
            int x = sc.nextInt(), y = sc.nextInt(), cost = sc.nextInt();
            adj.get(x).add(new Node(y, cost));
            adj.get(y).add(new Node(x, cost));
        }
        for(int i=1;i<=n-1;i++){
        	djikstra(i, adj, n);	
        }
        System.out.println(Integer.toBinaryString(cost));
        
    
	}
	private static void djikstra(int i, ArrayList<ArrayList<Node>> adj, int n) {
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		 dist[i] = 0;
		 PriorityQueue<Node> pq = new PriorityQueue<Node>();
	     pq.add(new Node(i, 0));
	     while(!pq.isEmpty()){
	            Node curr = pq.peek(); 
	            pq.poll();
	            int currN = curr.val;
	            Iterator<Node> it = adj.get(currN).iterator();
	            while(it.hasNext()){
	                Node temp = it.next();
	                if(dist[temp.val] > dist[currN] + Math.pow(2, temp.cost)){
	                    pq.add(new Node(temp.val, (int) (dist[currN]+Math.pow(2, temp.cost))));
	                    dist[temp.val] = (int) (dist[currN] + Math.pow(2, temp.cost));
	                }
	            }
	        
	     }
	     for(int j=i+1;j<=n;j++){
	    	 cost+=dist[j];
	     }
		
	}
	static class Node implements Comparable<Node>{
	    int val, cost;
	    Node(int val, int cost){
	        this.val = val; this.cost = cost;
	    }
	    
	    public int compareTo(Node x){
	        return Integer.compare(this.cost, x.cost);
	    }
	}
}
