package com.practice.algo.and.ds.Tree;

public class Node {
	
	int iData; // data used as key value
	Node leftChild; // this node’s left child
	Node rightChild;
	boolean isLeftChecked;
	boolean isRightChecked;

	public Node(){
		
	}
	
	public Node(int iData){
		this.iData = iData;
	}
	
}
