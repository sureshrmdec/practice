package com.practice.algo.and.ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heaps_MergeKSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head1 = new ListNode(1);
		ListNode head11 = new ListNode(5);
		ListNode head111 = new ListNode(10);
		head1.next = head11;
		head11.next = head111;
		
		ListNode head2 = new ListNode(4);
		ListNode head21 = new ListNode(11);
		ListNode head211 = new ListNode(13);
		head2.next = head21;
		head21.next = head211;
		
		ListNode head3 = new ListNode(5);
		ListNode head31 = new ListNode(8);
		ListNode head311 = new ListNode(9);
		head3.next = head31;
		head31.next = head311;
		
		ListNode[] lists = new ListNode[3];
		lists[0] = head1;
		lists[1] = head2;
		lists[2] = head3;
		Heaps_MergeKSortedLists o = new Heaps_MergeKSortedLists();
		o.mergeKLists(lists);
	}

	public ListNode mergeKLists(ListNode[] lists) {

		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}
		});
		for(int i=0;i<lists.length;i++){
			pq.add(lists[i]);
		}
		ListNode head = new ListNode(0);
		ListNode p = head;
		while(!pq.isEmpty()){
			ListNode top = pq.poll();
			p.next = top;
			p = p.next;
			if(top.next!=null)
				pq.add(top.next);
		}
		
		return head.next;
	}
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
