package com.practice.algo.and.ds.interviewbit;

import java.util.Stack;

public class Trees_BstIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trees_BstIterator o = new Trees_BstIterator();
		TreeNode root = new TreeNode(5);
		TreeNode three = new TreeNode(3);
		TreeNode eight = new TreeNode(8);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode seven = new TreeNode(7);
		TreeNode nine = new TreeNode(9);

		root.left = three;
		root.right = eight;

		three.left = two;
		three.right = four;

		eight.left = seven;
		eight.right = nine;



	}
	public Trees_BstIterator(){}
	public Trees_BstIterator(TreeNode root) {

		push(root);
	}
	private void push(TreeNode root){
		while(root!=null){
			stack.push(root);
			root = root.left;
		}
	}
	Stack<TreeNode> stack = new Stack<TreeNode>();
	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		if(hasNext()){
			TreeNode top = stack.pop();
			push(top.right);
			return top.val;
		}

		return -1;
	}

}
