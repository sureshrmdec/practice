package com.practice.algo.and.ds.interviewbit;

import java.util.Stack;

import com.practice.algo.and.ds.interviewbit.Trees_LowestCommonAncestorofaBinaryTree.TreeNode;

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
		
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> dstack = new Stack<>();
		boolean popNow = false;
		TreeNode p = root;
		while(!stack.isEmpty() || p!=null){
			
			if(p!=null){
				stack.push(p);
				dstack.push(p.val);
				p = p.left;
			}else{
				if(popNow)
					return stack.peek();
				p = stack.pop();
				if(p.val==b){
					popNow = true;
				}
				//System.out.println(dstack.pop());
				p = p.right;
			}
		}
		return stack.peek();
	}
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}

