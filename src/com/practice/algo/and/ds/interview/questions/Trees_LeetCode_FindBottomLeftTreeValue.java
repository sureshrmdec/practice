package com.practice.algo.and.ds.interview.questions;

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
        Queue<TreeNode> innerQueue = new LinkedList<TreeNode>();
        int result = 0;
        result = root.val;
        while(!queue.isEmpty()){
        	
        	TreeNode current = queue.poll();
        	if(current.left!=null)
        		innerQueue.add(current.left);
        	if(current.right!=null)
        		innerQueue.add(current.right);
        	if(queue.isEmpty()){
        		queue.addAll(innerQueue);
        		innerQueue.clear();
        		if(!queue.isEmpty())
        			result = queue.peek().val;
        	}
        }
        return result;
    }
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
