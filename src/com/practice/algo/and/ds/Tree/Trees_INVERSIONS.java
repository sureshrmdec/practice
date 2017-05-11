package com.practice.algo.and.ds.Tree;

import java.util.ArrayList;
import java.util.Arrays;

import com.practice.algo.and.ds.Tree.Node;

public class Trees_INVERSIONS {

	public static void main(String[] args) {
		Integer[] ar = {4,5,2,1,6,7,3};
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(ar));
		Trees_INVERSIONS o = new Trees_INVERSIONS();
		o.countInversions(a);

	}
	TreeNode root = null;
	public int countInversions(ArrayList<Integer> a) {
		int result = 0;
		for(int i=0;i<a.size();i++){
			int current = a.get(i);

			if(root == null){
				root = new TreeNode(0,current);
			}else{
				result+=insert(current);
			}
		}
		return result;
	}
	private int insert(int val) {
		int result = 0;
		TreeNode newNode = new TreeNode(0,val); // make new node
		TreeNode current = root; // start at root
		TreeNode parent;
		while(true) // (exits internally)
		{
			parent = current;
			if(val < current.val) // go left?
			{
				result+=current.numRight+1;
				current = current.leftChild;
				if(current == null) // if end of the line,
				{ // insert on left
					parent.leftChild = newNode;
					return result;
				}
			} // end if go left
			else // or go right?
			{
				current.numRight++;
				current = current.rightChild;
				if(current == null) // if end of the line
				{ // insert on right
					parent.rightChild = newNode;
					return result;
				}
			} // end else go right
		} // end while
	}
	static class TreeNode{
		int numRight;
		int val;
		TreeNode rightChild;
		TreeNode leftChild;
		public TreeNode(int numRight, int val) {
			super();
			this.numRight = numRight;
			this.val = val;
		}
	}
}
