package com.practice.algo.and.ds.Tree;

import java.util.Stack;

public class Trees_KthSmallestElementInTreeRevisted {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode three = new TreeNode(3);
		TreeNode eight = new TreeNode(8);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode seven = new TreeNode(7);
		TreeNode nine = new TreeNode(9);
		
		root.left = three;
		root.right = eight;
		
		three.left = two;
		three.right = four;
		
		eight.left = seven;
		eight.right = nine;
		Trees_KthSmallestElementInTreeRevisted o = new Trees_KthSmallestElementInTreeRevisted();
		System.out.println(o.findKth(root, 5));
		
		

	}
	private int findKth(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		int i = 0;
		while(!stack.isEmpty() || p!=null){
			if(p!=null){
				stack.push(p);
				p = p.left;
			}else{
				p = stack.pop();
				i++;
				if(i==k){
					return p.val;
				}
				p=p.right;
			}
		}
				
		// 
		return -1;
	}

	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    boolean visited;
	    TreeNode(int x) { val = x; }
	}
}