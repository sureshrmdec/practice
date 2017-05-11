package com.practice.algo.and.ds.LinkedLists;

import com.practice.algo.and.ds.LinkedLists.LinkedLists_IntersectionofLinkedLists.ListNode;

public class LinkedLists_RotateList {

	public static void main(String[] args) {

		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		LinkedLists_RotateList intList = new LinkedLists_RotateList();
		System.out.println(intList.rotateRight(a1,2));

	}
	public ListNode rotateRight(ListNode head, int k) {

		if(head==null)
			return null;
		if(k==0)
			return head;
		int i=0;
		ListNode first = head;
		ListNode second = head;
		int size =0;


		while(first!=null){
			first = first.next;
			size++;
		}
		if(size==k)
			return head;
		if(k>size)
			k = k%size;
		first = head;
		while(first!=null){
			first = first.next;
			if(i>k){
				second = second.next;
			}
			i++;
			size++;
		}
		ListNode part = second.next;
		// System.out.println(second.val);
		ListNode partC = part;
		second.next = null;
		ListNode prev = null;
		if(part==null)
			return head;
		while(part!=null){
			prev = part;
			part = part.next;

		}
		prev.next = head;
		return partC;

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
