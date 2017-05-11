package com.practice.algo.and.ds.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trees_ConstructBinaryTreeFromInorderAndPreorder {

	public static void main(String[] args) {
		Integer[] p = {1,2,3};
		Integer[] i = {1,3,2};
		ArrayList<Integer> preorder = new ArrayList<Integer>(Arrays.asList(p));
		ArrayList<Integer> inorder = new ArrayList<Integer>(Arrays.asList(i));;
		Trees_ConstructBinaryTreeFromInorderAndPreorder o = new Trees_ConstructBinaryTreeFromInorderAndPreorder();
		o.buildTree(preorder, inorder);
	}

	public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
		
		
		Map<Integer,Integer> indexMap = new HashMap<>();
		for(int i=0;i<inorder.size();i++){
			indexMap.put(inorder.get(i),i);
		}
		TreeNode root = buildTree(0 , preorder.size()-1,0,inorder.size()-1,preorder, inorder,indexMap);
		
		return root;
		
		
	}
	
	private TreeNode buildTree(int preStart,int preEnd, int inStart,int inEnd,List<Integer> preorder, List<Integer> inorder,Map<Integer,Integer> indexMap){

		if(inStart>inEnd || preStart>preEnd){
			return null;
		}
		int val = preorder.get(preStart);
		TreeNode root = new TreeNode(val);
		int index = indexMap.get(val);
		int l = index-inStart;
		root.left = buildTree(preStart+1 ,preStart+l ,inStart,index-1,preorder, inorder,indexMap);
		root.right = buildTree(preStart+l+1 , preEnd,index+1,inEnd,preorder, inorder,indexMap);
		
		return root;
		
	}
	
	private TreeNode buildTree(int preStart,int preEnd, int inStart,int inEnd,int[] preorder, int[] inorder){
		List<Integer> preorderList = new ArrayList<>();
		List<Integer> inorderList = new ArrayList<>();
    
    for (int i = 0; i < preorder.length; i++) {
        preorderList.add(preorder[i]);
        inorderList.add(inorder[i]);
    }
    
    return buildTree(preorderList, inorderList);
    }
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    boolean visited;
	    TreeNode(int x) { val = x; }
	}
}
