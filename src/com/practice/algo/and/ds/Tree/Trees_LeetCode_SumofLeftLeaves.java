package com.practice.algo.and.ds.Tree;


public class Trees_LeetCode_SumofLeftLeaves {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode o1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode f4 = new TreeNode(4);
		TreeNode f5 = new TreeNode(5);
		TreeNode s6 = new TreeNode(6);
		TreeNode s7 = new TreeNode(7);
		TreeNode e8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(10);

		root.left = o1;
		root.right = t2;

		o1.left = t3;
		o1.right = f4;

		t2.left = f5;
		t2.right = s6;

		t3.left = s7;
		t3.right = e8;
		f4.left = n9;

		s6.left = t10;
		Trees_LeetCode_SumofLeftLeaves o = new Trees_LeetCode_SumofLeftLeaves();
		System.out.println(o.sumOfLeftLeaves(root));

	}
	public int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeftLeavesOL(root,false);
	}
	private int sumOfLeftLeavesOL(TreeNode root, boolean isLeft) {

		if(root==null)
			return 0;
		if(root.left==null && root.right==null && isLeft){
			return root.val;
		}
		int sumL=sumOfLeftLeavesOL(root.left,true);
		int sumR=sumOfLeftLeavesOL(root.right,false);
		
		return sumL+sumR;
	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
