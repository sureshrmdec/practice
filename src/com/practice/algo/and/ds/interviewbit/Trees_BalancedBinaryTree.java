package com.practice.algo.and.ds.interviewbit;

public class Trees_BalancedBinaryTree {

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
		
		Trees_BalancedBinaryTree o = new Trees_BalancedBinaryTree();
		System.out.println(o.isBalanced(root));

	}
	
	public boolean isBalanced(TreeNode root){
		
		if(root==null)
			return true;

		boolean leftBalanced = isBalanced(root.left);
		boolean rightBalanced = isBalanced(root.right);
		
		int leftChild = 0;
		if(root.left != null){
			leftChild++;
			if(root.left.left != null){
				leftChild++;
			}
		}
		
		int rightChild = 0;
		if(root.right != null){
			rightChild++;
			if(root.right.right != null){
				rightChild++;
			}
		}
		
		int diff = Math.abs(rightChild-leftChild);
		
		
		if(leftBalanced && rightBalanced && diff < 2)
			return true;
		
		return false;
	}
	
	private int isBalancedB(TreeNode root){
		
		if(root==null){
			return 0;
		}
		
		int left = 1 +  isBalancedB(root.left);
		int right = 1 + isBalancedB(root.right);
		if(Math.abs(left-right)>1){
			return -1;
		}
		return 0;
	}
	
	
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    boolean visited;
    TreeNode(int x) { val = x; }
}
