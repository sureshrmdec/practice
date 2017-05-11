package com.practice.algo.and.ds.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.practice.algo.and.ds.Tree.Trees_InorderTraversalCartesianTree.TreeNode;

public class Trees_InOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode p = root;
    	while(!stack.isEmpty() || p!=null){
    		if(p!=null){
    			stack.push(p);
    			p = p.left;
    		}else{
    			p = stack.pop();
    			result.add(p.val);
    			p = p.right;
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
