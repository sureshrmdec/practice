package com.practice.algo.and.ds.interviewbit;

import com.practice.algo.and.ds.interviewbit.Trees_Symmetric.TreeNode;

public class Trees_SortedArrayToBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trees_SortedArrayToBST o = new Trees_SortedArrayToBST();
		int[] aa = {1,2,3,4,5,6,7,8,9};
		o.makeBST(aa);
	}

	public TreeNode makeBST(int[] array){
		 return makeBSTOl(array,0,array.length-1);
	}

	public TreeNode makeBSTOl(int[] array,int l,int r){
		
		if(l>r){
			return null;
		}
		int mid = (l+r)/2;

		TreeNode root = new TreeNode(array[mid]);
		root.left = makeBSTOl(array, l, mid-1);
		root.right = makeBSTOl(array, mid+1, r);


		return root;
	}


	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
