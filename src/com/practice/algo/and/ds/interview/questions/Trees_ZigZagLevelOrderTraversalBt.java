package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Trees_ZigZagLevelOrderTraversalBt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		Queue<TreeNode> innerQueue = new LinkedList<>();
		boolean rightToLeft = true;
		
		ArrayList<Integer> ro = new ArrayList<>();
		while(queue.isEmpty()){
			TreeNode node = queue.poll();
			
			innerQueue.add(node.left);
			innerQueue.add(node.right);
			if(root.left!=null)
				ro.add(node.left.val);
			if(root.right!=null)
				ro.add(node.right.val);
			
			if(queue.isEmpty()){
				queue.addAll(innerQueue);
				innerQueue.clear();
				ArrayList<Integer> r = new ArrayList<>();
				if(rightToLeft){
					for(int i=ro.size()-1;i>0;i--){
						r.add(ro.get(i));
					}
				}else{
					r.addAll(ro);
				}
				rightToLeft = !rightToLeft;
					
			}
			
		}
		
		
		
		return result;
	}
}
