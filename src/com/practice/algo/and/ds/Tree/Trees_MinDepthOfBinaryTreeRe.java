package com.practice.algo.and.ds.Tree;

import com.practice.algo.and.ds.Tree.Trees_MinDepthofBinaryTree.TreeNode;

public class Trees_MinDepthOfBinaryTreeRe {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode f4 = new TreeNode(4);
		TreeNode f5 = new TreeNode(5);
		TreeNode s6 = new TreeNode(6);
		root.left = two;
		root.right = three;

		three.left = f4;
		three.right = f5;

		f4.left = s6;

		Trees_MinDepthOfBinaryTreeRe o = new Trees_MinDepthOfBinaryTreeRe();
		System.out.println(o.minDepth(root));

	}

	private int minDepth(TreeNode root) {
		// TODO Auto-generated method stub
		return minDepthHelper(root);

	}

	private int minDepthHelper(TreeNode root) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		// TODO Auto-generated method stub
		int left = minDepthHelper(root.left);
		int right = minDepthHelper(root.right);
		if(left==0 || right==0)
			return Math.max(left, right)+1; //if any of the left or right is zero, return another's length (which would be bigger obviously)
		else
			return Math.min(left, right)+1;



	}


}
