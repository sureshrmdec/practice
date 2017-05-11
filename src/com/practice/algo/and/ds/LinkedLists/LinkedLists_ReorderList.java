package com.practice.algo.and.ds.LinkedLists;

public class LinkedLists_ReorderList<T> {

	public static void main(String[] args) {
		LinkedLists_ReorderList<Integer> intList = new LinkedLists_ReorderList<>();
		//intList.insertFirst(5);
		intList.insertFirst(4);
		intList.insertFirst(3);
		intList.insertFirst(2);
		intList.insertFirst(1);
		
		intList.reorderList(intList.head);

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

	public static void reorderList(ListNode head) {
		 
		if (head != null && head.next != null) {
 
			ListNode slow = head;
			ListNode fast = head;
 
			//use a fast and slow pointer to break the link to two parts.
			while (fast != null && fast.next != null && fast.next.next!= null) {
				//why need third/second condition?
				System.out.println("pre "+slow.val + " " + fast.val);
				slow = slow.next;
				fast = fast.next.next;
				System.out.println("after " + slow.val + " " + fast.val);
			}
 
			ListNode second = slow.next;
			slow.next = null;// need to close first part
 
			// now should have two lists: head and fast
 
			// reverse order for second part
			second = reverseOrder(second);
 
			ListNode p1 = head;
			ListNode p2 = second;
 
			//merge two lists here
			while (p2 != null) {
				ListNode temp1 = p1.next;
				ListNode temp2 = p2.next;
 
				p1.next = p2;
				p2.next = temp1;		
 
				p1 = temp1;
				p2 = temp2;
			}
		}
	}
 
	public static ListNode reverseOrder(ListNode head) {
 
		if (head == null || head.next == null) {
			return head;
		}
 
		ListNode pre = head;
		ListNode curr = head.next;
 
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
		}
 
		// set head node's next
		head.next = null;
 
		return pre;
	}
 
	public static void printList(ListNode n) {
		System.out.println("------");
		while (n != null) {
			System.out.print(n.val);
			n = n.next;
		}
		System.out.println();
	}
	//Own Implementation
    public void reorderList2(ListNode head) {
    	if(head==null)
    		return;
    	int i= 0;
    	ListNode first = head;
    	while(first!=null){
    		first = first.next;
    		i++;
    	}
    	if(i==2)
    		return;
    	int size = i;
    	if(i%2==0)
    		i = i/2-1;
    	else
    		i = i/2;
    	
    	int j = 1;
    	first = head;
    	ListNode currentI = head;
    	ListNode currentINext = currentI.next;
    	ListNode next = null;
    	while(j<=i){
    		first = currentI;
    		currentINext = currentI.next;
    		next = currentI.next; //save next of cuurentI, for next iteration
    		
    		ListNode prevLast = null;
    		ListNode last = null;
    		while(first.next!=null){
    			prevLast = first;
    			first = first.next;
    		}
    		last = first;
    		prevLast.next = null;
    		currentI.next = last;
    		last.next = currentINext;
    		currentI = next;
    		j++;
    	}
    	
        
    }
}
