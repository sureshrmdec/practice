package com.practice.algo.and.ds.interviewbit;

import com.practice.algo.and.ds.interviewbit.Trees_Symmetric.TreeNode;

public class Trees_SymmetricRevisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int isSymmetric(TreeNode root){
		if(root==null)
			return 1;
		return isSymmetric(root.left, root.right);
	}
	public int isSymmetric(TreeNode root1,TreeNode root2){
		if(root1==null && root2==null)
			return 1;
		if(root1==null || root2==null)
			return 0;
		if(root1.val!=root2.val){
			return 0;
		}
		if(isSymmetric(root1.left, root2.right)==0){
			return 0;
		}
		if(isSymmetric(root1.right, root2.left)==0){
			return 0;
		}
		return 1;
	}
}
