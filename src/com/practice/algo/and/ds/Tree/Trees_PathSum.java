package com.practice.algo.and.ds.Tree;

import com.practice.algo.and.ds.Tree.Trees_VerticalOrderTraversalofBT.TreeNode;

public class Trees_PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean hasPathSumB(TreeNode root, int sum) {
        if(root==null)
            return false;
        if(sum==root.val && ((root.left==null && root.right==null))){
    		return true;
    	}
    	
    	
    	boolean left = hasPathSumB(root.left, sum-root.val);
    	boolean right = hasPathSumB(root.right, sum-root.val);
    	return left || right;
    
    }
    
    public int hasPathSum(TreeNode root, int sum) {
    	
    	return hasPathSumB(root, sum)?1:0;
    }
    
    
    
    
    
    
    
    
    
    /* starting from 0 and reaching target */
    public boolean hasPathSumBRe(TreeNode root, int sum,int target) {
        if(root==null)
            return false;
        if(sum+root.val==target && ((root.left==null && root.right==null))){
    		return true;
    	}
    	
    	
    	boolean left = hasPathSumBRe(root.left, sum+root.val,target);
    	boolean right = hasPathSumBRe(root.right, sum+root.val,target);
    	return left || right;
    
    }
    
    public int hasPathSumRe(TreeNode root, int sum) {
    	
    	return hasPathSumBRe(root, 0,sum)?1:0;
    }
    
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    
}
