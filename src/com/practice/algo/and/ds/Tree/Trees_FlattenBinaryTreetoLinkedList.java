package com.practice.algo.and.ds.Tree;

import java.util.Stack;


public class Trees_FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		five.left = seven;
		Trees_FlattenBinaryTreetoLinkedList o = new Trees_FlattenBinaryTreetoLinkedList();
		o.flatten(root);
	}
	public void flatten(TreeNode root) {
		flattenOL(root);
		
	}
	public TreeNode flattenOL(TreeNode root){
		
		if(root==null)
			return null;
		
		if(root.left==null && root.right==null){
			return root;
		}
		
		TreeNode leftLast = flattenOL(root.left);
		TreeNode rightLast = flattenOL(root.right);
		
		if(leftLast==null)
			leftLast = root;
		
		TreeNode tempR = root.right;
		root.right = root.left;
		root.left=null;
		leftLast.right = tempR;
		
		
		
		return rightLast!=null?rightLast:leftLast;
	}
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    boolean visited;
	    TreeNode(int x) { val = x; }
	}
}


