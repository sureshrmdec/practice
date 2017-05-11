package com.practice.algo.and.ds.interviewbit;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.practice.algo.and.ds.interviewbit.Trees_KthSmallestElementInTreeRevisted.TreeNode;

public class Trees_2SumBinaryTree {

	public static void main(String[] args) {
		//7 10 9 20 -1 -1 -1 -1 
		Trees_2SumBinaryTree o = new Trees_2SumBinaryTree();
		TreeNode root = new TreeNode(7);
		TreeNode three = new TreeNode(10);
		TreeNode eight = new TreeNode(9);
		TreeNode two = new TreeNode(20);
		TreeNode four = new TreeNode(-1);
		TreeNode seven = new TreeNode(-1);
		TreeNode nine = new TreeNode(-1);
		
		root.left = three;
		root.right = eight;
		
		three.left = two;
		three.right = four;
		
		eight.left = seven;
		eight.right = nine;
		System.out.println(o.exists(root, 40));

	}
	
	public int exists(TreeNode root,int k){
		HashSet<Integer> set = new HashSet<>();
		boolean b = inOrderWithoutRecursion(root, k, set);
		return b?1:0;
		
	}
	//Its very important
	private boolean inOrderWithoutRecursion(TreeNode root,int k,HashSet<Integer> set){
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while(!stack.isEmpty() || p!=null){
		
			if(p!=null){
				stack.push(p);
				p = p.left;
			}else {
				TreeNode n = stack.pop();
				
				if(set.contains(k - n.val)){
					return true;
				}
				set.add(n.val);
				p = n.right;				
			}
		}
		
		return false;
	}
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    boolean visited;
	    TreeNode(int x) { val = x; }
	}
}
