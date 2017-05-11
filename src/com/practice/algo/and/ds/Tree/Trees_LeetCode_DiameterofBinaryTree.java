package com.practice.algo.and.ds.Tree;

public class Trees_LeetCode_DiameterofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int diameterOfBinaryTree(TreeNode root) {
		diameterOfBinaryTreeHelper(root);
		return max;
	}
	int max = 0;
	private int diameterOfBinaryTreeHelper(TreeNode root) {
		if(root==null)
			return 0;
		int left = diameterOfBinaryTreeHelper(root.left);
		int right = diameterOfBinaryTreeHelper(root.right);
		max = Math.max(max, left+right);
		return Math.max(left, right)+1;
	}
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
