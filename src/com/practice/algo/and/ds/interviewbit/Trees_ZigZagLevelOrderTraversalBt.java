package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.practice.algo.and.ds.interviewbit.Trees_RecoverBinarySearchTreeRevisited.TreeNode;

public class Trees_ZigZagLevelOrderTraversalBt {

	public static void main(String[] args) {
		TreeNode s7 = new TreeNode(7);
		TreeNode t3 = new TreeNode(3);
		TreeNode t10 = new TreeNode(10);
		TreeNode t2 = new TreeNode(2);
		TreeNode f5 = new TreeNode(5);
		TreeNode e8 = new TreeNode(8);
		TreeNode f14 = new TreeNode(14);
		TreeNode o1 = new TreeNode(1);
		TreeNode f4 = new TreeNode(4);
		TreeNode s6 = new TreeNode(6);
		TreeNode n9 = new TreeNode(9);
		TreeNode t12 = new TreeNode(12);
		TreeNode f15 = new TreeNode(15);
		TreeNode t13 = new TreeNode(13);

		s7.left = t3;
		s7.right = t10;

		t3.left = t13;
		t3.right = f5;

		t10.left = e8;
		t10.right = f14;

		t13.left = o1;


		f5.left = f4;
		f5.right = s6;


		e8.right = n9;

		f14.left = t12;
		f14.right = f15;

		t12.right = t2;

		Trees_ZigZagLevelOrderTraversalBt o = new Trees_ZigZagLevelOrderTraversalBt();
		System.out.println(o.zigzagLevelOrder(s7));

	}
	
	/*------------ Another Way START*/
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> zigzagLevelOrderRec(TreeNode root) {
        helper(root, 1);
        return result;
    }

    public void helper(TreeNode node, int level) {
        if(node == null)
            return;
        
        ArrayList<Integer> levelList = null;
        if(result.size() < level){
            levelList = new ArrayList<>();
            result.add(levelList);
        } else{
            levelList = result.get(level-1);
        }
        
        if(level % 2 == 1)
            levelList.add(node.val);
        else
            levelList.add(0, node.val);
        
        helper(node.left, level+1);
        helper(node.right, level+1);
        
    }
    /*------------ Another Way END*/
    
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		Queue<TreeNode> innerQueue = new LinkedList<>();
		boolean rightToLeft = true;

		ArrayList<Integer> ro = new ArrayList<>();
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node.left!=null){
				innerQueue.add(node.left);
				ro.add(node.left.val);
			}
			if(node.right!=null){
				innerQueue.add(node.right);
				ro.add(node.right.val);
			}
			if(queue.isEmpty()){
				queue.addAll(innerQueue);
				innerQueue.clear();
				if(ro.size()>0){
					ArrayList<Integer> r = new ArrayList<>();
					if(rightToLeft){
						for(int i=ro.size()-1;i>=0;i--){
							r.add(ro.get(i));
						}

					}else{
						r.addAll(ro);
					}
					result.add(r);
					ro.clear();
				}
				rightToLeft = !rightToLeft;

			}

		}



		return result;
	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		boolean visited;
		TreeNode(int x) { val = x; }
	}

}
