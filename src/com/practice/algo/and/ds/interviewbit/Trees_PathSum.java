package com.practice.algo.and.ds.interviewbit;

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
}
