package com.practice.algo.and.ds.interviewbit;

import com.practice.algo.and.ds.interviewbit.Trees_MinDepthofBinaryTree.TreeNode;

public class Trees_MinDepthOfBinaryTreeRevisited {

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
		
		Trees_MinDepthOfBinaryTreeRevisited o = new Trees_MinDepthOfBinaryTreeRevisited();
		System.out.println(o.minDepth(root));
		//System.out.println(o.minDepthRevisited(root));

	}
	public int minDepth(TreeNode root) {
		return minDepth(root,1);
	}
	int minDepth = Integer.MAX_VALUE;
	private int minDepth(TreeNode root, int i) {
		if(i>minDepth){
			return Integer.MAX_VALUE;
		}
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			minDepth= Math.min(minDepth, i);
		minDepth(root.left, i+1);
		minDepth(root.right, i+1);
		
		return minDepth;
	}
	
	public int minDepthDev(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        
        // if both children's returned min depth then pick the min of them and add 1 for current level
        if(leftMinDepth != 0 && rightMinDepth != 0)
            return Math.min(leftMinDepth, rightMinDepth) + 1;
        // else min depth would be the max of both children's + 1, both children can return 0 or one of them may return some min depth
        else
            return Math.max(leftMinDepth, rightMinDepth) + 1;
    }
}
