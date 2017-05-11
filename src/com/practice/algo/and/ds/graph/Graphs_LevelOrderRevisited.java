package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// See class package com.practice.algo.and.ds.Tree.Trees_LeetCode_BinaryTreeLevelOrderTraversal; Use that one
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
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> r = new ArrayList<>();
		r.add(root.val);
		result.add(r);
		Queue<TreeNode> queue = new LinkedList();
		Queue<TreeNode> innerQueue = new LinkedList();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			
			if(node.left!=null)
				innerQueue.add(node.left);
			if(node.right!=null)
				innerQueue.add(node.right);
			
			if(queue.isEmpty()){
				ArrayList<Integer> rr = new ArrayList<>();
				if(innerQueue.size()>0){
				for(TreeNode n:innerQueue){
					rr.add(n.val);
				}
				queue.addAll(innerQueue);
				innerQueue.clear();
				result.add(rr);
				}
			}
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
