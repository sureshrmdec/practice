package com.practice.algo.and.ds.Tree;

import java.util.ArrayList;


// SEE Trees_RecoverBinarySearchTreeRevisited....inorder without recursion
public class Trees_RecoverBinarySearchTree {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(1);

		one.right = three;
		three.left = two;
		Trees_RecoverBinarySearchTree o = new Trees_RecoverBinarySearchTree();
		o.recoverTree(one);

	}

	
	TreeNode first;
	TreeNode second;
	TreeNode prev;
	
	
	private TreeNode inOrder(TreeNode root){
		if(root==null)
			return null;
		
		inOrder(root.left);
		if(prev==null)
			prev=root;
		else{
			if(prev.val>root.val){
				if(first==null){
					first = root;
				}
				second = root;
			}
			prev = root;
		}
		
		inOrder(root.right);
		
		return null;
	}
	
	public void recoverTree(TreeNode root) {

		inOrder(root);
		int temp = first.val;
		first.val = second.val;
		second.val = temp;	
	}
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    boolean visited;
	    TreeNode(int x) { val = x; }
	}

}
