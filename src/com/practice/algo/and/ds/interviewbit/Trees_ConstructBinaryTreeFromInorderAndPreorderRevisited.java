package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trees_ConstructBinaryTreeFromInorderAndPreorderRevisited {

	public static void main(String[] args) {
		Integer[] p = {1,2,4,5,8,9,3,6,7,10};
		Integer[] i = {4,2,8,5,9,1,6,3,10,7};
		ArrayList<Integer> preorder = new ArrayList<Integer>(Arrays.asList(p));
		ArrayList<Integer> inorder = new ArrayList<Integer>(Arrays.asList(i));;
		Trees_ConstructBinaryTreeFromInorderAndPreorderRevisited o = new Trees_ConstructBinaryTreeFromInorderAndPreorderRevisited();
		o.buildTree(preorder, inorder);
	}
	public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
		Map<Integer,Integer> indexMap = new HashMap<>();
		for(int i=0;i<inorder.size();i++){
			indexMap.put(inorder.get(i),i);
		}
		
		TreeNode root =  buildTree(preorder, inorder, 0, preorder.size()-1, 0, inorder.size()-1,indexMap);
		return root;
	}

	public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder,int preS,int preE,int inS,int inE,Map<Integer,Integer> indexMap) {
		
		if(inS>inE || preS>preE)
			return null;
		int rootVal = preorder.get(preS);
		TreeNode root = new TreeNode(rootVal);

		int index = indexMap.get(rootVal);
		int l = index-inS;
		root.left = buildTree(preorder, inorder, preS+1, preS+l, inS, index-1,indexMap);
		root.right = buildTree(preorder, inorder, preS+l+1, preE, index+1, inE,indexMap);
		
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
