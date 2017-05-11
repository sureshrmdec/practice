package com.practice.algo.and.ds.LinkedLists;

import com.practice.algo.and.ds.LinkedLists.LinkedLists_RotateList.ListNode;

public class LinkedLists_SortList<T> {

	public static void main(String[] args) {
		LinkedLists_SortList<Integer> o = new LinkedLists_SortList<>();
		ListNode f4 = new ListNode(4);

		ListNode s7 = new ListNode(7);
		ListNode t3 = new ListNode(3);
		ListNode e8 = new ListNode(8);
		ListNode f5 = new ListNode(5);
		ListNode o1 = new ListNode(1);
		ListNode s6 = new ListNode(6);
		ListNode t2 = new ListNode(2);
		
		f4.next = s7;
		s7.next = t3;
		t3.next = e8;
		e8.next = f5;
		f5.next = o1;
		o1.next = s6;
		s6.next = t2;
		
		ListNode ss = o.sortList(f4);
		System.out.println();
	}
    public ListNode sortList(ListNode head) {
    	if(head==null)
    		return null;
    	if(head.next==null)
    		return head;
     
    	ListNode fast = head;
    	ListNode slow = head;
    	
    	while(fast.next!=null && fast.next.next!=null){
    			slow = slow.next;
    			fast = fast.next.next;
    	}
    	ListNode firstStart = head;
    	ListNode secondStart = slow.next;
    	slow.next = null;
    	
    	ListNode f = sortList(firstStart);
    	ListNode s = sortList(secondStart);
    	
    	//Make head from one of them
    	ListNode newHead = null;
    	if(f.val<s.val){
    			newHead = f;
    			f = f.next;
    		}else{
    			newHead = s;
    			s = s.next;
    		}
    	ListNode newList = newHead;	
    	while(f!=null && s!=null){
    		if(f.val<s.val){
    			newList.next = f;
    			f = f.next;
    		}else{
    			newList.next = s;
    			s = s.next;
    		}
    		newList = newList.next;
    	}
    	while(f!=null){
    		newList.next = f;
    		f = f.next;
    		newList = newList.next;
    	}
    	while(s!=null){
    		newList.next = s;
    		s = s.next;
    		newList = newList.next;
    	}
    	return newHead;
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
