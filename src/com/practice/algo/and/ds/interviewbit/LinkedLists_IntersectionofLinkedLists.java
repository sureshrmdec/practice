package com.practice.algo.and.ds.interviewbit;

import java.util.HashSet;
import java.util.Set;



public class LinkedLists_IntersectionofLinkedLists {

	public static void main(String[] args) {
		LinkedLists_IntersectionofLinkedLists intList = new LinkedLists_IntersectionofLinkedLists();
		ListNode a = new ListNode(0);
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);

		ListNode b1 = new ListNode(3);
		ListNode b2 = new ListNode(4);
		ListNode b3 = new ListNode(5);
		ListNode b4 = new ListNode(6);

		
		a.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		
		b1.next = b2;
		b2.next = b3;
		//b3.next = b4;
		//b3.next = a4;
		System.out.println(intList.getIntersectionNodeLeetCode(a, b1));

	}
	public ListNode getIntersectionNode(ListNode a, ListNode b) {
	
		int sizeA=0;
		
		ListNode aa = a;
		//calculate Size
		while(aa!=null){
			sizeA++;
			aa = aa.next;
			
		}
		
		int sizeB=0;
		
		ListNode bb = b;
		//calculate Size
		while(bb!=null){
			sizeB++;
			bb = bb.next;
			
		}
		if(sizeA>sizeB){
			for(int i=0;i<(sizeA-sizeB);i++){
				a = a.next;
			}
		}else if(sizeB>sizeA){
			for(int i=0;i<(sizeB-sizeA);i++){
				b = b.next;
			}
		}
		
		Set<ListNode> set = new HashSet<>();
		while(a!=null || b!=null){
			set.add(a);
			a = a.next;
			if(set.contains(b)){
				return b;
			}
			b=b.next;
		}
		
		return null;
	}
	
	public ListNode getIntersectionNodeLeetCode(ListNode headA, ListNode headB) {
	    //boundary check
	    if(headA == null || headB == null) return null;
	    
	    ListNode a = headA;
	    ListNode b = headB;
	    
	    //if a & b have different len, then we will stop the loop after second iteration
	    while( a != b){
	    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
	        a = a == null? headB : a.next;
	        b = b == null? headA : b.next;    
	    }
	    
	    return a;
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
