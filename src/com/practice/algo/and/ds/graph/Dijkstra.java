package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
//http://codebyte

public class Dijkstra {

	class Node {

		boolean showMoreInfo = true;
		int distanceFromSource = 0;
		String name;
		public Map<Node, Integer> neighbors = new HashMap<>();

		Node(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Node: ").append(name).append("\n");

			sb.append("Distance from source: ").append(distanceFromSource).append("\n");

			if (showMoreInfo) {
				sb.append("Neighbor nodes: \n");
				for (Node node : neighbors.keySet()) {
					sb.append(node.name).append("  Distance: ").append(this.neighbors.get(node)).append("\n");
				}

				sb.append("\n");
			}
			return sb.toString();
		}
	}
	List<Node> nodes = new ArrayList<>(); 

	public void drawGraph() {
		Node s = new Node("s");

		//Two immediate (reachable) neighbors of Node s
		Node t = new Node("t");
		Node y = new Node("y");
		s.neighbors.put(t, 10);
		s.neighbors.put(y, 5);

		//One of the two immediate (reachable) neighbors of Node t
		Node x = new Node("x");
		t.neighbors.put(x, 1);
		t.neighbors.put(y, 2);

		y.neighbors.put(t, 3);
		y.neighbors.put(x, 9);

		//Last Node z (immediately reachable from x and y nodes)
		Node z = new Node("z");
		x.neighbors.put(z, 4);
		y.neighbors.put(z, 2);
		z.neighbors.put(x, 6);
		z.neighbors.put(s, 7);

		//Now add these to List<Node> nodes
		nodes.add(s);
		nodes.add(t);
		nodes.add(y);
		nodes.add(x);
		nodes.add(z);
	}

	private void initializeNodes(){
		for(Node node:nodes)
			node.distanceFromSource = Integer.MAX_VALUE;
		nodes.get(0).distanceFromSource = 0;
	}

	private void relax(Node previous, Node next, PriorityQueue<Node> queue) {
		if (next.distanceFromSource > previous.distanceFromSource + previous.neighbors.get(next)) {
			next.distanceFromSource = previous.distanceFromSource + previous.neighbors.get(next);
			if (queue.contains(next)) {
				queue.remove(next);
			}
			queue.add(next);
		}
	}
	public void dijkstra(){
		PriorityQueue<Node> queue = new PriorityQueue<>((Object o1, Object o2) -> {
			Node first = (Node) o1;
			Node second = (Node) o2;

			if (first.distanceFromSource < second.distanceFromSource)
				return -1;
			else if (first.distanceFromSource > second.distanceFromSource)
				return 1;
			else
				return 0;
		});
		queue.add(nodes.get(0));
		//queue.addAll(nodes);

		while(!queue.isEmpty()){
			Node min = queue.peek();
			queue.poll();	            
			Map<Node, Integer> neighbors = min.neighbors;
			for(Map.Entry<Node, Integer> me:neighbors.entrySet()){
				relax(min, me.getKey(),queue);
			}	            
		}
	}

	public static void main(String[] args){
		Dijkstra da = new Dijkstra();
		da.drawGraph();
		da.initializeNodes(); 
		da.dijkstra();

		System.out.println(da.nodes.size());
		for(Node node:da.nodes)
			System.out.println(node);
	}
}
