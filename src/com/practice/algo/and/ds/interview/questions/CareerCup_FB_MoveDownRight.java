package com.practice.algo.and.ds.interview.questions;


//https://www.careercup.com/question?id=5112453361827840
	
public class CareerCup_FB_MoveDownRight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node one = new Node('M');
		Node oneD = new Node('C');
		Node oneD2 = new Node('A');
		one.down = oneD;
		oneD.down = oneD2;
		Node oneR = new Node('N');
		one.right = oneR;
		Node twoD = new Node('X');
		oneR.down = twoD;
		Node twoD2 = new Node('Z');
		twoD.down = twoD2;
		CareerCup_FB_MoveDownRight o = new  CareerCup_FB_MoveDownRight();
		o.printdownRight(one);
	}

	public void printdownRight(Node node){
		if(node==null){
			return;
		}
		if(node!=null){
			System.out.println(node.a);
			printdownRight(node.down);
		}
		if(node.right!=null){
			printdownRight(node.right);
		}
		
	}
	
}
class Node{
	Node down;
	Node right;
	char a;
	public Node(Node down, Node right, char a) {
		super();
		this.down = down;
		this.right = right;
		this.a = a;
	}
	public Node(char a){
		this.a = a;
	}
}