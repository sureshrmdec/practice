package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs_LevelOrderRevisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphs_LevelOrderRevisited o = new Graphs_LevelOrderRevisited();
		TreeNode r = o.new TreeNode(3);
		TreeNode rl = o.new TreeNode(9);
		TreeNode rr = o.new TreeNode(20);
		TreeNode lrr = o.new TreeNode(15);
		TreeNode rrr = o.new TreeNode(7);
		r.left = rl;
		r.right = rr;
		rr.left=lrr;
		rr.right=rrr;
		System.out.println(o.levelOrder(r));
		

	}
	//using one queue only...asked in linkedin
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> r = new ArrayList<>();
		r.add(root.val);
		result.add(r);
		Queue<TreeNode> queue = new LinkedList();
		
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0;i<size;i++){
				TreeNode node = queue.poll();
				System.out.print(node.val +" ");
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);	
				
			}
			System.out.println();
		}
		return result;
		
	}
	 class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
