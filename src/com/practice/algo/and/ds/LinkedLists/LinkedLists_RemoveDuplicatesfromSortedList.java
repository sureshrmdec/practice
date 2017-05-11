package com.practice.algo.and.ds.LinkedLists;

import java.util.HashSet;

public class LinkedLists_RemoveDuplicatesfromSortedList<T> {

	public static void main(String[] args) {
		LinkedLists_RemoveDuplicatesfromSortedList<Integer> intList = new LinkedLists_RemoveDuplicatesfromSortedList<>();
		intList.insertFirst(5);
		intList.insertFirst(4);
		intList.insertFirst(3);
		intList.insertFirst(3);
		intList.insertFirst(2);
		intList.insertFirst(2);
		intList.insertFirst(3);
		intList.insertFirst(1);
		intList.removeDuplicate(intList.head);

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
	
	public ListNode removeDuplicate(ListNode head){
	    ListNode next = head.next;
	    int prevVal = head.val;
	    ListNode prev = head;
	    while(next!=null){
	        if(next.val==prevVal){
	            prev.next = next.next;
	        }else{
	            prevVal = next.val;
	           // prev.next = next; // we already did it in previous iteration
	            prev = next;
	        }
	        next = next.next;
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
