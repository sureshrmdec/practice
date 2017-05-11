package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//http://www.geeksforgeeks.org/diameter-n-ary-tree/
public class Trees_DiametersOfNaryTree {

	public static void main(String[] args) {
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
		
		o1.children.add(t2);
		o1.children.add(t3);
		o1.children.add(f4);
		
		t2.children.add(f5);
		t2.children.add(s6);
		t2.children.add(s7);
		
		f4.children.add(e8);
		f4.children.add(n9);
		
		s7.children.add(t10);
		s7.children.add(e11);
		
		e8.children.add(t12);
		
		t10.children.add(t13);
		Trees_DiametersOfNaryTree o = new Trees_DiametersOfNaryTree();
		System.out.println(o.getDiameterOfNAryBinaryTree(o1));
		

	}

	int maxResultSoFar = 0;

	TreeNode r = null;

	   
	public int getDiameterOfNAryBinaryTree(TreeNode root){
		if(r==null)
			r=root;
		if(root == null || root==null)
			return 0;

		if(root.children.isEmpty())
			return 1;

		int oneMax = 0;
		int twoMax = 0;
		for(TreeNode child : root.children){
			int  c = getDiameterOfNAryBinaryTree(child);
			if(c>oneMax){
				twoMax = oneMax;
				oneMax = c;
			}else if(c>twoMax){
				twoMax = c;
			}
		}


		maxResultSoFar = Math.max(maxResultSoFar, oneMax + twoMax + 1);
		if(r==root)
			return maxResultSoFar;
		return oneMax + 1;

	}

	static class TreeNode {
		int val;
		ArrayList<TreeNode> children = new ArrayList<TreeNode>();

		TreeNode(int x) {
			val = x; 
		}
	}
}
