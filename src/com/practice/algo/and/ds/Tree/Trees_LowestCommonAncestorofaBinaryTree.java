package com.practice.algo.and.ds.Tree;

import java.util.Stack;

public class Trees_LowestCommonAncestorofaBinaryTree {

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
		two.left = four;
		two.right = five;
		three.left = six;
		five.left = seven;
		Trees_LowestCommonAncestorofaBinaryTree o = new Trees_LowestCommonAncestorofaBinaryTree();
		System.out.println(o.lowestCommonAncestorRevisited(root, 4,7).val);
		o.serialize(root);

	}
	public String serialize(TreeNode root) {
	    if(root==null)
	        return null;
	 
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	    StringBuilder sb = new StringBuilder();
	 
	    while(!stack.isEmpty()){
	        TreeNode h = stack.pop();   
	        if(h!=null){
	            sb.append(h.val+",");
	            stack.push(h.right);
	            stack.push(h.left);  
	        }else{
	            sb.append("#,");
	        }
	    }
	 
	    return sb.toString().substring(0, sb.length()-1);
	}
	//This method asssumes p and q are present in the tree
	public TreeNode lowestCommonAncestorRevisited(TreeNode root, int p, int q) {
		 
		 if(root==null)
			 return null;
		 if(root.val==p || root.val==q){
			 return root;
		 }
		 TreeNode left = lowestCommonAncestorRevisited(root.left, p, q);
		 TreeNode right = lowestCommonAncestorRevisited(root.right, p, q);
		 
		 if(left!=null && right!=null)
			 return root;
		 return left!=null?left:right;
		 
		 
	 }
	
	
	//http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
	//Thanks to Dhruv for suggesting this extended solution.
	//See this extended soln for case where p or q might be missing
	
	
	//a and b to check whether values are found or not!

    boolean a = false;
	boolean b = false;
	
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
    	if(root==null)
    		return null;

    	TreeNode lca = null; //if  p or q is the parent of q or p respectively
    	
    	if(root.val==p || root.val==q){   
    	    if(root.val==p)
    	        a = true;
    	    if(root.val==q)
    	        b = true;     
    		lca = root;
    	}
    	
    	TreeNode left = lowestCommonAncestor(root.left,p,q);
    	TreeNode right = lowestCommonAncestor(root.right,p,q);
    	
    	if(lca == null)
    		lca = (left!=null && right!=null)?root:right!=null?right:left;
    	
    	return lca;
    }
    
    public int lca(TreeNode root, int val1, int val2) {
    	if(root==null)
    		return -1;

    	TreeNode lca =  lowestCommonAncestor(root,val1,val2);
    	//System.out.println("--> "+lca.val);
    	if(a && b){
    		return lca.val;
    	} else {
    		return -1;
    	}
    	
    	
    }
    
    

    static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
