package com.practice.algo.and.ds.interviewbit;

import java.util.List;

public class Trees_InorderTraversalCartesianTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trees_InorderTraversalCartesianTree o = new Trees_InorderTraversalCartesianTree();
		Integer[] a = {5,10,40,33,30,50,35};
		//o.makeTree(a);
	}

	
	public TreeNode buildTree(List<Integer> nums) {	
		TreeNode root = null;
		
		for(int i=0;i<nums.size();i++){
			
			if(root==null){
				root = new TreeNode(nums.get(i));
			}else{
				if(nums.get(i)>root.val){
					TreeNode newRoot = new TreeNode(nums.get(i));
					newRoot.left = root;
					root = newRoot;
				}else{
					TreeNode parent = root;
					TreeNode rightChild = new TreeNode(nums.get(i));
					if(root.right==null)
						root.right = rightChild;
					else{
						parent = root;
						TreeNode r = root.right;
						while(r!=null && r.val>rightChild.val){
							parent = r;
							r = r.right;
						}
						if(r==null){
							parent.right = rightChild;
						}else{
							parent.right = rightChild;
							rightChild.left = r;
						}

						
					}
				}
			}
			
			
		}
		
		
		
		return root;
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
