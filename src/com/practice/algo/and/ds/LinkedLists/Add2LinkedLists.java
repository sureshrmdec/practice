package com.practice.algo.and.ds.LinkedLists;


//http://algorithms.tutorialhorizon.com/add-two-numbers-represented-by-a-linked-list-numbers-are-stored-in-forward-order/

public class Add2LinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList one = new LinkedList();
		one.insert(new Node(3));
		one.insert(new Node(2));
		one.insert(new Node(1));
		
		LinkedList two = new LinkedList();
		two.insert(new Node(5));
		two.insert(new Node(4));
		
		int a = makeNumber(one);
		int b = makeNumber(two);
		System.out.println(a+b);
		Node node = makeLinkedList(a+b);
	}

	private static Node makeLinkedList(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private static int makeNumber(LinkedList two) {
		// TODO Auto-generated method stub
		int sum = 0;
		int count = 0;
		Node<Integer> head = two.head;
		while(head!=null){
			head = head.next;
			count++;
		}
		int start = 1;
		for(int i=1;i<count;i++){
			start *=  10;
		}
		
		Node<Integer> current = two.head;
		while(current!=null){
			sum += start * current.val;
			start =  start/10;
			current = current.next;
			
		}
		
		return sum;
	}

}
