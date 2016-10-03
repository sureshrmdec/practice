package com.practice.algo.and.ds.Tree;

public class KthSmallestLargestinBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		KthSmallestLargestinBST sl = new KthSmallestLargestinBST();
		sl.findKthSmallestOrLargest(tree.root);
	}

	int k =6;
	int s = 0;
	//reverse inorder traversal
	private Node findKthSmallestOrLargest(Node root){
		if(root==null){
			return null;
		}
		findKthSmallestOrLargest(root.rightChild);
		s = s+1;
		if(s==k){
			System.out.println(root.iData);
			
		}
		findKthSmallestOrLargest(root.leftChild);
		
		return root;
		}
}
