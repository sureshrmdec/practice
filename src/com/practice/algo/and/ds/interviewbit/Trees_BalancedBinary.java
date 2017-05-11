package com.practice.algo.and.ds.interviewbit;

public class Trees_BalancedBinary {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		
		root.left = two;
		root.right = three;
		
		two.left = four;
		four.left = five;
		five.left = six;
		
		Trees_BalancedBinary o = new Trees_BalancedBinary();
		System.out.println(o.isBalanced(root));

	}

	public boolean isBalanced(TreeNode node){
		
		return isBalancedOL(node)==-1?false:true;
		
	}

	private int isBalancedOL(TreeNode node) {
		// TODO Auto-generated method stub
		if(node==null)
			return 0;
		
		int left = isBalancedOL(node.left);
		if(left==-1)
			return -1; //to optimize..if you found left unbalanced...return from here only
		int right = isBalancedOL(node.right);
		if(right==-1)
			return -1; //to optimize..if you found right unbalanced...return from here only

		if(Math.abs(left-right)>1)
			return -1;
		
		return Math.max(left, right)+1;
	}
}
