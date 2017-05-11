package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Trees_ConstructBinaryTreeFromInorderAndPostorderRevisited {

	public static void main(String[] args) {
		
		Integer[] i = {4,2,8,5,9,1,6,3,10,7};
		Integer[] p = {4,8,9,5,2,6,10,7,3,1};
		ArrayList<Integer> preorder = new ArrayList<Integer>(Arrays.asList(p));
		ArrayList<Integer> inorder = new ArrayList<Integer>(Arrays.asList(i));;
		Trees_ConstructBinaryTreeFromInorderAndPostorderRevisited o = new Trees_ConstructBinaryTreeFromInorderAndPostorderRevisited();
		o.buildTree(preorder, inorder);
	}
	public TreeNode buildTree(ArrayList<Integer> postorder, ArrayList<Integer> inorder) {
		Map<Integer,Integer> indexMap = new HashMap<>();
		for(int i=0;i<inorder.size();i++){
			indexMap.put(inorder.get(i),i);
		}
		TreeNode root =  buildTree(postorder, inorder, postorder.size()-1,0, 0, inorder.size()-1,indexMap);
		return root;
	}

	public TreeNode buildTree(ArrayList<Integer> postorder, ArrayList<Integer> inorder,int postS,int postE,int inS,int inE,Map<Integer,Integer> indexMap) {
		
		if(inS>inE || postE>postS)
			return null;
		int rootVal = postorder.get(postS);
		TreeNode root = new TreeNode(rootVal);

		int index = indexMap.get(rootVal);
		int r = inE-index;
		root.left = buildTree(postorder, inorder, postS-r-1, postE, inS, index-1,indexMap);
		root.right = buildTree(postorder, inorder, postS-1, postS-r, index+1, inE,indexMap);
		
		return root;
	}
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    boolean visited;
	    TreeNode(int x) { val = x; }
	}
}
