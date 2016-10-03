package com.practice.algo.and.ds.LinkedLists;

public class SortLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList linkedList = new LinkedList();
		linkedList.insert(new Node(1));
		linkedList.insert(new Node(5));
		linkedList.insert(new Node(8));
		linkedList.insert(new Node(2));
		linkedList.insert(new Node(3));
		linkedList.insert(new Node(12));
		linkedList.insert(new Node(10));
		linkedList.insert(new Node(4));
		SortLinkedList s = new SortLinkedList();
		linkedList.head = (s.sortList(linkedList.head));
		System.out.println();
	}

	public Node sortList(Node head){
		
		
		if (head == null || head.next == null)
			return head;
		
		Node localHead = head;
		//count
		int count =0;
		while(localHead!=null){
			count++;
			localHead = localHead.next;
		}
		localHead = head;
		Node list1Head = head;
		//find middle of the list
		LinkedList list1 = new LinkedList(),list2 = new LinkedList();
		list1.head = list1Head;  
		int cou = 0;
		Node previous = null;
		while(cou!=count/2){
			previous = localHead;
			localHead = localHead.next;
			cou++;
		}
		list2.head = localHead;
		previous.next = null;
		
		Node h1 = sortList(list1.head);
		Node h2 = sortList(list2.head);
		
		Node merged = merge(h1,h2);
		return merged;
		
	}

	private Node merge(Node h1, Node h2) {
		// TODO Auto-generated method stub
		
		Node fakeHead = new Node(100);
		Node pNew = fakeHead;
		while(h1!=null || h2!=null){
			if (h1 == null) {
				pNew.next = new Node(h2.val);
				h2 = h2.next;
				pNew = pNew.next;
			} else if (h2 == null) {
				pNew.next = new Node(h1.val);
				h1 = h1.next;
				pNew = pNew.next;
			} else {	
			if(h1.val < h2.val){
				pNew.next = new Node(h1.val);
				h1 = h1.next;
				pNew = pNew.next;
			}else if(h1.val == h2.val){
				pNew.next = new Node(h1.val);
				pNew.next.next = new Node(h2.val);;
				pNew = pNew.next.next;
				h2 = h2.next;
				h1 = h1.next;
			}else{
				pNew.next = new Node(h2.val);
				h2 = h2.next;
				pNew = pNew.next;
			}
		}
		}
		return fakeHead.next;
	}
}
