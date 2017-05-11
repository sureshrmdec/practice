package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

import com.practice.algo.and.ds.interviewbit.Trees_RecoverBinarySearchTreeRevisited.TreeNode;

public class Trees_PostOrderTraversal {
	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		//root.left = two;
		root.right = three;
		Trees_PostOrderTraversal o = new Trees_PostOrderTraversal();
		System.out.println(o.postorderTraversal(root));
	
	}
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
    		
    	Stack<TreeNode> stack = new Stack<>();
    	
    	TreeNode p = root;
    	
    	while(!stack.isEmpty() || p!=null){
    		if(p!=null){
    			stack.push(p);
    			p = p.left;
    		}else{
    			TreeNode current = stack.peek();
    			if(current.right!=null){
    				p=current.right;
    				current.right = null;
    			}else{
    			TreeNode top = stack.pop();
    			result.add(top.val);
    			}
    		}
    	}
    	
    	
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

