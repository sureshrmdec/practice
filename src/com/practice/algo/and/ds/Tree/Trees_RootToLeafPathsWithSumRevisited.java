package com.practice.algo.and.ds.Tree;

import java.util.ArrayList;


/*5
/ \
4   8
/   / \
11  13  4
/  \    / \
7    2  5   1*/
public class Trees_RootToLeafPathsWithSumRevisited {

	public static void main(String[] args) {
		TreeNode f5 = new TreeNode(5);
		TreeNode f4 = new TreeNode(4);
		TreeNode e8 = new TreeNode(8);
		TreeNode e11 = new TreeNode(11);
		TreeNode t13 = new TreeNode(13);
		TreeNode f42 = new TreeNode(4);
		TreeNode s7 = new TreeNode(7);
		TreeNode t2 = new TreeNode(2);
		TreeNode f52 = new TreeNode(5);
		TreeNode o1 = new TreeNode(1);

		f5.left = f4;
		f5.right = e8;


		f4.left = e11;

		e8.left = t13;
		e8.right = f42;

		e11.left = s7;
		e11.right = t2;

		f42.left = f52;
		f42.right = o1;
		Trees_RootToLeafPathsWithSumRevisited o = new Trees_RootToLeafPathsWithSumRevisited();
		System.out.println(o.pathSum(f5, 22));

	}
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		pathSumOL(root, sum,result,new ArrayList<>());
		return result;
	}
	public void pathSumOL(TreeNode root, int sum,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> soFar) {

		if(root==null)
			return;
		if(((root.left==null && root.right==null))){
			if(sum==root.val){
				ArrayList<Integer> soFar2 = new ArrayList<>(soFar);
				soFar2.add(root.val);
				result.add(soFar2);
			}
			return;
		}
		soFar.add(root.val);
		pathSumOL(root.left, sum-root.val, result,soFar);
		pathSumOL(root.right, sum-root.val, result,soFar);
		soFar.remove(soFar.size()-1);
	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		boolean visited;
		TreeNode(int x) { val = x; }
	}

}
