package com.practice.algo.and.ds.interviewbit;

import com.practice.algo.and.ds.LinkedLists.Node;

public class LinkedLists_PalindromeList<T> {


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
	

	
	public static void main(String[] args) {
		LinkedLists_PalindromeList<Integer> intList = new LinkedLists_PalindromeList<>();
		intList.insertFirst(1);
		intList.insertFirst(4);
		intList.insertFirst(5);
		intList.insertFirst(4);
		intList.insertFirst(1);
		
		System.out.println(intList.lPalin(intList.head));
		
	}
	
	
	public int getSize(){
		return size;
	}
	


	public int lPalin(ListNode A) {
		if(A==null || A.next==null){
			return 1;
		}
		int size=0;
		
		ListNode singleMover = A;
		//calculate Size
		while(singleMover!=null){
			size++;
			singleMover = singleMover.next;
			
		}
		int firstPartLastElement = 0;
		if(size%2==0){
			firstPartLastElement = size/2-1;
		}else{
			firstPartLastElement = size/2;
		}
		//reverse the second half
		int j=0;
		singleMover = A;
		while(j<firstPartLastElement){
			singleMover = singleMover.next;
			j++;
		}
		ListNode prev = null;
		ListNode next = null;
		ListNode head = singleMover.next;
		while(head !=null){
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		singleMover.next = prev;
		ListNode firstElementSecondPart = singleMover.next;
		while(firstElementSecondPart!=null){
			if(A.val!=firstElementSecondPart.val){
				return 0;
			}
			firstElementSecondPart = firstElementSecondPart.next;
			A = A.next;
		}
		
		return 1;
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
