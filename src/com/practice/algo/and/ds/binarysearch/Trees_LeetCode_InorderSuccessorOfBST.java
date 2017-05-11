package com.practice.algo.and.ds.binarysearch;


public class Trees_LeetCode_InorderSuccessorOfBST {

	public static void main(String[] args) {
		TreeNode o1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(3);
		TreeNode f4 = new TreeNode(6);
		TreeNode f22 = new TreeNode(2);
		TreeNode t42 = new TreeNode(4);
		TreeNode t11 = new TreeNode(1);
		o1.left = t2;
		o1.right = f4;
		t2.left = f22;
		t2.right = t42;
		f22.left = t11;

		Trees_LeetCode_InorderSuccessorOfBST o = new Trees_LeetCode_InorderSuccessorOfBST();
		System.out.println(o.inorderSuccessor(o1, new TreeNode(1)).val);
		
		
		o1 = new TreeNode(2);
		t2 = new TreeNode(1);
		
		o1.left = t2;
		System.out.println(o.inorderSuccessor(o1, new TreeNode(2)).val);
	}
	//https://discuss.leetcode.com/topic/25698/java-python-solution-o-h-time-and-o-1-space-iterative
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	    TreeNode succ = null;
	    while (root != null) {
	        if (p.val < root.val) {
	            succ = root;
	            root = root.left;
	        }
	        else
	            root = root.right;
	    }
	    return succ;
	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}
