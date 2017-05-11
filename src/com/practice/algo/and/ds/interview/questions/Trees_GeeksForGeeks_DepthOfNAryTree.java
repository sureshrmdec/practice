package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;
import java.util.List;

import com.practice.algo.and.ds.interview.questions.Trees_GeeksforGeeks_DiameterOfTree.TreeNode;

//http://www.geeksforgeeks.org/depth-n-ary-tree/
public class Trees_GeeksForGeeks_DepthOfNAryTree {

	public static void main(String[] args) {
		TreeNode o1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode f4 = new TreeNode(4);
		TreeNode f5 = new TreeNode(5);
		TreeNode s6 = new TreeNode(6);
		TreeNode s7 = new TreeNode(7);
		TreeNode e8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(10);
		TreeNode e11 = new TreeNode(11);
		TreeNode t12 = new TreeNode(12);
		TreeNode t13 = new TreeNode(13);
		TreeNode f14 = new TreeNode(14);
		TreeNode f15 = new TreeNode(15);
		TreeNode s16 = new TreeNode(16);
		TreeNode s17 = new TreeNode(17);
		TreeNode s18 = new TreeNode(18);
		TreeNode n19 = new TreeNode(19);

		ArrayList<TreeNode> o1Al = new ArrayList<>();
		o1Al.add(t2);
		o1Al.add(t3);
		o1Al.add(f4);
		o1Al.add(f5);
		
		o1.children = o1Al;
		
		ArrayList<TreeNode> o2Al = new ArrayList<>();
		o2Al.add(s6);
		o2Al.add(s7);
		t2.children = o2Al;
		
		ArrayList<TreeNode> o3Al = new ArrayList<>();
		o3Al.add(e8);
		o3Al.add(n9);
		o3Al.add(t10);
		t3.children = o3Al;
		
		ArrayList<TreeNode> o4Al = new ArrayList<>();
		o4Al.add(e11);
		o4Al.add(t12);
		o4Al.add(t13);
		f4.children = o4Al;
		
		ArrayList<TreeNode> o5Al = new ArrayList<>();
		o5Al.add(f14);
		s7.children = o5Al;
		
		ArrayList<TreeNode> o6Al = new ArrayList<>();
		o6Al.add(f15);
		o6Al.add(s16);
		t10.children = o6Al;
		
		ArrayList<TreeNode> o7Al = new ArrayList<>();
		o7Al.add(s17);
		o7Al.add(s18);
		t13.children = o7Al;
		
		ArrayList<TreeNode> o8Al = new ArrayList<>();
		o8Al.add(n19);
		f15.children = o8Al;
		
		
		Trees_GeeksForGeeks_DepthOfNAryTree o = new Trees_GeeksForGeeks_DepthOfNAryTree();
		System.out.println(o.depthOfNAryTree(o1));

	}
	public int depthOfNAryTree(TreeNode root){
		
		if(root==null){
			return 0;
		}
		int maxDepth = 0;
		for(TreeNode child:root.children){
			int currentChildDepth = depthOfNAryTree(child);
			maxDepth = Math.max(maxDepth, currentChildDepth);
		}
		
		return maxDepth+1;
	}
	static class TreeNode {
		int val;
		List<TreeNode> children = new ArrayList<>();
		TreeNode(int x) { val = x; }
	}
}
