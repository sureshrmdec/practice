package com.practice.algo.and.ds.Tree;

public class MakeBSTFromSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakeBSTFromSortedArray bst = new MakeBSTFromSortedArray();
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		bst.makeBSTFromArray(array, 0, array.length-1);
	}

	private Node makeBSTFromArray(int[] array,int start,int end){
		if(start > end)
			return null;
		int mid = (start + end)/2;
		Node root = new Node();
		root.iData = array[mid];
		root.leftChild = makeBSTFromArray(array, start, mid-1);
		root.rightChild = makeBSTFromArray(array, mid+1, end);
		return root;
	}
}
