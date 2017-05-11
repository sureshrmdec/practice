package com.practice.algo.and.ds.interviewbit;

public class LinkedLists_Subtract<T> {

	public static void main(String[] args) {
		LinkedLists_Subtract<Integer> intList = new LinkedLists_Subtract<>();
		intList.insertFirst(7);
		intList.insertFirst(6);
		intList.insertFirst(5);
		intList.insertFirst(4);
		intList.insertFirst(3);
		intList.insertFirst(2);
		intList.insertFirst(1);
		intList.subtract(intList.head);

	}
	private void subtract(ListNode head2) {
		ListNode slow = head2;
		ListNode fast = head2;

		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode secondHalfHead = slow.next;
		slow.next = null;

		//Reverse Second half
		//1 --> 2 ---> 3 --> 4
		ListNode first = secondHalfHead;
		ListNode second = secondHalfHead.next;
		first.next = null;
		ListNode prev = null;
		while(second!=null){
			ListNode t = second.next;
			second.next = first;
			first = second;
			second = t;
		}
		ListNode h = head2;
		ListNode secondIt = first;
		while(secondIt!=null){
			h.val = secondIt.val-h.val;
			h = h.next;
			secondIt = secondIt.next;
		}
		//Reverse again second half

		//1 --> 2 ---> 3 --> 4
		second = first.next;
		first.next = null;
		while(second!=null){
			ListNode t = second.next;
			second.next = first;
			first = second;
			second = t;
		}
		slow.next = first;
		
	


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
}
