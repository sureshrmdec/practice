package com.practice.algo.and.ds.Tree;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class Trees_SumRoottoLeafNumbers {

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
		Trees_SumRoottoLeafNumbers o = new Trees_SumRoottoLeafNumbers();
		System.out.println(o.sumNumbers(f5));
	}

	 int MOD = 100003;
	    
	    public int sumNumbers(TreeNode A) {
	        return sum(A, 0) % MOD;
	    }
	    
	    public int sum(TreeNode node, int num) {
	        
	        if (node == null)
	            return 0;
	        
	        num = num * 10 + node.val;
	        num %= MOD;
	        
	        if (node.left == null && node.right == null) {
	            return num;
	        }
	        
	        int leftSum = sum(node.left, num);
	        int rightSum = sum(node.right, num);
	        
	        return (leftSum + rightSum) % MOD;
	        
	    }
		static class TreeNode {
		    int val;
		    TreeNode left;
		    TreeNode right;
		    boolean visited;
		    TreeNode(int x) { val = x; }
		}
}
