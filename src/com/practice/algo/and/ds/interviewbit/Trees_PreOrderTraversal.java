package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Trees_PreOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    		
    	Stack<TreeNode> stack = new Stack<>();
    	
    	TreeNode p = root;
    	
    	while(!stack.isEmpty() || p!=null){
    		if(p!=null){
    			result.add(p.val);
    			stack.push(p);
    			p = p.left;
    		}else{
    			TreeNode current = stack.pop();
    			p=current.right;
    		}
    	}
    	
    	
    	return result;
    }
    
    // I like this ....lil better and clean
    public ArrayList<Integer> preorderTraversal2(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<>();
    	if(root==null)
    	    return result;
    	Stack<TreeNode> stack = new Stack<>();
    	
    	TreeNode p = root;
    	stack.push(root);
    	while(!stack.isEmpty()){
    		TreeNode current = stack.pop();
    		result.add(current.val);
    		
    		if(current.right!=null){
    			stack.push(current.right);
    		}
    		if(current.left!=null){
    			stack.push(current.left);
    		}    		
    	}
    	
    	
    	return result;
    }
}
