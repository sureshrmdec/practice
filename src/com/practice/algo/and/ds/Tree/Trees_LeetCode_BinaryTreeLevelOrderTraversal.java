package com.practice.algo.and.ds.Tree;

import java.util.ArrayList;
import java.util.List;

public class Trees_LeetCode_BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private List<List<Integer>> list;

	public List<List<Integer>> levelOrder(TreeNode root) {
		list = new ArrayList<>();
		helper(root,1);
		return list;
	}


	public void helper(TreeNode root, int level){
		if(root==null)
			return;
		if(list.size()<level){
			List<Integer> curr = new ArrayList<>();
			list.add(curr);
		}
		list.get(level-1).add(root.val);

		helper(root.left,level+1);
		helper(root.right,level+1);
	}
}
