package com.practice.algo.and.ds.Tree;

public class Trees_BalancedBinaryTreeRevisited {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		
		root.left = two;
		root.right = three;
		
		two.left = four;
		four.left = five;
		five.left = six;
		
		Trees_BalancedBinaryTreeRevisited o = new Trees_BalancedBinaryTreeRevisited();
		System.out.println(o.isBalanced(root));

	}

	public boolean isBalanced(TreeNode node){
		
		if(isBalancedOverLoaded(node)==-1){
			return false;
		}
		return true;
	}
	
	private int isBalancedOverLoaded(TreeNode node){
		if(node==null)
			return 0;
		
		int leftTree = isBalancedOverLoaded(node.left);
		if(leftTree==-1){
			return -1;
		}
		leftTree += 1;
		
		int rightTree = isBalancedOverLoaded(node.right);
		if(rightTree==-1){
			return -1;
		}
		rightTree += 1;
		
		if(Math.abs(leftTree-rightTree)>1){
			return -1;
		}
		
		return leftTree>rightTree?leftTree:rightTree;
	}
	
	
}

