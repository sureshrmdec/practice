package com.practice.algo.and.ds.LinkedLists;


public class LinkedLists_ReverseLinkedListII<T> {

	public static void main(String[] args) {
		LinkedLists_ReverseLinkedListII<Integer> intList = new LinkedLists_ReverseLinkedListII<>();
		intList.insertFirst(5);
	//	intList.insertFirst(4);
		intList.insertFirst(3);
	//	intList.insertFirst(2);
	//	intList.insertFirst(1);
		intList.reverseBetween(intList.head, 1, 2);
	}
	ListNode head;
	private int size;
	ListNode end;
	
	public void insertFirst(int val){
		if(head==null){
			head = new ListNode(val);
			end = head;
			size++;
			return;
		}
		ListNode newNode = new ListNode(val);
		newNode.next = head;
		head = newNode;
		size++;
	}
	//1->2->3->4->5->NULL
	//1->4->3->2->5->NULL.
	public ListNode reverseBetween(ListNode head, int m, int n) {
		
		if(head == null)
			return null;
		if(m==n)
			return head;
		int i=1;
		ListNode revStart = null;
		ListNode revStartNext = null;
		ListNode revEnd = null;
		ListNode revEndNext = null;
		ListNode prev = null;
		ListNode next = null;
		ListNode cNode = head;
		ListNode prevA = null;
		while(cNode!=null){
			
			if(i==m){
				revStart = prevA;
				revStartNext = revStart!=null?revStart.next:cNode;
			}
			if(i==n){
				revEnd = cNode;
				revEndNext = revEnd.next;
			}
			if(i>=m && i<=n){
				next = cNode.next;
				cNode.next = prev;
				prev = cNode;
				cNode = next;
				if(i==n){
					if(revStart==null)
						revStart = revEnd;
					else
						revStart.next = revEnd;
					revStartNext.next = revEndNext;
					
				}
			}else{
				cNode = cNode.next;
			}
			prevA = cNode;
			
			i++;
			
		}
		
		return head;
        
    }

class ListNode {
	   public int val;
	      public ListNode next;
	      ListNode(int x) { 
	    	  val = x; 
	    	  next = null; 
	    	 }
	  }
}