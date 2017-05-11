package com.practice.algo.and.ds.LinkedLists;

import com.practice.algo.and.ds.LinkedLists.LinkedLists_IntersectionofLinkedLists.ListNode;

/*
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/
public class LinkedList_PartitionList {

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode a1 = new ListNode(4);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(2);
		ListNode a4 = new ListNode(5);
		ListNode a5 = new ListNode(2);
		


		
		a.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		LinkedList_PartitionList o = new LinkedList_PartitionList();
		o.partition(a, 3);

	}
	
	
	
public ListNode partition(ListNode head, int x) {
	    
	    ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
	    ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
	    while (head!=null){
	        if (head.val<x) {
	            curr1.next = head;
	            curr1 = head;
	        }else {
	            curr2.next = head;
	            curr2 = head;
	        }
	        head = head.next;
	    }
	    curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
	    curr1.next = dummy2.next;
	    return dummy1.next;
	
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
