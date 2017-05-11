package com.practice.algo.and.ds.interview.questions;

import java.util.Arrays;

public class Trees_LeetCode_SerializeandDeserializeBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		root.left = two;
		root.right = three;
		three.left = four;
		three.right = five;
		five.left = six;
		five.right = seven;
		Trees_LeetCode_SerializeandDeserializeBinaryTree o = new Trees_LeetCode_SerializeandDeserializeBinaryTree();
		System.out.println(o.serialize(root));
		o.deserialize("123..45......67");

	}
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		int d = maxDepth(root);
		char[] arr = new char[(int)Math.pow(2, d)];
		Arrays.fill(arr, '.');
		serializeHelper(root, arr, 1);
		String ss = new String(arr);
		ss = ss.substring(1);
		return ss;
	}

	private int maxDepth(TreeNode root) {
		if(root==null)
			return 0;
		int left = maxDepth(root.left) + 1;
		int right = maxDepth(root.right) + 1;

		return left>right?left:right;
	}
	private void serializeHelper(TreeNode root, char[] s,int i) {
		if(root==null)
			return;
		s[i] = (char)(root.val+'0');
		serializeHelper(root.left, s, 2*i);
		serializeHelper(root.right, s, 2*i+1);
	}
	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		return deserializeHelper(data,1);
	}

	private TreeNode deserializeHelper(String data, int i) {

		if(i>data.length() || data.charAt(i-1)=='.')
			return null;
		TreeNode root =new TreeNode(data.charAt(i-1)-'0');

		TreeNode left = deserializeHelper(data, 2*(i));
		TreeNode right = deserializeHelper(data, (2*i)+1);
		root.left = left;
		root.right = right;
		return root;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
