

package com.practice.algo.and.ds.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	/**
	 * @param args
	 */
	static Node root;
	private void insert(Node node){
		if(root==null){
			root = node;
		}else{
			//Use BFS to insert the node in Binary Tree
			
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while(!queue.isEmpty()){
				Node parent = queue.poll();
				if(parent.leftChild!=null){
					queue.add(parent.leftChild);
				}else{
					parent.leftChild = node;
					return;
				}
				if(parent.rightChild!=null){
					queue.add(parent.rightChild);
				}else{
					parent.rightChild = node;
					return;
				}
			}
			
		}

	}

	//print right view of binary tree
	int levelReached = 0;
	private void printRightViewTree(Node root,int nodeLevel){
		if(root==null){
			return;
		}
		if(nodeLevel > levelReached ){
			System.out.println(root.iData);
			levelReached = nodeLevel;
		}
			printRightViewTree(root.rightChild, nodeLevel+1);
			
			printRightViewTree(root.leftChild, nodeLevel+1);
		
	}
	private void serialize(Node root){
		System.out.print(root.iData);
		if(root.leftChild!=null){
			serialize(root.leftChild);
		}else{
			System.out.print("-1");
		}
		if(root.rightChild!=null){
			serialize(root.rightChild);
		}else{
			System.out.print("-1");
		}
	}
	
	//BFS for BT
	private void printLevelOrderTraversal(Node root){
		Queue<Node>   currentQueue = new LinkedList<Node>();
		Queue<Node>   nextQueue = new LinkedList<Node>();
		
		currentQueue.add(root);
		
		while(!currentQueue.isEmpty()){
			Node node = currentQueue.poll();
			System.out.print(node.iData);
			
			if(node.leftChild!=null){
				nextQueue.add(node.leftChild);
			}
			if(node.rightChild!=null){
				nextQueue.add(node.rightChild);
			}
			if(currentQueue.isEmpty()){

				//nextQueue.removeAll(currentQueue);
				currentQueue.addAll(nextQueue);
				nextQueue = new LinkedList<Node>();
				System.out.println();
			}
		}
		
	}

	// check if binary tree is complete or not
	private boolean checkIfCompleteBinaryTree(Node root){
		
		if(root!=null){
			if(root.leftChild == null && root.rightChild!=null){
				return false;
			}else{
				boolean leftCheck = checkIfCompleteBinaryTree(root.leftChild);
				boolean rightCheck = checkIfCompleteBinaryTree(root.rightChild);
					if(!leftCheck || !rightCheck){
						return false;
					}
			}
		}
		
		return true;
	}
	
	//LCA of Binary Tree
	private Node getLCAofBinaryTree(Node root,int a,int b){
		if(root==null){
			return null;
		}
		if(root.iData==a || root.iData==b){
			return root;
		}
		
		Node leftPresent = getLCAofBinaryTree(root.leftChild, a, b);
		Node rightPresent = getLCAofBinaryTree(root.rightChild, a, b);
		if(leftPresent!=null && rightPresent!=null){
			return root;
		}
		return (leftPresent!=null)?leftPresent:rightPresent;
	}
	
	//height of binary tree
	private int getHeightOfBT(Node root){
		
		if(root == null){
			return 0;
		}
		int l = 1 + getHeightOfBT(root.leftChild);
		int r = 1 + getHeightOfBT(root.rightChild);
		
		if(l>r){
			return l;
		}else{
			return r;
		}
	}
	
	//check if binary tree is height balanced
	private boolean checkIfTreeIsHeightBalanced(Node root){
		
		if(root == null){
			return true;
		}
		int l = 1 + getHeightOfBT(root.leftChild);
		int r = 1 + getHeightOfBT(root.rightChild);
		
		if(Math.abs(l - r) <= 1){
			System.out.println("Balanced");
			return true;
			}else{
				System.out.println("Not Balanced");
			}
		return false;
	}
	
	public Node constructBTFromInorderAndPreOrderTraversals(char[] preorder, int preStart, int preEnd, char[] inorder, int inStart, int inEnd){
		 if(preStart>preEnd||inStart>inEnd){
		        return null;
		    } 
		char rootVal = preorder[preStart];
		 
		 Node root = new Node(rootVal);
		 
		//find parent element index from inorder
		    int k=0;
		    for(int i=0; i<inorder.length; i++){
		        if(rootVal == inorder[i]){
		            k=i;
		            break;
		        }
		    }
		 root.leftChild = constructBTFromInorderAndPreOrderTraversals(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1);
		 root.rightChild = constructBTFromInorderAndPreOrderTraversals(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();

//insert will make complete binary tree using BFS		
		bt.insert(new Node(1));
		bt.insert(new Node(2));
		bt.insert(new Node(3));
		bt.insert(new Node(4));
		bt.insert(new Node(5));
		bt.insert(new Node(6));
		bt.insert(new Node(7));

		bt.serialize(root);
		
// to show print right view of tree, we willl make new binary tree
		root = new Node();
		root.iData = 1;
		Node leftChild = new Node();
		leftChild.iData = 2;
		root.leftChild = leftChild;
		Node rightChild = new Node();
		rightChild.iData = 3;
		root.rightChild = rightChild;
		Node leftChild1 = new Node();
		leftChild1.iData = 4;
		leftChild.leftChild = leftChild1;
		Node rightChild1 = new Node();
		rightChild1.iData = 5;
		leftChild.rightChild = rightChild1;
		Node leftChild2 = new Node();
		leftChild2.iData = 6;
		rightChild.leftChild = leftChild2;

		Node rightChild2 = new Node();
		rightChild2.iData = 7;
		rightChild.rightChild = rightChild2;

		Node node8 = new Node();
		node8.iData = 8;
		leftChild2.leftChild = node8;
		

		Node rightChildOf8 = new Node();
		rightChildOf8.iData = 9;
		node8.rightChild = rightChildOf8;
/*											 1
								2		    	        3
						4	       	 5            6           7
							                  8
							                       9
*/							
		bt.printRightViewTree(root, 1);
		
		bt.printLevelOrderTraversal(root);
		bt.checkIfCompleteBinaryTree(root);
		Node lca = bt.getLCAofBinaryTree(root, 5, 4);

		bt.getHeightOfBT(root);
		
		//make it un balanced
		Node leftChild4 = new Node();
		leftChild4.iData = 200;
		//leftChild3.leftChild = leftChild4;
		
		bt.checkIfTreeIsHeightBalanced(root);
		
		//constructBTFromInorderAndPreOrderTraversals
/*								A
						B                   C
				D	          E	     F  
*/		char inorder[] = {'D', 'B', 'E', 'A', 'F', 'C'};
		char preorder[] = {'A', 'B', 'D', 'E', 'C', 'F'};

		int preStart = 0;
	    int preEnd = preorder.length-1;
	    int inStart = 0;
	    int inEnd = inorder.length-1;
	    bt.constructBTFromInorderAndPreOrderTraversals(preorder, preStart, preEnd, inorder, inStart, inEnd);
	    
		BinaryTree t = new BinaryTree();
		root = new Node();
		root.iData = 'A';
	}	

}
