package com.practice.algo.and.ds.LinkedLists;

public class LinkedLists_ReverseLinkListIi<T> {

	public static void main(String[] args) {
		LinkedLists_ReverseLinkListIi<Integer> intList = new LinkedLists_ReverseLinkListIi<>();
		intList.insertFirst(5);
		intList.insertFirst(4);
		intList.insertFirst(3);
		intList.insertFirst(2);
		intList.insertFirst(1);
		
		System.out.println(intList.reverseBetween(intList.head,1,4));
		
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
	public ListNode reverseBetween(ListNode head, int m, int n) {
	    
    if(m==n) return head;
 
    ListNode prev = null;//track (m-1)th node
    ListNode first = new ListNode(0);//first's next points to mth
    ListNode second = new ListNode(0);//second's next points to (n+1)th
 
    int i=0;
    ListNode p = head;
    while(p!=null){
        i++;
        if(i==m-1){
            prev = p;
        }
 
        if(i==m){
            first.next = p;
        }
 
        if(i==n){
            second.next = p.next;
            p.next = null;
        }
 
        p= p.next;
    }
    if(first.next == null)
        return head;
 
    // reverse list [m, n]    
    ListNode p1 = first.next;
    ListNode p2 = p1.next;
    p1.next = second.next;
 
    while(p2!=null){
        ListNode t = p2.next; //store next in t
        p2.next = p1; // reverse the pointers
        p1 = p2; // make p2 p1
        p2 = t;  // and make t p2
    }
 
    //connect to previous part
    if(prev!=null)
        prev.next = p1;
    else
        return p1;
 
    return head;
	}

}
