package com.practice.algo.and.ds.interviewbit;

import com.practice.algo.and.ds.interviewbit.Trees_SortedArrayToBST.TreeNode;

public class Trees_SortedArrayToBalancedBSTRevisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trees_SortedArrayToBalancedBSTRevisited o = new Trees_SortedArrayToBalancedBSTRevisited();
		int[] aa = {1,2,3,4,5,6,7,8,9};
		o.makeBST(aa);
	}

	public TreeNode makeBST(int[] array){
		 return makeBSTOl(array,0,array.length-1);
	}
	TreeNode root = null;
	private TreeNode makeBSTOl(int[] array, int i, int j) {
		if(i>j)
			return null;
		TreeNode node;
		int mid = (i+j)/2;
		node = new TreeNode(array[mid]);

		node.left = makeBSTOl(array, i, mid-1);
		node.right = makeBSTOl(array, mid+1, j);
		
		return node;
	}
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
