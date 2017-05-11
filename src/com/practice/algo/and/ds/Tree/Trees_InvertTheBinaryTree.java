package com.practice.algo.and.ds.Tree;

public class Trees_InvertTheBinaryTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(7);
		TreeNode one = new TreeNode(1);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		TreeNode nine = new TreeNode(9);
		
		root.left = two;
		root.right = seven;
		
		two.left = one;
		two.right = three;
		
		seven.left = six;
		seven.right = nine;
		Trees_InvertTheBinaryTree o = new Trees_InvertTheBinaryTree();
		o.invertTree(root);
		
		
	}

	private TreeNode invertTree(TreeNode root){
		
		if(root==null){
			return null;
		}
		
		invertTree(root.left);
		
		invertTree(root.right);
		
		TreeNode tempL = root.left;
		root.left = root.right;
		root.right = tempL;
		return root;
	}
}
