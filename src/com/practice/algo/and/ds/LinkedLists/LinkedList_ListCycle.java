package com.practice.algo.and.ds.LinkedLists;



//https://discuss.leetcode.com/topic/19367/java-o-1-space-solution-with-detailed-explanation
public class LinkedList_ListCycle<T> {
	public static void main(String[] args) {
		//LinkedList_ListCycle<Integer> intList = new LinkedList_ListCycle<>();
		//intList.insertFirst(5);
		LinkedList_ListCycle<Integer> o = new LinkedList_ListCycle<>();
		ListNode o1 = new ListNode(1);
		o.head = o1;
		ListNode t2 = new ListNode(2);
		ListNode t3 = new ListNode(3);
		ListNode f4 = new ListNode(4);
		
		o1.next = t2;
		t2.next = t3;
		t3.next = f4;
		f4.next = t2;
		
		System.out.println(o.detectCycle(o.head).val);
	}
	
	public ListNode detectCycle(ListNode head) {
		ListNode result = null;
		ListNode slow = head;
		ListNode fast = head;
		
		while(slow!=null && fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast){//cycle detected
				slow = head;
				while(slow!=fast){
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		
		
		return result;
	
	}
	
	ListNode head;
	
}
