package com.practice.algo.and.ds.LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkedList = new LinkedList();
		linkedList.insert(new Node(1));
		linkedList.insert(new Node(5));
		linkedList.insert(new Node(5));
		linkedList.insert(new Node(8));
		linkedList.insert(new Node(8));
		linkedList.insert(new Node(2));
		linkedList.insert(new Node(8));
		linkedList.insert(new Node(2));
		linkedList.deleteduplicatefromUnsortedList(linkedList.head);
		linkedList.deleteNth(linkedList.head,0);
		//linkedList.deleteLast(linkedList.head);
		System.out.println(linkedList);
		
		linkedList.search(5);
		linkedList.search(7);
		linkedList.reverselist(linkedList.head);
	}

	public Node<Integer> head;
	
	public void insert(Node node){
	

	if(head == null){
		head = node;
	}else{
		node.next = head;
		head = node;
	}
		
	}
	
	public Node deleteLast(Node node){
		
		Node head = node;
		Node parent = null;
		while(node.next!=null){
			parent = node;
			node = node.next;
		}
		parent.next = null;
		return head;
	}
	
	public Node deleteNth(Node node,int position){
		int count  = 0;
		Node localHead = node;
		Node parent = null;
		Node next = null;
		if(position==0){
			
			localHead = node.next;
			
			return localHead;
			
		}
		while(count!=position){
			parent = node;
			node = node.next;
			count++;
		}
		parent.next = node.next;
		node.next = null;
		
		return localHead;
	}
	private Node reverselist(Node head){
		
		Node prev = null;
		Node next = null;
		while(head !=null){
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	public void search(int val){
		
		Node<Integer> localHead = head;
		while(localHead!=null && localHead.val != val){
			localHead = localHead.next;
		}
		if(localHead == null){
			System.out.println("Not Found");
		}else{
			System.out.println("Found");
		}
	}
	
	//delete duplicate from linked list
	public Node deleteduplicatefromUnsortedList(Node head){
		Set<Node> set = new HashSet<Node>();
		Node localHead = head;
		Node newhead = new Node(head.val);
		
		set.add(newhead);
		while(localHead.next!=null){
			
			localHead = localHead.next;
			if(!set.contains(localHead)){
				Node newnnode = new Node(localHead.val);
				set.add(newnnode);
				newnnode.next = newhead;
				newhead = newnnode;
			}
			
		}
		return newhead;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Node localHead = head;
		
		while(localHead.next!=null){
			System.out.println(localHead.val);
			localHead = localHead.next;
		}
		System.out.println(localHead.val);
		return super.toString();
	}
}
