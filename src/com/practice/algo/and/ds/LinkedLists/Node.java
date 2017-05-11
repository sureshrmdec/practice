package com.practice.algo.and.ds.LinkedLists;

public class Node<T> implements Comparable<Node>{

	public T val;
	public Node next;
	public Node previous;
	public Node(T val) {
		super();
		this.val = val;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if(this.val==o.val){
			return 0;
		}
		return 1;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Node n = (Node)obj;
		return this.val == n.val;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.val.hashCode();
	}
}
