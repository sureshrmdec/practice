package com.practice.algo.and.ds.interviewbit;

import com.practice.algo.and.ds.LinkedLists.LinkedList;
import com.practice.algo.and.ds.LinkedLists.Node;
import com.practice.algo.and.ds.Tree.BinarySearchTree;

public class MakeBSTFromSortedLinkedList {

	private static com.practice.algo.and.ds.LinkedLists.Node<Integer> head;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList list = new LinkedList();
		list.insert(new Node(7));
		list.insert(new Node(6));
		list.insert(new Node(5));
		list.insert(new Node(4));
		list.insert(new Node(3));
		list.insert(new Node(2));
		list.insert(new Node(1));
		MakeBSTFromSortedLinkedList bst = new MakeBSTFromSortedLinkedList();
		bst.head = list.head;
		com.practice.algo.and.ds.Tree.Node root = bst.makeBSTFromSortedList(7);
		BinarySearchTree bst2 = new BinarySearchTree();
		bst2.root = root;
		bst2.inorderRecursive(root);
		
	}


	private com.practice.algo.and.ds.Tree.Node makeBSTFromSortedList(int n) {
		/* Base Case */
	    if (n <= 0)
	        return null;
	 
	    /* Recursively construct the left subtree */
	    com.practice.algo.and.ds.Tree.Node left = makeBSTFromSortedList( n/2);
	 
	    /* Allocate memory for root, and link the above constructed left 
	       subtree with root */
	    com.practice.algo.and.ds.Tree.Node root = new com.practice.algo.and.ds.Tree.Node();
	    root.iData = MakeBSTFromSortedLinkedList.head.val;
	    root.leftChild = left;
	 
	    /* Change head pointer of Linked List for parent recursive calls */
	    MakeBSTFromSortedLinkedList.head = MakeBSTFromSortedLinkedList.head.next;
	 
	    /* Recursively construct the right subtree and link it with root 
	      The number of nodes in right subtree  is total nodes - nodes in 
	      left subtree - 1 (for root) which is n-n/2-1*/
	    root.rightChild = makeBSTFromSortedList( n-n/2-1);
	 
	    return root;
	}

	

}
