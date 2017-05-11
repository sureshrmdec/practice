package com.practice.algo.and.ds.interviewbit;

import com.practice.algo.and.ds.interviewbit.Trees_identical.TreeNode;

public class Trees_IdenticalRevisited {

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
		if(!isIdentical(root1.left, root2.left))
			return false;
		if(!isIdentical(root1.right, root2.right))
			return false;
		
		return true;
		
	}
}
