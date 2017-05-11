package com.practice.algo.and.ds.interviewbit;

public class Trees_identical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

	private boolean isIdentical(TreeNode root1,TreeNode root2){
		
		if(root1==null && root2==null){
			return true;
		}
		if(root1==null || root2==null){
			return false;
		}
		if(root1.val!=root2.val){
			return false;
		}
		boolean left = isIdentical(root1.left, root2.left);
		boolean right = isIdentical(root1.right, root2.right);
		if(left && right)
			return true;
		return false;
	}
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
