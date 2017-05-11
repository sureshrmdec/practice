package com.practice.algo.and.ds.Tree;

public class Node {
	
	public int iData; // data used as key value
	public Node leftChild; // this node�s left child
	public Node rightChild;
	public boolean isLeftChecked;
	public boolean isRightChecked;

	public Node(){
		
	}
	
	public Node(int iData){
		this.iData = iData;
	}
	
}
