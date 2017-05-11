package com.practice.algo.and.ds.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trees_BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(4);
		TreeNode one = new TreeNode(1);
		TreeNode three = new TreeNode(3);
		TreeNode six = new TreeNode(-1);
		TreeNode nine = new TreeNode(5);
		TreeNode ten = new TreeNode(1);
		TreeNode el = new TreeNode(6);
		TreeNode tw = new TreeNode(8);

		root.left = two;
		root.right = seven;

		two.left = one;

		seven.left = three;
		seven.right = six;

		one.left = nine;
		one.right = ten;

		three.right = el;
		six.right = tw;
		Trees_BinaryTreeZigzagLevelOrderTraversal o = new Trees_BinaryTreeZigzagLevelOrderTraversal();
		o.zigzagLevelOrder2(root);

	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> resultQueue = new ArrayList<>();
		if(root==null)
			return resultQueue;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		ArrayList<TreeNode> internalQueue = new ArrayList<>();
		ArrayList<Integer> resultInner = new ArrayList<>();
		boolean fromLeft = false;
		while(!queue.isEmpty()){
			TreeNode current = queue.poll();
			if(fromLeft){
				if(current.left!=null)
					internalQueue.add(0,current.left);
				if(current.right!=null)
					internalQueue.add(0,current.right);
				resultInner.add(0,current.val);
			}
			else{
				if(current.right!=null)
					internalQueue.add(0,current.right);
				if(current.left!=null)
					internalQueue.add(0,current.left);
				resultInner.add(0,current.val);
			}

			if(queue.isEmpty()){
				ArrayList<Integer> resultInner2 = new ArrayList<>();
				resultInner2.addAll(resultInner);
				queue.addAll(internalQueue);
				internalQueue.clear();
				resultQueue.add(resultInner2);
				resultInner.clear();
				fromLeft = !fromLeft;

			}

		}
		return resultQueue;

	}
	
	/*Leetcode Soln */
	private List<List<Integer>> list;

	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
	    list = new ArrayList<>();
	    helper(root,1);
	    return list;
	}


	public void helper(TreeNode root, int level){
	    if(root==null)
	        return;
	    if(list.size()<level){
	        List<Integer> curr = new ArrayList<>();
	        list.add(curr);
	    }
	    if(level % 2 ==1)
	        list.get(level-1).add(root.val);
	    else
	        list.get(level-1).add(0,root.val);
	    helper(root.left,level+1);
	    helper(root.right,level+1);
	}
	
	/* Dev Soln . Same like mine but clear and concise*/
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder3(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int level = 1;
        
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        ArrayList<Integer> list = new ArrayList<>();
        List<TreeNode> nextNodes = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node.left != null)
                nextNodes.add(node.left);

            if (node.right != null)
                nextNodes.add(node.right);
            
            if(level % 2 == 1)
                list.add(node.val);
            else
                list.add(0, node.val);

            if (queue.isEmpty()) {
                result.add(list);
                queue.addAll(nextNodes);
                list = new ArrayList<>();
                nextNodes.clear();
                level++;
            }
        }

        return result;
    }
	
	
}
