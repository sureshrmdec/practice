package com.practice.algo.and.ds.interviewbit;

public class LinkedLists_MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode mergeTwoLists(ListNode f, ListNode s) {
    	ListNode newList = new ListNode(0);
    	ListNode newHead = newList;
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
    	return newHead.next;
    }
}
