package com.practice.algo.and.ds.dp;

public class DP_MaxSumPathinBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(-2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(1);
		TreeNode six = new TreeNode(5);
		TreeNode seven = new TreeNode(6);
		//two.left = four;
		//two.right = five;
		//three.left = six;
		//three.right = seven;
		root.left = two;
		root.right = three;
		DP_MaxSumPathinBinaryTree o = new DP_MaxSumPathinBinaryTree();
		System.out.println(o.maxPathSum(root));

	}
	TreeNode r = null;
	int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
    	if(r==null)
    		r=root;
    	if(root==null)
    		return 0;
    	//int result = 0;
    	int leftS = maxPathSum(root.left);
    	int rightS = maxPathSum(root.right);
    	int rootVal = root.val;
    	
    	int p1 = leftS+rightS+rootVal;//All three
    	int option1 = leftS+rootVal;
    	int option2 = rightS+rootVal;
    	int option3 = rootVal;
    	
    	result = Math.max(result, Math.max(p1, Math.max(option1, Math.max(option2, option3))));
    	int up = Math.max(option1, Math.max(option2, option3));
    	if(r==root)
    		return result;
    	return up;
    }
    static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
    
    /* Another soln from Leetcode */
    //I will revise this one
    int maxValue;
    
    public int maxPathSumLeet(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left)); //for handling -ve values, compare it with zero
        int right = Math.max(0, maxPathDown(node.right)); //for handling -ve values, compare it with zero
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
    
    
}
