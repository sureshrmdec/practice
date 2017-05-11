package com.practice.algo.and.ds.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;


//See Trees_RootToLeafPathsWithSumRevisited...its much cleaner
public class Trees_RoottoLeafPathsWithSum {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(3);

		one.left = two;
		one.right = three;

		two.left = four;
		three.right = five;
		Trees_RoottoLeafPathsWithSum o = new Trees_RoottoLeafPathsWithSum();
		o.pathSum(one, 7);

	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Set<TreeNode> set = new HashSet<TreeNode>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> singleC = new ArrayList<>();
		int k = 0;
		TreeNode p = root;
		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p);
				singleC.add(p.val);
				k += p.val;
				p = p.left;

			} else {
				TreeNode current = stack.peek();
				if (k == sum && current.left == null && current.right == null) {
					System.out.println("Insideee");
					ArrayList<Integer> single = new ArrayList<>(singleC);
					result.add(single);
				}
				if (current.right != null && !set.contains(current.right)) {
					p = current.right;

				}else{
					stack.pop();
					singleC.remove(singleC.size()-1);
					set.add(current);
					k -= current.val;
				}
			}
		}
		return result;
	}

	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		List<Integer> l = new ArrayList<Integer>();
		l.add(root.val);
		dfs(root, sum - root.val, result, l);
		return result;

	}

	public void dfs(TreeNode t, int sum, List<List<Integer>> result, List<Integer> l) {
		if (t.left == null && t.right == null && sum == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(l);
			result.add(temp);
		}

		// search path of left node
		if (t.left != null) {
			l.add(t.left.val);
			dfs(t.left, sum - t.left.val, result, l);
			l.remove(l.size() - 1);
		}

		// search path of right node
		if (t.right != null) {
			l.add(t.right.val);
			dfs(t.right, sum - t.right.val, result, l);
			l.remove(l.size() - 1);
		}
	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		boolean visited;
		TreeNode(int x) { val = x; }
	}
}
