package com.practice.algo.and.ds.Tree.IntervalTree;



public class IntervalTree<T extends Comparable<T>> {

	Node root;
	private void insert(Node n){
		
		if(root==null){
			root = n;
			root.max = n.end;
			return;
		}
		Node current = root;
		Node parent;
		while(true){
			parent = current;
			if(parent.max.compareTo(n.end)<0){
				parent.max = n.end;
			}
			if(n.start.compareTo(current.start)<0){
				current = current.left; 
				if(current == null) // if end of the line,
				{ // insert on left
					parent.left = n;
					return;
				}
			}else{
				current = current.right; 
				if(current == null) // if end of the line,
				{ // insert on right
					parent.right = n;
					return;
				}
			}
			
		}
		
	}

	private void printAllOverlaps(Node current, T start, T end) {
		// root intersection
		if (isIntersect(current, start, end)) {
			System.out.println(current.start + " " + current.end);
		}
		// left child
		if (current.left != null && current.left.max.compareTo(start) >= 0) {
			printAllOverlaps(current.left, start, end);
		}
		// right child
		if (current.right != null && current.right.max.compareTo(start) >= 0) {
			printAllOverlaps(current.right, start, end);
		}

	}
	boolean isIntersect(Node current,T start,T end){
		if((current.start.compareTo(end)<=0) && (start.compareTo(current.end)<=0)){
			return true;
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		IntervalTree<Integer> o = new IntervalTree<Integer>();
		o.insert(o.new Node(6,9));
		o.insert(o.new Node(5,8));
		o.insert(o.new Node(2,7));
		o.insert(o.new Node(3,8));
		o.insert(o.new Node(8,15));
		o.insert(o.new Node(9,20));
		o.insert(o.new Node(7,50));
		System.out.println();
		o.printAllOverlaps(o.root,10,14);

	}

	 class Node implements Comparable<Node>{
		T start;
		T end;
		T max;
		Node left;
		Node right;
		public Node(T start, T end) {
			super();
			this.start = start;
			this.end = end;
			this.max = end;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.start.compareTo(o.start);
		}
		
		
	}
	
}
