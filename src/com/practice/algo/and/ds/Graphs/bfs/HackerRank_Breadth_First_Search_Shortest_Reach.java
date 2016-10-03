package com.practice.algo.and.ds.Graphs.bfs;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class HackerRank_Breadth_First_Search_Shortest_Reach {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter p = new PrintWriter(System.out);
		int q = sc.nextInt();
		for(int i =0;i<q;i++){
			int v = sc.nextInt();
			int e = sc.nextInt();
			Graph g = new Graph(v+1);
			for(int j=0;j<e;j++){
				int from = sc.nextInt();
				int to = sc.nextInt();
				g.add(new Edge(from,to,6));
				g.add(new Edge(to,from,6));
			}
			int s = sc.nextInt();
			int[] res = new int[v+1];
			Arrays.fill(res, -1);
			Queue<State> queue = new LinkedList<>();
			queue.add(new State(0,s,0));
			boolean[] visited = new boolean[v+1];
			
			while(!queue.isEmpty()){
				
				State state = queue.poll();
				visited[state.to] = true;
				for(Edge edge:g.adj(state.to)){
					if(!visited[edge.to]){
						queue.add(new State(edge.from,edge.to,state.dis+edge.weight));
						if((res[edge.to] > state.dis+edge.weight) || res[edge.to]==-1)
							res[edge.to] =  state.dis+edge.weight;
					}
				}
			}
			for(int r=1;r<res.length;r++){
				if(r!=s){
					p.print(res[r]+" ");
				}
			}
			p.println();
		}
		p.close();
	}
	static class State{
		int dis;
		public State(int from, int to,int dis) {
			super();
			this.dis = dis;
			this.from = from;
			this.to = to;
		}
		int from;
		int to;
	}
	static class Graph{
        private final List<Edge>[] adj;

        public Graph(int n) {
            //noinspection unchecked
            adj = (List<Edge>[]) new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void add(Edge e) {
            int v = e.from;
            adj[v].add(e);
        }

        public Iterable<Edge> adj(int v) {
            return adj[v];
        }

        public int numOfVertices() {
            return adj.length;
        }
    }
	//Edge
		static class Edge{
			int from;
			int to;
			int weight;
			
			 public Edge(int from, int to, int weight) {
		            this.from = from;
		            this.to = to;
		            this.weight = weight;
		        }
		}
}
