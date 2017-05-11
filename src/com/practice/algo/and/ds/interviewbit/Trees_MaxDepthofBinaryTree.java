package com.practice.algo.and.ds.interviewbit;

import com.practice.algo.and.ds.interviewbit.Trees_KthSmallestElementInTreeRevisted.TreeNode;

public class Trees_MaxDepthofBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		root.left = two;
		Trees_MaxDepthofBinaryTree o = new Trees_MaxDepthofBinaryTree();
		System.out.println(o.maxDepth(root));
	}
    public int maxDepth(TreeNode root) {
        
        if(root==null)
        	return 0;
        
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        
        return left>right?left:right;
    }
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    boolean visited;
	    TreeNode(int x) { val = x; }
	}
}
