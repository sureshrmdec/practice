package com.practice.algo.and.ds.Tree;

//http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
public class Trees_GeeksforGeeks_DiameterOfTree {

	public static void main(String[] args) {
		Trees_GeeksforGeeks_DiameterOfTree o = new Trees_GeeksforGeeks_DiameterOfTree();
		TreeNode o1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode f4 = new TreeNode(4);
		TreeNode f5 = new TreeNode(5);
		TreeNode s6 = new TreeNode(6);
		TreeNode s7 = new TreeNode(7);
		TreeNode e8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(10);
		TreeNode e11 = new TreeNode(11);
		TreeNode t12 = new TreeNode(12);
		TreeNode t13 = new TreeNode(13);
		TreeNode f14 = new TreeNode(14);
		TreeNode f15 = new TreeNode(15);
		TreeNode s16 = new TreeNode(16);
		TreeNode s17 = new TreeNode(17);

		o1.left = t2;
		o1.right = t3;

		t3.left = f4;
		t3.right = f5;

		f4.left = s6;
		f4.right = s7;

		f5.right = e8;
		
		
		s6.left = n9;
		s6.right = t10;

		s7.left = e11;
		s7.right = t12;

		e8.right = t13;
		
		n9.right = f14;

		t12.left=f15;

		t13.right=s16;

		f15.left = s17;


		System.out.println(o.getDiameterOfBinaryTree(o1));

	}

	int maxResultSoFar = 0;
	TreeNode r = null;
	public int getDiameterOfBinaryTree(TreeNode root){
		if(r==null)
    		r=root;
		if(root == null)
			return 0;

		if(root.left == null && root.right==null)
			return 1;

		int leftMax = getDiameterOfBinaryTree(root.left);
		int rightMax = getDiameterOfBinaryTree(root.right);

		maxResultSoFar = Math.max(maxResultSoFar, leftMax + rightMax + 1);
		if(r==root)
			return maxResultSoFar;
		return Math.max(leftMax, rightMax) + 1;

	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
