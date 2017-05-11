package com.practice.algo.and.ds.LinkedLists;

import com.practice.algo.and.ds.LinkedLists.LinkedLists_PalindromeRevisited.ListNode;

public class LinkedLists_LeetCode_ReverseRecursivelyIteratively {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode reverseListIteratively(ListNode head) {
	    /* iterative solution */
	    ListNode newHead = null;
	    while (head != null) {
	        ListNode next = head.next;
	        head.next = newHead;
	        newHead = head;
	        head = next;
	    }
	    return newHead;
	}

	public ListNode reverseListRecursively(ListNode head) {
	    /* recursive solution */
	    return reverseListInt(head, null);
	}

	private ListNode reverseListInt(ListNode head, ListNode newHead) {
	    if (head == null)
	        return newHead;
	    ListNode next = head.next;
	    head.next = newHead;
	    return reverseListInt(next, head);
	}
	static class ListNode {
		   public int val;
		      public ListNode next;
		      ListNode(int x) { 
		    	  val = x; 
		    	  next = null; 
		    	 }
		  }
}
