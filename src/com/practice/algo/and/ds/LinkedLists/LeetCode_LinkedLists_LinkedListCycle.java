package com.practice.algo.and.ds.LinkedLists;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle/

public class LeetCode_LinkedLists_LinkedListCycle<T> {

	public static void main(String[] args) {
		LeetCode_LinkedLists_LinkedListCycle<Integer> intList = new LeetCode_LinkedLists_LinkedListCycle<>();
		//intList.insertFirst(5);
		ListNode o1 = new ListNode(1);
		intList.head = o1;
		ListNode t2 = new ListNode(2);
		ListNode t3 = new ListNode(3);
		ListNode f4 = new ListNode(4);
		
		o1.next = t2;
		t2.next = t3;
		t3.next = f4;
		f4.next = t2;
		LeetCode_LinkedLists_LinkedListCycle<Integer> o = new LeetCode_LinkedLists_LinkedListCycle<>();
		System.out.println(o.hasCycle(intList.head));
		System.out.println(o.hasCycleTwoPointers(intList.head));
	}
	// With Hashing
	private boolean hasCycle(ListNode head) {
		// TODO Auto-generated method stub
		Set<ListNode> set = new HashSet<>();
		while(head!=null){
			if(!set.add(head)){
				return true;
			}
			head = head.next;
		}
		return false;
	}
	
	
	//two pointers
	private boolean hasCycleTwoPointers(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(slow!=null && fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast)
				return true;
		}
		
		
		return false;
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
	static class ListNode {
		   public int val;
		      public ListNode next;
		      ListNode(int x) { 
		    	  val = x; 
		    	  next = null; 
		    	 }
		  }
}
