package com.practice.algo.and.ds.Tree;

public class Trees_IsValidBTaBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int isValidBST(TreeNode a) {
		return helper(a,Integer.MIN_VALUE,Integer.MAX_VALUE)?1:0;
	}
	private boolean helper(TreeNode a, int minValue, int maxValue) {
		// TODO Auto-generated method stub
		if(a==null)
			return true;
		if(a.val<=minValue || a.val>=maxValue){
			return false;
		}
		return helper(a.left, minValue,a.val) & helper(a.right, a.val,maxValue); 
		
		
	}
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
