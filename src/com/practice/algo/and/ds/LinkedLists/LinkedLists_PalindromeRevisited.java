package com.practice.algo.and.ds.LinkedLists;


public class LinkedLists_PalindromeRevisited<T> {

	public static void main(String[] args) {
		LinkedLists_PalindromeRevisited<Integer> intList = new LinkedLists_PalindromeRevisited<>();
		intList.insertFirst(1);
		intList.insertFirst(4);
		intList.insertFirst(5);
		intList.insertFirst(4);
		intList.insertFirst(1);
		
		System.out.println(intList.lPalin(intList.head));
		
	}
	private boolean lPalin(ListNode head) {
		

		//find middle
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode secondHead = slow.next;
		slow.next = null;
		
		//reverse second half
		ListNode current = secondHead;
		ListNode next = null;
		ListNode prev = null;
				
		while(current!=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		//check palindrome
		secondHead = prev;
		while(secondHead!=null){
			if(head.val!=secondHead.val)
				return false;
			secondHead = secondHead.next;
			head = head.next;
		}
		
		return true;
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
	class ListNode {
		   public int val;
		      public ListNode next;
		      ListNode(int x) { 
		    	  val = x; 
		    	  next = null; 
		    	 }
		  }
}
