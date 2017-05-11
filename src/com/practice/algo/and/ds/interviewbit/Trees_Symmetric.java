package com.practice.algo.and.ds.interviewbit;



public class Trees_Symmetric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isSymmetric(TreeNode root){
	
		if(root==null)
			return true;
		else
			isSymmetric(root.left,root.right);
		return false;
	}
	
	public boolean isSymmetric(TreeNode root1,TreeNode root2){
		if(root1==null && root2==null){
			return true;
		}
		if(root1==null || root2==null){
			return false;
		}
		if(root1.val!=root2.val){
			return false;
		}
		boolean one = isSymmetric(root1.left,root2.right);
		boolean second = isSymmetric(root1.right,root2.left);
		if(one && second)
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
