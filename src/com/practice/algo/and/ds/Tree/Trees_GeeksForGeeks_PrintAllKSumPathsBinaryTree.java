package com.practice.algo.and.ds.Tree;

import java.util.ArrayList;


//http://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
public class Trees_GeeksForGeeks_PrintAllKSumPathsBinaryTree {

	public static void main(String[] args) {
		TreeNode o1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(-1);
		TreeNode f4 = new TreeNode(2);
		TreeNode f5 = new TreeNode(1);
		TreeNode s6 = new TreeNode(4);
		TreeNode s66 = new TreeNode(5);
		TreeNode s7 = new TreeNode(1);
		TreeNode e8 = new TreeNode(1);
		TreeNode n9 = new TreeNode(2);
		TreeNode t10 = new TreeNode(6);

		o1.left = t2;
		o1.right = t3;

		t2.left = f4;
		t2.right = f5;

		t3.left = s6;
		t3.right = s66;

		f5.left = s7;
		s6.left = e8;
		s6.right = n9;

		s66.right = t10;
		
		Trees_GeeksForGeeks_PrintAllKSumPathsBinaryTree o = new Trees_GeeksForGeeks_PrintAllKSumPathsBinaryTree();
		o.printSumPaths(o1, 5);
	}

	ArrayList<Integer> path = new ArrayList<>();

	public void printSumPaths(TreeNode root,int k){
		if(root == null)
			return;
		path.add(root.val);
		printSumPaths(root.left,k);

		printSumPaths(root.right,k);
		checkSum(path, k);
		path.remove(path.size()-1);
	}
	private void checkSum(ArrayList<Integer> path,int k) {
		int sum = 0;
		ArrayList<Integer> list2 = new ArrayList<>();
		for(int i= path.size()-1;i>=0;i--){
			int e = path.get(i); 
			sum+=e;
			list2.add(e);
			if(sum==k){
				System.out.println(list2);
			}
		}
	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
