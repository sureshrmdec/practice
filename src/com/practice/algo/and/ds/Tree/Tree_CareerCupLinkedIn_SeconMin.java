package com.practice.algo.and.ds.Tree;

import com.practice.algo.and.ds.Tree.Trees_2SumBinaryTree.TreeNode;

//https://www.careercup.com/question?id=5196022759292928

/** 
 * A tournament tree is a binary tree 
 * where the parent is the minimum of the two children. 
 * Given a tournament tree find the second minimum value in the tree. 
 * A node in the tree will always have 2 or 0 children. 
 * Also all leaves will have distinct and unique values. 
 * 	   	   2 
 *  	 /  \ 
 *   	2    4 
 *     / \  / \ 
 * 	  3   2 5  4 
 * 
 * In this given tree the answer is 3. 
 */

public class Tree_CareerCupLinkedIn_SeconMin {

	public static void main(String[] args) {
		Tree_CareerCupLinkedIn_SeconMin o = new Tree_CareerCupLinkedIn_SeconMin();
		TreeNode root = new TreeNode(2);
		TreeNode three = new TreeNode(2);
		TreeNode eight = new TreeNode(4);
		TreeNode two = new TreeNode(3);
		TreeNode four = new TreeNode(2);
		TreeNode seven = new TreeNode(5);
		TreeNode nine = new TreeNode(4);
		
		root.left = three;
		root.right = eight;
		
		three.left = two;
		three.right = four;
		
		eight.left = seven;
		eight.right = nine;
		
		System.out.println(o.secondMin(root));

	}

	public Integer secondMin(TreeNode root){

		if(root.left==null && root.right==null)
			return Integer.MAX_VALUE;

		int min = 0;
		if(root.val == root.left.val){
			min = root.right.val;
			root = root.left;
		}else{
			min = root.left.val;
			root = root.right;
		}
		return Math.min(min, secondMin(root));


	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
