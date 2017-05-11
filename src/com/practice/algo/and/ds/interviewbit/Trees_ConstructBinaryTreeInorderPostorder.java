package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trees_ConstructBinaryTreeInorderPostorder {

	public static void main(String[] args) {
		Integer[] in = {2,0,1,5,3,6};
		Integer[] post = {0,2,5,6,3,1};
		ArrayList<Integer> inorder = new ArrayList<Integer>(Arrays.asList(in));
		ArrayList<Integer> postorder = new ArrayList<Integer>(Arrays.asList(post));;
		Trees_ConstructBinaryTreeInorderPostorder o = new Trees_ConstructBinaryTreeInorderPostorder();
		o.buildTree(inorder,postorder);


	}
	
	public TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
		
		
		Map<Integer,Integer> indexMap = new HashMap<>();
		for(int i=0;i<inorder.size();i++){
			indexMap.put(inorder.get(i),i);
		}
		TreeNode root = buildTree(postorder.size()-1 ,0 ,0,inorder.size()-1,postorder, inorder,indexMap);
		
		return root;
		
		
	}
	
	private TreeNode buildTree(int postStart,int postEnd, int inStart,int inEnd,List<Integer> postorder, List<Integer> inorder,Map<Integer,Integer> indexMap){

		if(inStart>inEnd || postStart<postEnd){
			return null;
		}
		int val = postorder.get(postStart);
		TreeNode root = new TreeNode(val);
		int index = indexMap.get(val);
		int r = inEnd - index;
		
		root.left = buildTree(postStart-r-1 ,postEnd ,inStart,index-1,postorder, inorder,indexMap);
		root.right = buildTree(postStart-1 , postStart-r,index+1,inEnd,postorder, inorder,indexMap);
		
		return root;
		
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        
		List<Integer> postorderList = new ArrayList<>();
		List<Integer> inorderList = new ArrayList<>();
    
    for (int i = 0; i < inorder.length; i++) {
    	inorderList.add(inorder[i]);
    	postorderList.add(postorder[i]);
    }
    
    return buildTree(inorderList, postorderList);
    
        
    }

}
