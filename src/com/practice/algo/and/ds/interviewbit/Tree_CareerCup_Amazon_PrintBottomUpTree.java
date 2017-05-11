package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*With given Binary Tree below, traverse the tree and print the tree from bottom up order 
1 
/ \ 
2 3 
/\ /\ 
4 5 6 7 

output: 4567231 

Hint: the traverse is called "Level Order Tree Traversal" 

*/
public class Tree_CareerCup_Amazon_PrintBottomUpTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode o1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode f4 = new TreeNode(4);
		TreeNode f5 = new TreeNode(5);
		TreeNode s6 = new TreeNode(6);
		TreeNode s7 = new TreeNode(7);
		TreeNode e8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);

		root.left = o1;
		root.right = t2;

		o1.left = t3;
		o1.right = f4;
		
		t2.left = f5;
		t2.right = s6;
		
		t3.left = s7;
		t3.right = e8;
		f4.left = n9;
		Tree_CareerCup_Amazon_PrintBottomUpTree o = new Tree_CareerCup_Amazon_PrintBottomUpTree();
		o.printBottomUp(root);


	}

	public void printBottomUp(TreeNode root){
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		List<TreeNode> nextNodes = new ArrayList<>();
		queue.add(root);
		result.add(root.val);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			
			if(node.left!=null)
				nextNodes.add(node.left);
			if(node.right!=null)
				nextNodes.add(node.right);
			
			if(queue.isEmpty()){
				queue.addAll(nextNodes);
				for(int i =nextNodes.size()-1;i>=0;i--){
					result.add(0, nextNodes.get(i).val);
				}
				nextNodes.clear();
			}
		}
	}
}
