package com.practice.algo.and.ds.dp;

import java.util.LinkedList;
import java.util.List;

public class DP_UniqueBinarySearchTreesIILeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DP_UniqueBinarySearchTreesIILeetCode o = new DP_UniqueBinarySearchTreesIILeetCode();
		o.generateTrees(4);
	}
	public List<TreeNode> generateTrees(int n) {
		return generateSubtrees(1, n);
	}

	private List<TreeNode> generateSubtrees(int s, int e) {
		List<TreeNode> res = new LinkedList<TreeNode>();
		if (s > e) {
			res.add(null); // empty tree
			return res;
		}

		for (int i = s; i <= e; ++i) {
			List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
			List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);

			for (TreeNode left : leftSubtrees) {
				for (TreeNode right : rightSubtrees) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}
		}
		return res;
	}
	static public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
}
