package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

import com.practice.algo.and.ds.interviewbit.Trees_KthSmallestElementInTreeRevisted.TreeNode;

public class Trees_KthSmallestElementInTree {

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
		Trees_KthSmallestElementInTree o = new Trees_KthSmallestElementInTree();
		System.out.println(o.findKth(root, 5));
		
		

	}
	
	public int findKth(TreeNode node,int k){
		ArrayList<Integer> list = new  ArrayList<>();
		inOrderWithoutRecursion(node,k,list);
		return list.get(k-1);
	}
	
	private void inOrder(TreeNode node,ArrayList<Integer> list){
		if(node==null){
			return;
		}
		inOrder(node.left,list);
		list.add(node.val);
		inOrder(node.right,list);
	}
	
	//Without Recursion
	
	private void inOrderWithoutRecursion(TreeNode root,int k,ArrayList<Integer> list){
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while(!stack.isEmpty() || p!=null){
		
			if(p!=null){
				stack.push(p);
				p = p.left;
			}else {
				TreeNode n = stack.pop();
				list.add(n.val);
				if(list.size()==k){
					return;
				}
				p = n.right;				
			}
		}
		
		
	}
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    boolean visited;
	    TreeNode(int x) { val = x; }
	}
}
