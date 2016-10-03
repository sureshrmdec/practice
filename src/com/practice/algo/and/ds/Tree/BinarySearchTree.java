package com.practice.algo.and.ds.Tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class BinarySearchTree {

	public Node root;

	public Node find(int key) // find node with given key
	{ // (assumes non-empty tree)
		Node current = root; // start at root

		while(current.iData != key) // while no match,
		{
			if(key < current.iData) // go left?
				current = current.leftChild;
			else
				current = current.rightChild; // or go right?
			if(current == null) // if no child,
				return null; // didn�t find it
		}
		return current; // found it
	}

	public void insert(int id)
	{
		Node newNode = new Node(); // make new node
		newNode.iData = id; // insert data

		if(root==null) // no node in root
			root = newNode;
		else // root occupied
		{
			Node current = root; // start at root
			Node parent;
			while(true) // (exits internally)
			{
				parent = current;
				if(id < current.iData) // go left?
				{
					current = current.leftChild;
					if(current == null) // if end of the line,
					{ // insert on left
						parent.leftChild = newNode;
						return;
					}
				} // end if go left
				else // or go right?
				{

					current = current.rightChild;
					if(current == null) // if end of the line
					{ // insert on right
						parent.rightChild = newNode;
						return;
					}
				} // end else go right
			} // end while
		} // end else not root
	}
	
	public void preorderRecursive(Node root){
		if(root==null){
			return;
		}
		System.out.print(root.iData +" ");
		preorderRecursive(root.leftChild);
		preorderRecursive(root.rightChild);
	}
	
	public void postorderRecursive(Node root){
		if(root==null){
			return;
		}
		postorderRecursive(root.leftChild);
		postorderRecursive(root.rightChild);
		System.out.print(root.iData +" ");
	}
	
	public void inorderRecursive(Node root){
		if(root==null){
			return;
		}
		inorderRecursive(root.leftChild);
		System.out.print(root.iData +" ");
		inorderRecursive(root.rightChild);
	}
	Stack<Node> stack = new Stack<Node>();
	public void inorderNonRecursive(Node root){
	
		stack.push(root);
		
		while(!stack.isEmpty()){
			Node n = stack.lastElement();
			if(n.isLeftChecked!=true && n.leftChild != null){
				stack.push(n.leftChild);
				n.isLeftChecked = true;
			}else{
				Node node = stack.pop();
				System.out.print(node.iData +" ");
				if(node.rightChild != null && node.isRightChecked!=true){
					node.isRightChecked=true;
					stack.push(node.rightChild);		
				}
				
			}
		}
		
	}
	
	//make BST frm InOrder Traversal
	private static int index;
	public Node makeBinaryTreeFromPreOrder(int[] preorder,int data,int min,int max){
	
		if(index > preorder.length - 1)
			return null;
		Node newNode = null;
		
		if(data > min && data < max){
			newNode = new Node(); // make new node
			newNode.iData = data; // insert data

			index = index +1;
			if(index < preorder.length)
			newNode.leftChild = makeBinaryTreeFromPreOrder(preorder,preorder[index],min,newNode.iData);
			if(index < preorder.length)
			newNode.rightChild = makeBinaryTreeFromPreOrder(preorder,preorder[index],newNode.iData,max);
		}
		return newNode;
	}
	
	//make BST from post order traversal
	public Node makeBinaryTreeFromPostOrder(int[] preorder,int data,int min,int max){
	return null;
	}
	
	
	public boolean checkValidityofBST(Node root,int min,int max){
		root = (root!=null)?root:null;
		if(root!=null)
		System.out.println("node "+root.iData+" min "+min+" max "+max);
		if(root!=null && root.iData > min && root.iData < max 
				&& checkValidityofBST(root.leftChild,min,root.iData)
				&& checkValidityofBST(root.rightChild,root.iData,max)
			){
			return true;
		}
		
		return true;
	}
	
	
	//make BST from Pre order traversal using Stack
	public Node makeBSTFromPreorderUsingStack(int[] pre){
		
		    // Create a stack of capacity equal to size
		    Stack<Node> stack = new Stack<Node>();
		 
		    // The first element of pre[] is always root
		    Node root = new Node();
		    root.iData = pre[0];
		  
		    // Push root
		    stack.push(root );
		 
		    int i;
		    Node temp;
		    // Iterate through rest of the size-1 items of given preorder array
		    for ( i = 1; i < pre.length; ++i )
		    {
		    	
		        temp = null;
		        
		        
		 
		        /* Keep on popping while the next value is greater than
		           stack's top value. */
		        while ( !stack.isEmpty() && pre[i] > stack.peek().iData)
		            temp = stack.pop();
		 
		        // Make this greater value as the right child and push it to the stack
		        if ( temp != null)
		        {
		        	Node node = new Node();
				    node.iData = pre[i];
		            temp.rightChild = node;
		            stack.push(node);
		        }
		 
		        // If the next value is less than the stack's top value, make this value
		        // as the left child of the stack's top node. Push the new node to stack
		        else
		        {
		        	Node node = new Node();
				    node.iData = pre[i];
				    stack.peek().leftChild = node;
		            stack.push(node);
		        }
		    }
		 
		    return root;

		
		
	}
	
	//Sum of all leaf nodes of given binary tree
	
	//vertical traversal of BST
	Map<Integer,ArrayList<Integer>> map = new TreeMap<Integer,ArrayList<Integer>>();
	private void doVerticalTraveralofBST(Node root,int hd){
		
		if(root ==null)
			return;
		ArrayList<Integer> list = map.get(hd);
		if(list!=null){
			list.add(root.iData);	
		}else{
			list = new ArrayList<Integer>();
			list.add(root.iData);
		}
		
		map.put(hd, list);
		doVerticalTraveralofBST(root.leftChild,hd-1);
		doVerticalTraveralofBST(root.rightChild,hd+1);
	}
	
	//Least Common Ancestor of BST
	private int getLCAofBST(Node root,int a,int b){
		
		if (root==null){
			return 0;
		}
		if((a<root.iData) && (b<root.iData)){
			return getLCAofBST(root.leftChild, a, b);
		}else if((a>root.iData) && (b>root.iData)){
			
			return getLCAofBST(root.rightChild, a, b);
		}
		return root.iData; 
	}
	
	//Find 2 nodes equal to given Sum S...
/*	1. Do Inorder traversal
	2. it is sorted now.
	3. strat with index 0 and index array.length -1
	4. if sum > a[start index] + a[array.length -1]
	             decrease array.length-1 by 1
	    else if (sum < a[start index] + a[array.length -1])
	    		increase a[start index] to a[start index +1]
*/
	
	private Node makeBSTFromSortedArray(int[] sortedArray,int l ,int h){
		
		if(l>h)
			return null;
		int mid = (l + h)/2;
		Node newNode = new Node(sortedArray[mid]);
		newNode.leftChild = makeBSTFromSortedArray(sortedArray, l , mid-1);
		newNode.rightChild = makeBSTFromSortedArray(sortedArray, mid+1 ,h);
		
		return newNode;
	}
	
	public static void main(String[] args) {
		
		String str = "cinema";
		String str2 = "iceman";
		int[] checker = new int[str.length()];
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(4);
		tree.insert(17);
		tree.insert(1);
		tree.insert(5);
		tree.insert(16);
		tree.insert(21);
		tree.inorderRecursive(tree.root);
		System.out.println();
		tree.inorderNonRecursive(tree.root);
		System.out.println();
		tree.preorderRecursive(tree.root);
		System.out.println();
		tree.postorderRecursive(tree.root);
		tree.checkValidityofBST(tree.root, Integer.MIN_VALUE,Integer.MAX_VALUE);
		int[] preorder = {10, 4, 1, 5 ,16 ,13, 21};
/*						10
			    	4		 16
		       1       5 13		21
*/		
		Node root = tree.makeBinaryTreeFromPreOrder(preorder, preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
		tree.inorderRecursive(root);
		Node root2 = tree.makeBSTFromPreorderUsingStack(preorder);
		tree.inorderRecursive(root2);
		tree.doVerticalTraveralofBST(root,0);
		tree.printVertical(tree.map);
		int[] sortedArray = {1,2,3,4,5,6,7,8,9};
		Node root3 = tree.makeBSTFromSortedArray(sortedArray, 0, sortedArray.length-1);
		tree.inorderRecursive(root3);
		System.out.println("LCA is"+tree.getLCAofBST(root, 13, 213));
	}

	private void printVertical(Map<Integer, ArrayList<Integer>> map2) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println();
		Set<Integer> set = map2.keySet();
		for(int i : set){
			ArrayList<Integer> list = map2.get(i);
			for(int j : list){
				System.out.print(j +" ");
			}
			System.out.println();
		}
		
	}
}
