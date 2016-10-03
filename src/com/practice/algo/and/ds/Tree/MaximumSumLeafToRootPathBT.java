package com.practice.algo.and.ds.Tree;

public class MaximumSumLeafToRootPathBT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.root = new Node();
		bt.root.iData = 4;
		Node leftChild = new Node();
		leftChild.iData = 5;
		bt.root.leftChild = leftChild;
		Node rightChild = new Node();
		rightChild.iData = 3;
		bt.root.rightChild = rightChild;
		Node leftChild1 = new Node();
		leftChild1.iData = 9;
		leftChild.leftChild = leftChild1;
		Node rightChild1 = new Node();
		rightChild1.iData = 8;
		leftChild.rightChild = rightChild1;
		Node leftChild2 = new Node();
		leftChild2.iData = 15;
		rightChild.leftChild = leftChild2;

		Node rightChild2 = new Node();
		rightChild2.iData = 14;
		rightChild.rightChild = rightChild2;

		Node leftChild3 = new Node();
		leftChild3.iData = 199;
		leftChild2.leftChild = leftChild3;
		
		MaximumSumLeafToRootPathBT m = new MaximumSumLeafToRootPathBT();
		m.printSumAndPath(bt.root);
	}

	private void printSumAndPath(Node root) {
		// TODO Auto-generated method stub
		int maxSum = 0;
		getTargetLeaf(root,0);
		printPath(targetLeaf,root);
	}

	private boolean printPath(Node targetLeaf2,Node root) {
		// TODO Auto-generated method stub
		if(root==null){
			return false;
		}
		if(targetLeaf2==root || printPath(targetLeaf2, root.leftChild) ||
		printPath(targetLeaf2, root.rightChild)){
			System.out.print(root.iData+"-->>");
			return true;
		}
		return false;
	}

	int maxSoFar = 0;
	Node targetLeaf = null;
	private Node getTargetLeaf(Node root,int sumSoFar) {
		// TODO Auto-generated method stub
		if(root == null){
			return null;
		}
		if(root.leftChild==null && root.rightChild==null){
			if(root.iData + sumSoFar> maxSoFar){
				maxSoFar = Math.max(maxSoFar,root.iData + sumSoFar);
				targetLeaf = root;	
				return targetLeaf;
			}
			}
		
		getTargetLeaf(root.leftChild, root.iData+sumSoFar);
		getTargetLeaf(root.rightChild, root.iData+sumSoFar);
		return null;
	}

}
