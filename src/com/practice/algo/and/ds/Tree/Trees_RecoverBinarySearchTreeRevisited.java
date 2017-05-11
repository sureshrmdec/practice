package com.practice.algo.and.ds.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class Trees_RecoverBinarySearchTreeRevisited {

	public static void main(String[] args) {
		TreeNode s7 = new TreeNode(7);
		TreeNode t3 = new TreeNode(3);
		TreeNode t10 = new TreeNode(10);
		TreeNode t2 = new TreeNode(2);
		TreeNode f5 = new TreeNode(5);
		TreeNode e8 = new TreeNode(8);
		TreeNode f14 = new TreeNode(14);
		TreeNode o1 = new TreeNode(1);
		TreeNode f4 = new TreeNode(4);
		TreeNode s6 = new TreeNode(6);
		TreeNode n9 = new TreeNode(9);
		TreeNode t12 = new TreeNode(12);
		TreeNode f15 = new TreeNode(15);
		TreeNode t13 = new TreeNode(13);

		s7.left = t3;
		s7.right = t10;
		
		t3.left = t13;
		t3.right = f5;
		
		t10.left = e8;
		t10.right = f14;
		
		t13.left = o1;
		
		
		f5.left = f4;
		f5.right = s6;
		
		
		e8.right = n9;
		
		f14.left = t12;
		f14.right = f15;
		
		t12.right = t2;
		
		Trees_RecoverBinarySearchTreeRevisited o = new Trees_RecoverBinarySearchTreeRevisited();
		System.out.println(o.recoverTree(s7));

	}
	private ArrayList<Integer> recoverTree(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		TreeNode first=null;
		TreeNode second=null;
		TreeNode prev=null;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while(!stack.isEmpty() || p!=null){
			if(p!=null){
				stack.push(p);
				p = p.left;
			}else{
				p = stack.pop();
				if(prev!=null && prev.val>p.val){
					if(first==null){
						first = prev;
					}
					second = p;
				}
				prev = p;
				p = p.right;
			}
		}
		result.add(second.val);
		result.add(first.val);
		
		return result;
		
	}
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    boolean visited;
	    TreeNode(int x) { val = x; }
	}
}
