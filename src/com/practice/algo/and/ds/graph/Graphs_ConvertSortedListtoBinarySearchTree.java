package com.practice.algo.and.ds.graph;

public class Graphs_ConvertSortedListtoBinarySearchTree {

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		//ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		//ListNode four = new ListNode(4);
		//ListNode five = new ListNode(5);
		//ListNode six = new ListNode(6);
		//ListNode seven = new ListNode(7);
		one.next=three;
		//two.next = three;
		//three.next = four;
		//four.next = five;
		//five.next = six;
		//six.next = seven;
		Graphs_ConvertSortedListtoBinarySearchTree o = new Graphs_ConvertSortedListtoBinarySearchTree();
		o.sortedListToBST(one);
	}
	TreeNode root = null;	
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null)
			return null;
		if(head.next==null)
			return new TreeNode(head.val);
		ListNode front = head;
		ListNode back = head;

		ListNode parentBack = null;
		while(front!=null && front.next!=null){
			parentBack = back;	 
			back = back.next;
			front = front.next.next;

		}
		TreeNode node = new TreeNode(back.val);

		parentBack.next = null;

		node.left = sortedListToBST(head);
		node.right = sortedListToBST(back.next);



		return node;
	}
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

}


