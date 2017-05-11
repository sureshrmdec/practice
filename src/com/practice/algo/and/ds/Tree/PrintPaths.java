package com.practice.algo.and.ds.Tree;

import com.practice.algo.and.ds.graph.Graphs_LevelOrder.TreeNode;

public class PrintPaths {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(7);
		TreeNode one = new TreeNode(1);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(6);
		TreeNode nine = new TreeNode(9);
		
		root.left = two;
		root.right = seven;
		
		two.left = one;
		two.right = three;
		
		seven.left = six;
		seven.right = nine;
		PrintPaths p = new PrintPaths();
		p.printPath(root);

	}
	public void printPath(TreeNode root){
		printPathHelper(root,new StringBuilder());
	}
	private void printPathHelper(TreeNode root,StringBuilder sb) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		if(root.left==null && root.right==null){
			sb.append(root.val);
			System.out.println(sb.toString());
			sb.deleteCharAt(sb.length()-1);
			return;
		}

		sb.append(root.val);
		if(root.left!=null)
			printPathHelper(root.left, sb);
		if(root.right!=null)
			printPathHelper(root.right, sb);
		sb.deleteCharAt(sb.length()-1);
		
	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
