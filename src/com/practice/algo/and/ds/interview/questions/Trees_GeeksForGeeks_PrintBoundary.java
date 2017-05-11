package com.practice.algo.and.ds.interview.questions;

public class Trees_GeeksForGeeks_PrintBoundary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		Trees_GeeksForGeeks_PrintBoundary o = new Trees_GeeksForGeeks_PrintBoundary();
		o.printBoundary(root);
	}

	public void printBoundary(TreeNode root){
		TreeNode r = root;

		printLeft(root);
		printLeaves(root);

		printRight(root.right);		
	}
	private void printLeft(TreeNode root) {
		if(root.left!=null){
			System.out.println(root.val);
			printLeft(root.left);
		}else if(root.right!=null){
			System.out.println(root.val);
			printLeft(root.right);
		}
	}

	private void printRight(TreeNode root) {
		if(root.right!=null){
			printRight(root.right);
			System.out.println(root.val);
		}else if(root.left!=null){
			printRight(root.left);
			System.out.println(root.val);
		}
	}
	private void printLeaves(TreeNode root) {
		if(root==null)
			return;
		if(root.left==null && root.right==null){
			System.out.println(root.val);
		}
		printLeaves(root.left);
		printLeaves(root.right);

	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
