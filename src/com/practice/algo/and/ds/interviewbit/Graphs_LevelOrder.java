package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graphs_LevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphs_LevelOrder o = new Graphs_LevelOrder();
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
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();

		List<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		List<TreeNode> innerQueue = new LinkedList<>();
		innerQueue.add(root);

		while(!innerQueue.isEmpty()){
			Iterator<TreeNode> qI = queue.iterator();
			ArrayList<Integer> resI = new ArrayList<>();
			innerQueue.clear();
			while(qI.hasNext()){
				TreeNode node = qI.next();
				resI.add(node.val);
				if(node.left!= null)
					innerQueue.add(node.left);
				if(node.right!= null)
					innerQueue.add(node.right);
			}
			queue.clear();
			queue.addAll(innerQueue);
			res.add(resI);
		}
		return res; 
	}
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
