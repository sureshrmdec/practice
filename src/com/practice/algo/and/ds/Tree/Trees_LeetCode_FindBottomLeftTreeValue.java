package com.practice.algo.and.ds.Tree;

import java.util.LinkedList;
import java.util.Queue;

import com.practice.algo.and.ds.interviewbit.Trees_RecoverBinarySearchTree;

public class Trees_LeetCode_FindBottomLeftTreeValue {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(2);
		TreeNode two = new TreeNode(1);
		TreeNode three = new TreeNode(3);

		one.left = two;
		one.right = three;
		Trees_LeetCode_FindBottomLeftTreeValue o = new Trees_LeetCode_FindBottomLeftTreeValue();
		System.out.println(o.findBottomLeftValue(one));

	}
	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int result = 0;
		result = root.val;
		while(!queue.isEmpty()){
			result = queue.peek().val;
			int size = queue.size();
			for(int i=0;i<size;i++){
				TreeNode current = queue.poll();
				if(current.left!=null)
					queue.add(current.left);
				if(current.right!=null)
					queue.add(current.right);
			}
		}
		return result;
	}
	
	//Too good
	public int findLeftMostNode(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        root = queue.poll();
	        if (root.right != null)
	            queue.add(root.right);
	        if (root.left != null)
	            queue.add(root.left);
	    }
	    return root.val;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
