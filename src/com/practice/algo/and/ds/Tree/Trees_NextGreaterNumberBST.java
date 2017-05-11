package com.practice.algo.and.ds.Tree;

import java.util.Stack;


public class Trees_NextGreaterNumberBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode two = new TreeNode(3);
		TreeNode three = new TreeNode(8);
		TreeNode four = new TreeNode(2);
		TreeNode five = new TreeNode(4);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode nine = new TreeNode(9);
		/*root.left = two;
		root.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = nine;
		six.right = seven;*/
		Trees_NextGreaterNumberBST o = new Trees_NextGreaterNumberBST();
		System.out.println(o.getSuccessor(root, 5).val);

	}
	public TreeNode getSuccessor(TreeNode root, int b) {
	    
		TreeNode result = null;
		while(root!=null){
		    if(root.val > b){
		        result = root;
		        root = root.left;
		    }else{
		        root = root.right;
		    }
		}

		return result;
	}
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}

